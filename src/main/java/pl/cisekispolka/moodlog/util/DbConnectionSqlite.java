package pl.cisekispolka.moodlog.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnectionSqlite implements DbConnectionInterface {
    private Connection connection;

    public DbConnectionSqlite(String dbPath) throws Exception {
        try {
            this.connection = DriverManager.getConnection(dbPath);
            initDatabse();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ResultSet query(String sql) throws Exception {
        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        return resultSet;
    }

    private void initDatabse() throws Exception {
        this.queryNoReturn(DbConnectionSqliteInitcode.code());
    }

    @Override
    public void queryNoReturn(String sql) throws Exception {
        Statement statement = this.connection.createStatement();
        statement.executeUpdate(sql);
    }

}
