package team_atlas;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

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

        // TESTS

        // WORKING

        // adding new user
        //User ziomek = new User("jajajaj","ziomek", "ziomek","ziomek", "user3", true,"ziomek" );
        //addNewUser(ziomek);

        // adding new activity
        //java.util.Date d = new java.util.Date();
        //Activity ziomek = new Activity("ziomek@ziomek.pl",d, d, "testID" );
        //addActivity(ziomek);

        // adding new interaction
        //java.util.Date d = new java.util.Date();
        //Interaction ziomek = new Interaction("user1@atlas.com","user2@atlas.com","INTER01","CONV1",d,0,true);
        //addInteraction(ziomek);

        // quering all activity
        //HashMap<String, String> ziomek = querryAllActivity();

        //for (String name: ziomek.keySet()) {
        //    System.out.println(name + " " + ziomek.get(name));
        //}


        // Querying all interactions
        //HashMap<String, String> ziomek = querryAllInteractions();

        //for (String name: ziomek.keySet()) {
        //    System.out.println(name + " " + ziomek.get(name));
        //}

        // Quuerying interaction by user email

        //HashMap<String, String> ziomek = querryInteraction("user2@atlas.com");

        //for (String name: ziomek.keySet()) {
        //    System.out.println(name + " " + ziomek.get(name));
        //}

        // NOT WORKING

        // NON


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
            System.out.println("Inserting");
            System.out.println(toQuery);
            statement = connection.createStatement();
            statement.executeQuery(toQuery);

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
        String salt = newUser.getSalt();
        boolean isTeacherInfo = newUser.isTeacher();
        int isTeacher;

        if(isTeacherInfo == true){
            isTeacher = 1;
        } else{
            isTeacher = 0;
        }

        String Statement = "INSERT INTO RegularUser (" +
                "EmailAddress," +
                "Pass," +
                "UserID," +
                "FirstName," +
                "LastName," +
                "IsTeacher," +
                "Salt" +
                ")" +
                " VALUES (" +
                "'" + emailAddress + "'," +
                "'" + password + "'," +
                "'" + userID + "'," +
                "'" + firstName + "'," +
                "'" + lastName + "'," +
                ""+ isTeacher +"," +
                "'" + salt + "'" +
                ");";

        System.out.println(Statement);

        insert(Statement);
    } // TESTED

    public static void addActivity(Activity activity){

        String loginTimeStamp = activity.getLoginTimeStamp();
        String logutTimeStamp = activity.getLogoutTimeStamp();
        String emailAddres = activity.getEmailAddress();
        String ID = activity.getID();


        String Statement = "INSERT INTO UserActivity (" +
                "activityID," +
                "loginTimestamp," +
                "logoutTimestam," +
                "EmailAddress" +
                ")" +
                " VALUES (" +
                "'" + ID+ "'," +
                "'" + loginTimeStamp + "'," +
                "'" + logutTimeStamp + "'," +
                "'" + emailAddres + "'" +
                ");";


        System.out.println(Statement);

        insert(Statement);



    } // NEW TESTED

    public static void addInteraction(Interaction interaction){

        String User1 = interaction.getEmailAddresUser1();
        String User2 = interaction.getEmailAddresUser2();
        String pairID = interaction.getPairID();
        String conversationID = interaction.getConversationID();
        String dateAndTime = interaction.getInteractionDateAndTime();
        int hintsUSed = interaction.getHintsUsed();
        boolean isCompletedInfo = interaction.isConversationCompleted();


        int isCompleted;

        if(isCompletedInfo == true){
            isCompleted = 1;
        } else{
            isCompleted = 0;
        }

        String Statement = "INSERT INTO UserConversationInteraction (" +
                "EmailAddress1," +
                "ConversationID," +
                "pairID," +
                "interactionDateAndTime," +
                "NumOfHintsUSed," +
                "ConversationCompleted," +
                "EmailAddress2" +
                ")" +
                " VALUES (" +
                "'" + User1 + "'," +
                "'" + conversationID + "'," +
                "'" + pairID + "'," +
                "'" + dateAndTime + "'," +
                "" + hintsUSed + "," +
                "" + isCompleted + "," +
                "'" + User2 +"'" +
                ");";

        insert(Statement);




    } // NEW TESTED

    public static HashMap<String, String> querryAllInteractions(){

        String Statement = "SELECT * FROM UserConversationInteraction";
        return query(Statement);

    } // NEW TESTED

    public static HashMap<String, String> querryInteraction(String emailAddres){

        String toFind = emailAddres.toLowerCase();
        String Statement = "SELECT * FROM UserConversationInteraction WHERE EmailAddress1='" + toFind + "' OR EmailAddress2='" + toFind + "'";
        return query(Statement);

    } // NEW TESTED

    public static HashMap<String, String> querryAllActivity(){

        String Statement = "SELECT * FROM UserActivity";
        return query(Statement);

    } // NEW TESTED

    public static HashMap<String, String> querryActivity(String emailAddres){

        String toFind = emailAddres.toLowerCase();
        String Statement = "SELECT * FROM UserActivity WHERE EmailAddress='" + toFind + "'";
        return query(Statement);

    } // NEW TESTED

    public static HashMap<String, String> querySubContext(String subContextID) {
        String toFind = subContextID.toUpperCase();
        String Statement = "SELECT * FROM SubContext WHERE SubContextID='" + toFind + "'";
        return query(Statement);
    } // TESTED

    public static HashMap<String, String> queryAllSubContext() {
        String Statement = "SELECT * FROM SubContext";
        return query(Statement);
    } // TESTED

    public static HashMap<String, String> queryAllLevels() {
        String Statement = "Select * from Levels";
        return query(Statement);
    } // TESTED

    public static HashMap<String, String> queryContext(String contextID) {
        String toFind = contextID.toUpperCase();
        String Statement = "SELECT Context FROM Context WHERE contextID = '" + toFind + "'";
        return query(Statement);
    } // TESTED

    public static HashMap<String, String> queryAllContext() {
        String Statement = "SELECT Context FROM Context";
        return query(Statement);
    } // TESTED

    public static HashMap<String, String> queryLanguage(String languageID) {
        String toFind = languageID.toUpperCase();
        String Statement = "SELECT lang FROM Lang WHERE languageID='" + toFind + "'";
        return query(Statement);
    } // TESTED

    public static HashMap<String, String> queryAllLanguages() {
        String Statement = "SELECT lang FROM Lang";
        return query(Statement);
    } // TESTED

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
                String salt = rs.getString("Salt");

                return new User(email, pass, fName, lName, userID, isTeacher, salt);
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
    } // TESTED

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
                String salt = rs.getString("Salt");
                boolean isTeacher = rs.getBoolean("IsTeacher");

                return new User(email, pass, fName, lName, userID, isTeacher, salt);
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
    } // TESTED
}
