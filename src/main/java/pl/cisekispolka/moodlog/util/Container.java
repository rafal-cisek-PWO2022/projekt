package pl.cisekispolka.moodlog.util;

public class Container {
    private static Container instance;
    private DbConnectionInterface dbConnection;

    private Container() throws Exception {
        dbConnection = new DbConnectionSqlite("jdbc:sqlite:./database.db");
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
