package connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectionPool implements IConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private static final Properties PROPERTIES = new Properties();

    static {
        try {
            FileReader reader = new FileReader("src/main/resources/database.properties");
            PROPERTIES.load(reader);
        } catch (IOException e) {
            LOGGER.warn(e);
        }
    }
    private String url = PROPERTIES.getProperty("url");
    private String user = PROPERTIES.getProperty("user");
    private String password = PROPERTIES.getProperty("password");
    private static final int INITIAL_POOL_SIZE = 10;
    private static List<Connection> connectionPool = new ArrayList<>(INITIAL_POOL_SIZE);

    private List<Connection> usedConnections = new ArrayList<>();
    private static ConnectionPool INSTANCE = null;

    private ConnectionPool() {
    }

    private ConnectionPool(String url, String user, String password, List<Connection> pool) {
        this.url = url;
        this.user = user;
        this.password = password;
        ConnectionPool.connectionPool = pool;
    }

    public static ConnectionPool getInstance() throws SQLException {
        if (INSTANCE == null) {
            INSTANCE = ConnectionPool.create(PROPERTIES.getProperty("url"), PROPERTIES.getProperty("user"), PROPERTIES.getProperty("password"));
        }
        return INSTANCE;
    }

    private static ConnectionPool create(String url, String user, String password) throws SQLException {
        List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            pool.add(createConnection(url, user, password));
        }
        return new ConnectionPool(url, user, password, pool);
    }

    @Override
    public Connection getConnection() {
        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }

    public void closeAllConnections(ConnectionPool connectionPool) {
        connectionPool.getConnectionPool().forEach((connection) -> {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.warn(e);
            }
        });
    }

    private static Connection createConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public int getSize() {
        return connectionPool.size() + usedConnections.size();
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public List<Connection> getConnectionPool() {
        return connectionPool;
    }
}

