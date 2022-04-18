package team_atlas;

import javax.swing.*;
import java.sql.*;
import java.util.HashMap;

public class AppHandler {

    /**
     * The main window of the application
     */
    static final JFrame MAIN_FRAME = new JFrame("");

    public static void main(String[] args) {
        MAIN_FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LoginScreen loginScreen = new LoginScreen();
        MAIN_FRAME.setContentPane(loginScreen.loginPanel);

        MAIN_FRAME.setSize(600, 900);
        MAIN_FRAME.setResizable(false);
        MAIN_FRAME.setLocationRelativeTo(null);
        MAIN_FRAME.setVisible(true);
    }

    public static HashMap<String, String> querySubContext(String subContextID) {
        String toFind = subContextID.toUpperCase();
        String Statement = "SELECT * FROM SubContext WHERE SubContextID='" + toFind + "'";
        return query(Statement);
    }

    public static HashMap<String, String> queryAllSubContext() {
        String Statement = "SELECT * FROM SubContext";
        return query(Statement);
    }

    public static HashMap<String, String> queryAllLevels() {
        String Statement = "Select * from Levels";
        return query(Statement);
    }

    public static HashMap<String, String> queryContext(String contextID) {
        String toFind = contextID.toUpperCase();
        String Statement = "SELECT Context FROM Context WHERE contextID = '" + toFind + "'";
        return query(Statement);
    }

    public static HashMap<String, String> queryAllContext() {
        String Statement = "SELECT Context FROM Context ";
        return query(Statement);
    }

    public static HashMap<String, String> queryLanguage(String languageID) {
        String toFind = languageID.toUpperCase();
        String Statement = "SELECT lang FROM Lang WHERE languageID='" + toFind + "'";
        return query(Statement);
    }

    public static HashMap<String, String> queryAllLanguages() {
        String Statement = "SELECT lang FROM Lang ";
        return query(Statement);
    }

    public static HashMap<String, String> query(String toQuery) {
        Connection connection = ConnectDatabase.getConnection();
        Statement statement = null;
        //String toFind = toQuery;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(toQuery);

            HashMap<String, String> output = new HashMap<>();

            while (resultSet.next()) {
                int numColumns = resultSet.getMetaData().getColumnCount();
                for (int i = 1; i <= numColumns; i++) {

                    output.put(resultSet.getString(1), resultSet.getString(2));
                }
            }
            return output;
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
        return null;
    }

    public static User queryUser(String userID, String password) {
        Connection connection = ConnectDatabase.getConnection();
        Statement statement = null;
        String toQuery = "SELECT * FROM RegularUser WHERE UserID='" + userID + "' AND Pass = '" + password + "'";
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(toQuery);

            if (!rs.isBeforeFirst()) {
                System.out.println("No Data");
                return null;
            } else {
                String email = rs.getString("EmailAddress");
                String pass = rs.getString("Pass");
                String fName = rs.getString("FirstName");
                String lName = rs.getString("LastName");
                String UserId = rs.getString("UserID");
                boolean isTeacher = rs.getBoolean("IsTeacher");

                User user = new User(UserId, pass, email, fName, lName, isTeacher);
                return user;
            }
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
        return null;
    }
}
