package com.teamAtlas;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDatabase {

    public static Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            // Create database if it doesn't exist
            String sqliteURL = "jdbc:sqlite:teamAtlas.db";
            Connection sqliteConnection = DriverManager.getConnection(sqliteURL);
            JOptionPane.showMessageDialog(null, "Connection Established");
            return sqliteConnection;
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception);
            return null;
        }
    }
}
