package pl.cisekispolka.moodlog.util.database;

import java.sql.SQLException;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.table.TableUtils;

import pl.cisekispolka.moodlog.model.Day;
import pl.cisekispolka.moodlog.model.Emotion;
import pl.cisekispolka.moodlog.model.Entry;
import pl.cisekispolka.moodlog.model.EntryEmotion;

public class DbConnectionSqlite implements DbConnectionInterface {
    private JdbcConnectionSource connectionSource;

    public DbConnectionSqlite(String dbUrl) throws SQLException {
        this.connectionSource = new JdbcConnectionSource("jdbc:sqlite:" + dbUrl);
        this.initDb();
    }

    private void initDb() throws SQLException {
        TableUtils.createTableIfNotExists(this.connectionSource, Emotion.class);
        TableUtils.createTableIfNotExists(this.connectionSource, Day.class);
        TableUtils.createTableIfNotExists(this.connectionSource, Entry.class);
        TableUtils.createTableIfNotExists(this.connectionSource, EntryEmotion.class);
    }

    public JdbcConnectionSource getConnectionSource() {
        return connectionSource;
    }
}
