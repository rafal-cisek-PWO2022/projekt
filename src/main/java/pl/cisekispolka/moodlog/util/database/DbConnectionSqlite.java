package pl.cisekispolka.moodlog.util.database;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnectionSqlite implements DbConnectionInterface {
    private Connection connection;
    private String dbPath;

    public DbConnectionSqlite(String dbPath) throws Exception {
        this.dbPath = dbPath;
        this.connection = DriverManager.getConnection("jdbc:sqlite:" + this.dbPath);
        initDatabse();
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

    public void resetDatabase() throws SQLException, IOException {
        this.connection.close();
        Path path = FileSystems.getDefault().getPath(this.dbPath);
        Files.delete(path);
        this.connection = DriverManager.getConnection("jdbc:sqlite:" + this.dbPath);
    }

    @Override
    public void queryNoReturn(String sql) throws Exception {
        Statement statement = this.connection.createStatement();
        statement.executeUpdate(sql);
    }

}
