package team_atlas;

import javax.swing.*;
import java.sql.*;
import java.util.HashMap;

// TODO Get rid of all warnings
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
     * The currently logged-in admin.
     * If no admin is logged-in, the object is null.
     */
    static Admin currentAdmin = null;

    /**
     * The currently logged-in user.
     * If no user is logged-in, the object is null.
     */
    static User currentUser = null;

    /**
     * The activity of the current user.
     */
    static UserActivity currentActivity = null;

    /**
     * The main method where the application starts.
     * Starts the login screen upon launching the app.
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Application started");
        MAIN_FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MAIN_FRAME.setSize(500, 800);
        MAIN_FRAME.setLocationRelativeTo(null);
        //startLoginScreen();
        //startLangSelectionScreen();
        selectionScreen();

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
     * Switches the application to the student home panel.
     */
    static void startStudentHomeScreen() {
        StudentHomeScreen studentHomeScreen = new StudentHomeScreen();
        MAIN_FRAME.setContentPane(studentHomeScreen.studentHomePanel);
        MAIN_FRAME.setTitle("Team Atlas Language App - Student Home");
        MAIN_FRAME.setVisible(true);
    }

    /**
     * Switches the application to the teacher home panel.
     */
    static void startTeacherHomeScreen() {
        TeacherHomeScreen teacherHomeScreen = new TeacherHomeScreen();
        MAIN_FRAME.setContentPane(teacherHomeScreen.teacherHomePanel);
        MAIN_FRAME.setTitle("Team Atlas Language App - Teacher Home");
        MAIN_FRAME.setVisible(true);
    }

    /**
     * Switches the application to the admin home panel.
     */
    static void startAdminHomeScreen() {
        AdminHomeScreen adminHomeScreen = new AdminHomeScreen();
        MAIN_FRAME.setContentPane(adminHomeScreen.adminHomePanel);
        MAIN_FRAME.setTitle("Team Atlas Language App - Admin Home");
        MAIN_FRAME.setVisible(true);
    }

    /**
     * Switches the application to the language selection panel.
     */
    static void startLangSelectionScreen() {
        LanguageScreen languageScreen = new LanguageScreen();
        MAIN_FRAME.setContentPane(languageScreen.MainLangPanel);
        MAIN_FRAME.setTitle("Team Atlas Language App - Language Selection");
        MAIN_FRAME.setVisible(true);
    }

    /**
     * Switches the application to the level/context/sub-context selection panel.
     */
    static void selectionScreen() {
        SelectScreen selectScreen = new SelectScreen();
        MAIN_FRAME.setContentPane(selectScreen.Main);
        MAIN_FRAME.setTitle("Team Atlas Language App - Selection Screen");
        MAIN_FRAME.setVisible(true);
    }

    /**
     * Switches the application to the interaction pair selection panel.
     */
    static void startPairSelectionScreen() {
        // TODO Switch to the interaction pair selection panel
    }

    /**
     * Switches the application to the personal student progress analytics panel.
     */
    static void startPersonalProgressScreen() {
        // TODO Switch to the personal student progress analytics panel
    }

    /**
     * Switches the application to the searched student progress analytics panel.
     */
    static void startStudentProgressScreen() {
        // TODO Switch the application to the searched student progress analytics panel
    }

    /**
     * Switches the application to the overall progress analytics panel.
     */
    static void startOverallProgressScreen() {
        // TODO Switch to the overall progress analytics panel
    }

    /**
     * Switches the application to the user data monitoring panel.
     */
    static void startUserDataMonitoringScreen() {
        // TODO Switch to the user data monitoring panel
    }

    /**
     * Logs the current user or admin out of the application and switches back to the login screen.
     * Sets the logout timestamp for users and saves their user activity into the database.
     */
    static void logout() {
        if (currentUser != null) {
            if (currentUser.isTeacher()) {
                System.out.println("Teacher: '" + currentUser.getEmailAddress() + "' logged out");
            } else {
                System.out.println("Student: '" + currentUser.getEmailAddress() + "' logged out");
            }
            currentActivity.setLogoutTimestamp();
            // TODO Save activity into database
            currentUser = null;
            currentActivity = null;
            startLoginScreen();
        }
        if (currentAdmin != null) {
            System.out.println("Admin: '" + currentAdmin.getEmailAddress() + "' logged out");
            currentAdmin = null;
            startLoginScreen();
        }
    }

    /**
     * Switches the application to the pair interaction history monitoring panel.
     */
    static void startPairHistoryScreen() {
        PairMonitoringScreen pairMonitoringScreen = new PairMonitoringScreen();
        MAIN_FRAME.setContentPane(pairMonitoringScreen.pairMonitoringPanel);
        MAIN_FRAME.setTitle("Team Atlas Language App - Pair Interaction History");
        MAIN_FRAME.setVisible(true);
    }

    /**
     * Passes SELECT statements to the database.
     * @param toQuery The SELECT statement to pass
     */
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
     * Passes INSERT statements to the database.
     * @param toQuery The INSERT statement to pass
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
     * Adds users to the database.
     * @param user The user object to be added to the database
     */
    public static void addUser(User user) {
        String emailAddress = user.getEmailAddress();
        String password = user.getPassword();
        String salt = user.getSalt();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String userID = user.getUserID();
        boolean isTeacher = user.isTeacher();
        int isTeacherInt;

        if (isTeacher) {
            isTeacherInt = 1;
        } else {
            isTeacherInt = 0;
        }

        String statement = "INSERT INTO RegularUser (\n" +
                "                            EmailAddress,\n" +
                "                            Pass,\n" +
                "                            Salt,\n" +
                "                            UserID,\n" +
                "                            FirstName,\n" +
                "                            LastName,\n" +
                "                            IsTeacher\n" +
                "                        )\n" +
                "                        VALUES (\n" +
                "                            '" + emailAddress + "',\n" +
                "                            '" + password + "',\n" +
                "                            '" + salt + "',\n" +
                "                            '" + userID + "',\n" +
                "                            '" + firstName + "',\n" +
                "                            '" + lastName + "',\n" +
                "                            "+ isTeacherInt +"\n" +
                "                        );";
        insert(statement);
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

    /**
     * Finds a user with a certain email address in the database.
     * @param emailAddress The email address of the user
     * @return A user object of the found user, null if no user is found
     */
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
                String salt = rs.getString("Salt");
                String fName = rs.getString("FirstName");
                String lName = rs.getString("LastName");
                String userID = rs.getString("UserID");
                boolean isTeacher = rs.getBoolean("IsTeacher");

                return new User(email, pass, salt, fName, lName, userID, isTeacher);
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

    /**
     * Finds a user with a certain email address and password in the database.
     * @param emailAddress The email address of the user
     * @param password The password of the user
     * @return A user object of the found user, null if no user is found
     */
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
                String salt = rs.getString("Salt");
                String fName = rs.getString("FirstName");
                String lName = rs.getString("LastName");
                String userID = rs.getString("UserID");
                boolean isTeacher = rs.getBoolean("IsTeacher");

                return new User(email, pass, salt, fName, lName, userID, isTeacher);
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

    /**
     * Finds an admin with a certain email address in the database.
     * @param emailAddress The email address of the admin
     * @return An admin object of the found admin, null if no admin is found
     */
    public static Admin queryAdmin(String emailAddress) {
        Connection connection = ConnectDatabase.getConnection();
        Statement statement = null;
        String toQuery = "SELECT * FROM Administrator WHERE EmailAddress='" + emailAddress + "'";
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(toQuery);

            if (!rs.isBeforeFirst()) {
                System.out.println("No Data");
                return null;
            } else {
                String email = rs.getString("EmailAddress");
                String pass = rs.getString("Pass");
                String salt = rs.getString("Salt");
                String adminID = rs.getString("AdminID");

                return new Admin(email, pass, salt, adminID);
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

    /**
     * Finds an admin with a certain email address and password in the database.
     * @param emailAddress The email address of the admin
     * @param password The password of the admin
     * @return An admin object of the found admin, null if no admin is found
     */
    public static Admin queryAdminWithPass(String emailAddress, String password) {
        Connection connection = ConnectDatabase.getConnection();
        Statement statement = null;
        String toQuery = "SELECT * FROM Administrator WHERE EmailAddress='" + emailAddress + "' AND Pass = '" + password + "'";
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(toQuery);
            if (!rs.isBeforeFirst()) {
                System.out.println("No Data");
                return null;
            } else {
                String email = rs.getString("EmailAddress");
                String pass = rs.getString("Pass");
                String salt = rs.getString("Salt");
                String adminID = rs.getString("AdminID");

                return new Admin(email, pass, salt, adminID);
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
