package persistence;

import org.sqlite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler {
    private static DBHandler instance = null;

    public static synchronized DBHandler getInstance(String address) throws SQLException {
        if (instance == null)
            instance = new DBHandler(address);
        return instance;
    }

    private Connection connection;

    public Connection getConnection() {
        return this.connection;
    }

    public DBHandler(String address) throws SQLException {
        DriverManager.registerDriver(new JDBC());

        this.connection = DriverManager.getConnection(address);
    }
}