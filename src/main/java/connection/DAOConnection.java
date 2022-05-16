package connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class DAOConnection {

    private static ConnectionPool connectionPool;
    private static final Logger LOGGER = LogManager.getLogger(DAOConnection.class);

    static {
        try {
            connectionPool = ConnectionPool.getInstance();
        } catch (SQLException e) {
            LOGGER.warn(e);
        }
    }

    public static ConnectionPool getConnectionPool() {
        return connectionPool;
    }

    public static void setConnectionPool(ConnectionPool conn) {
        connectionPool = conn;
    }
}
