package team_atlas;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * The Main class where the application starts and runs.
 * Handles the switching of panels and database queries.
 * @author Andrzej Baum, Dominik Deak
 */
public class AppHandler {

    /**
     * The window of the application.
     * The application switches panels displayed within the frame.
     */
    static final JFrame MAIN_FRAME = new JFrame("");

    /**
     * The currently logged-in user.
     * If no user is logged-in, the object is null.
     */
    static User currentUser = null;

    /**
     * The main method where the application starts.
     * Starts the login screen.
     * @param args The command line arguments
//     */
    public static void main(String[] args) {
        System.out.println("Application started");
        MAIN_FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MAIN_FRAME.setSize(600, 800);
        MAIN_FRAME.setLocationRelativeTo(null);
        //startLoginScreen();

        User ziomek = new User("jajajaj","ziomek", "ziomek"," ziomek", "user3", true );

        addNewUser(ziomek);
    }

    /**
     * Switches the application to the login panel.
     */
    static void startLoginScreen() {
        LoginScreen loginScreen = new LoginScreen();
        MAIN_FRAME.setContentPane(loginScreen.loginPanel);
        MAIN_FRAME.setTitle("Team Atlas Language App - Login");
        MAIN_FRAME.setVisible(true);
    }

    /**
     * Switches the application to the registration panel.
     */
    static void startRegisterScreen() {
        RegisterScreen registerScreen = new RegisterScreen();
        MAIN_FRAME.setContentPane(registerScreen.registerPanel);
        MAIN_FRAME.setTitle("Team Atlas Language App - Register");
        MAIN_FRAME.setVisible(true);
    }

    /**
     * Switches the application to the pair interaction monitoring panel.
     */
    static void startPairMonitoringScreen() {
        PairMonitoringScreen pairMonitoringScreen = new PairMonitoringScreen();
        MAIN_FRAME.setContentPane(pairMonitoringScreen.pairMonitoringPanel);
        MAIN_FRAME.setTitle("Team Atlas Language App - Pair Interaction History");
        MAIN_FRAME.setVisible(true);
    }

    // TODO Add additional methods to start the other panels

    private static HashMap<String, String> query(String toQuery) {
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

    /**
     * Function to pass INSERT statements to the DB.
     */


    private static void insert(String toQuery) {
        Connection connection = ConnectDatabase.getConnection();
        Statement statement = null;
        //String toFind = toQuery;
        try {
            statement = connection.createStatement();

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


    /**
     * Adds new user
     */


    public static void addNewUser(User newUser){

        String emailAddress = newUser.getEmailAddress();
        String password = newUser.getPassword();
        String firstName = newUser.getFirstName();
        String lastName = newUser.getLastName();
        String userID = newUser.getUserID();
        boolean isTeacherInfo = newUser.isTeacher();
        int isTeacher;

        if(isTeacherInfo == true){
            isTeacher = 1;
        } else{
            isTeacher = 0;
        }

        String Statement = "INSERT INTO RegularUser (\n" +
                "                            EmailAddress,\n" +
                "                            Pass,\n" +
                "                            UserID,\n" +
                "                            FirstName,\n" +
                "                            LastName,\n" +
                "                            IsTeacher\n" +
                "                        )\n" +
                "                        VALUES (\n" +
                "                            '" + emailAddress + "',\n" +
                "                            '" + password + "',\n" +
                "                            '" + userID + "',\n" +
                "                            '" + firstName + "',\n" +
                "                            '" + lastName + "',\n" +
                "                            "+ isTeacher +"\n" +
                "                        );";

        insert(Statement);
    }

    public static ArrayList<String> queryAllIDs() {

        // Gotta finish this part

        return null;
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
        String Statement = "SELECT Context FROM Context";
        return query(Statement);
    }

    public static HashMap<String, String> queryLanguage(String languageID) {
        String toFind = languageID.toUpperCase();
        String Statement = "SELECT lang FROM Lang WHERE languageID='" + toFind + "'";
        return query(Statement);
    }

    public static HashMap<String, String> queryAllLanguages() {
        String Statement = "SELECT lang FROM Lang";
        return query(Statement);
    }

    public static User queryUser(String emailAddress) {
        Connection connection = ConnectDatabase.getConnection();
        Statement statement = null;
        String toQuery = "SELECT * FROM RegularUser WHERE EmailAddress='" + emailAddress + "'";
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
                String userID = rs.getString("UserID");
                boolean isTeacher = rs.getBoolean("IsTeacher");

                return new User(email, pass, fName, lName, userID, isTeacher);
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

    public static User queryUserWithPass(String emailAddress, String password) {
        Connection connection = ConnectDatabase.getConnection();
        Statement statement = null;
        String toQuery = "SELECT * FROM RegularUser WHERE EmailAddress='" + emailAddress + "' AND Pass = '" + password + "'";
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
                String userID = rs.getString("UserID");
                boolean isTeacher = rs.getBoolean("IsTeacher");

                return new User(email, pass, fName, lName, userID, isTeacher);
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
