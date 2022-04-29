package team_atlas;

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
            System.out.println("Connection Established");
            return sqliteConnection;
        } catch (Exception exception) {
            System.err.println("Exception: " + exception);
            JOptionPane.showMessageDialog(null, exception);
            return null;
        }
    }
}
