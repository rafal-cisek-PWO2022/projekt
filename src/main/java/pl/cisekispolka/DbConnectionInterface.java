package pl.cisekispolka;

import java.sql.ResultSet;

public interface DbConnectionInterface {
    public ResultSet query(String sql) throws Exception;
}
