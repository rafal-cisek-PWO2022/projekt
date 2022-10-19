package pl.cisekispolka.moodlog.util;

public class Container {
    private static Container instance;
    private DbConnectionInterface dbConnection;

    private Container() {
        dbConnection = new DbConnectionSqlite("jdbc:sqlite:./database.db");
    }

    public static Container getInstance() {
        if (instance == null) {
            instance = new Container();
        }

        return instance;
    }

    DbConnectionInterface getDbConnection() {
        return dbConnection;
    }
}
