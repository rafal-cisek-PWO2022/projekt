package pl.cisekispolka.moodlog.util.database;

import java.sql.ResultSet;

public interface DbConnectionInterface {
    public ResultSet query(String sql) throws Exception;
    public void queryNoReturn(String sql) throws Exception;
}
