package pl.cisekispolka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnectionSqlite implements DbConnectionInterface {
    private Connection connection;

    public DbConnectionSqlite(String dbPath) {
        try {
            this.connection = DriverManager.getConnection(dbPath);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ResultSet query(String sql) throws Exception {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            return resultSet;
        } catch (SQLException e) {
            throw new Exception("Database query error");
        }
    }

}
