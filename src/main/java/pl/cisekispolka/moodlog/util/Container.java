package pl.cisekispolka.moodlog.util;

import pl.cisekispolka.moodlog.util.database.DbConnectionInterface;
import pl.cisekispolka.moodlog.util.database.DbConnectionSqlite;

public class Container {
    private static Container instance;
    private DbConnectionInterface dbConnection;

    private Container() throws Exception {
        dbConnection = new DbConnectionSqlite("./database.db");
    }

    public static Container getInstance() throws Exception {
        if (instance == null) {
            instance = new Container();
        }

        return instance;
    }

    public DbConnectionInterface getDbConnection() {
        return dbConnection;
    }
}
