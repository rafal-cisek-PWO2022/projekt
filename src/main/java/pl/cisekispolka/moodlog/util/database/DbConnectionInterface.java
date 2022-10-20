package pl.cisekispolka.moodlog.util.database;

import com.j256.ormlite.jdbc.JdbcConnectionSource;

public interface DbConnectionInterface {
    public JdbcConnectionSource getConnectionSource();
}
