package jdbc;

import connection.ConnectionPool;
import dao.IAcademicRecordDAO;
import domain.AcademicRecord;

import java.util.List;

import static connection.DAOConnection.getConnectionPool;

public class AcademicRecordDAO implements IAcademicRecordDAO {
    private ConnectionPool connectionPool = getConnectionPool();
    @Override
    public AcademicRecord select(int id) {
        return null;
    }

    @Override
    public List<AcademicRecord> selectAll() {
        return null;
    }

    @Override
    public void insert(AcademicRecord academicRecord) {

    }

    @Override
    public void update(AcademicRecord academicRecord, int id) {

    }

    @Override
    public void delete(AcademicRecord academicRecord) {

    }
}
