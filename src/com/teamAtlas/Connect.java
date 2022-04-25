package com.teamAtlas;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    private Connection sqliteConnection;

    public Connect() {
        String sqliteURL = "jdbc:sqlite:teamAtlas.db";

        // Downloading the driver
       // try {
          //  Driver sqliteDriver = new org.sqlite.JDBC();
           // DriverManager.registerDriver(sqliteDriver);            //ERRORS WHEN UNCOMMENTED
           // System.out.println("Driver for SQLite downloaded");
       // } catch (SQLException exception) {
           // System.err.println("Error with driver download: " + exception.getMessage());
       // }

        // Creating the database if it doesn't exist
        try {
            sqliteConnection = DriverManager.getConnection(sqliteURL);
            System.out.println("Connection to SQLite is done");
        } catch (SQLException exception) {
            System.err.println("Error with connecting to SQLite: " + exception.getMessage());
        }

        // Closing the database if it's open
        try {
            if (!sqliteConnection.isClosed()) {
                sqliteConnection.close();
                System.out.println("Connection to SQLite is closed");
            }
        } catch (SQLException exception) {
            System.err.println("Error with closing the connection: " + exception.getMessage());
        }
    }
}
