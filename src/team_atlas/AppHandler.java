package team_atlas;

import javax.swing.*;
import java.sql.*;

public class AppHandler {
    static final JFrame MAIN_FRAME = new JFrame(""); // The main window of the application

    public static void main(String[] args) {
        MAIN_FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LoginScreen loginScreen = new LoginScreen();
        MAIN_FRAME.setContentPane(loginScreen.loginPanel);

        MAIN_FRAME.setSize(600, 900);
        MAIN_FRAME.setResizable(false);
        MAIN_FRAME.setLocationRelativeTo(null);
        MAIN_FRAME.setVisible(true);
    }

    public static void queryAllLevels() {
        Connection connection = ConnectDatabase.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select Lvl from Levels");
            while (resultSet.next()) {
                int numColumns = resultSet.getMetaData().getColumnCount();
                for (int i = 1; i <= numColumns; i++) {
                    System.out.print(" " + resultSet.getObject(i));
                }
                System.out.println();
            }
            resultSet.close();
        } catch (SQLException exception) {
            System.err.println("SQLException: " + exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    System.err.println("SQLException: " + exception.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException exception) {
                    System.err.println("SQLException: " + exception.getMessage());
                }
            }
        }
    }

    public static void queryContext(String ContextID) {
        Connection connection = ConnectDatabase.getConnection();
        Statement statement = null;
        String toFind = ContextID;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT Context FROM Context WHERE contextID = '"+ toFind+"'");

            while (resultSet.next()) {
                int numColumns = resultSet.getMetaData().getColumnCount();
                for (int i = 1; i <= numColumns; i++) {
                    System.out.print(" " + resultSet.getObject(i));
                }
                System.out.println();
            }
            resultSet.close();
        } catch (SQLException exception) {
            System.err.println("SQLException: " + exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    System.err.println("SQLException: " + exception.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException exception) {
                    System.err.println("SQLException: " + exception.getMessage());
                }
            }
        }
    }

    public static void queryAllContexts() {
        Connection connection = ConnectDatabase.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT Context FROM Context ");

            while (resultSet.next()) {
                int numColumns = resultSet.getMetaData().getColumnCount();
                for (int i = 1; i <= numColumns; i++) {
                    System.out.print(" " + resultSet.getObject(i));
                }
                System.out.println();
            }
            resultSet.close();
        } catch (SQLException exception) {
            System.err.println("SQLException: " + exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    System.err.println("SQLException: " + exception.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException exception) {
                    System.err.println("SQLException: " + exception.getMessage());
                }
            }
        }
    }

    public static void queryAllLanguages() {
        Connection connection = ConnectDatabase.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT lang FROM Lang ");

            while (resultSet.next()) {
                int numColumns = resultSet.getMetaData().getColumnCount();
                for (int i = 1; i <= numColumns; i++) {
                    System.out.print(" " + resultSet.getObject(i));
                }
                System.out.println();
            }
            resultSet.close();
        } catch (SQLException exception) {
            System.err.println("SQLException: " + exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    System.err.println("SQLException: " + exception.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException exception) {
                    System.err.println("SQLException: " + exception.getMessage());
                }
            }
        }
    }

    public static void queryLanguage(String languageID) {
        Connection connection = ConnectDatabase.getConnection();
        Statement statement = null;
        String toFind = languageID;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT lang FROM Lang WHERE languageID='"+ toFind +"'");

            while (resultSet.next()) {
                int numColumns = resultSet.getMetaData().getColumnCount();
                for (int i = 1; i <= numColumns; i++) {
                    System.out.print(" " + resultSet.getObject(i));
                }
                System.out.println();
            }
            resultSet.close();
        } catch (SQLException exception) {
            System.err.println("SQLException: " + exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    System.err.println("SQLException: " + exception.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException exception) {
                    System.err.println("SQLException: " + exception.getMessage());
                }
            }
        }
    }

    public static void queryAllSubContexts() {
        Connection connection = ConnectDatabase.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT SubContext FROM SubContext");

            while (resultSet.next()) {
                int numColumns = resultSet.getMetaData().getColumnCount();
                for (int i = 1; i <= numColumns; i++) {
                    System.out.print(" " + resultSet.getObject(i));
                }
                System.out.println();
            }
            resultSet.close();
        } catch (SQLException exception) {
            System.err.println("SQLException: " + exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    System.err.println("SQLException: " + exception.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException exception) {
                    System.err.println("SQLException: " + exception.getMessage());
                }
            }
        }
    }

    public static void querySubcontext(String SubcontextID) {
        Connection connection = ConnectDatabase.getConnection();
        Statement statement = null;
        String toFind = SubcontextID;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT SubContext FROM SubContext WHERE SubContext='"+ toFind +"'");

            while (resultSet.next()) {
                int numColumns = resultSet.getMetaData().getColumnCount();
                for (int i = 1; i <= numColumns; i++) {
                    System.out.print(" " + resultSet.getObject(i));
                }
                System.out.println();
            }
            resultSet.close();
        } catch (SQLException exception) {
            System.err.println("SQLException: " + exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    System.err.println("SQLException: " + exception.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException exception) {
                    System.err.println("SQLException: " + exception.getMessage());
                }
            }
        }
    }
}
