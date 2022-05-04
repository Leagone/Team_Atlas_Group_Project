package team_atlas;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * The Main class where the application starts and runs.
 * Handles the switching of panels and database insertion/query statements.
 * Holds information about the currently logged-in person.
 *
 * @author Andrzej Baum, Dominik Deak
 */
public class AppHandler {

    /**
     * The window frame of the application.
     * The application switches panels displayed within this frame.
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
     *
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Application started");
        MAIN_FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MAIN_FRAME.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exit();
            }
        });
        MAIN_FRAME.setSize(500, 800);
        MAIN_FRAME.setLocationRelativeTo(null);
        startLoginScreen();
    }

    /**
     * Creates a LoginScreen object and
     * switches the panel in the frame of the application to the login panel.
     */
    static void startLoginScreen() {
        LoginScreen loginScreen = new LoginScreen();
        MAIN_FRAME.setContentPane(loginScreen.loginPanel);
        MAIN_FRAME.setTitle("Team Atlas Language App - Login");
        MAIN_FRAME.setVisible(true);
    }

    /**
     * Creates a RegisterScreen object and
     * switches the panel in the frame of the application to the registration panel.
     */
    static void startRegisterScreen() {
        RegisterScreen registerScreen = new RegisterScreen();
        MAIN_FRAME.setContentPane(registerScreen.registerPanel);
        MAIN_FRAME.setTitle("Team Atlas Language App - Register");
        MAIN_FRAME.setVisible(true);
    }

    /**
     * Creates a StudentHomeScreen object and
     * switches the panel in the frame of the application to the student home panel.
     */
    static void startStudentHomeScreen() {
        StudentHomeScreen studentHomeScreen = new StudentHomeScreen();
        MAIN_FRAME.setContentPane(studentHomeScreen.studentHomePanel);
        MAIN_FRAME.setTitle("Team Atlas Language App - Student Home");
        MAIN_FRAME.setVisible(true);
    }

    /**
     * Creates a TeacherHomeScreen object and
     * switches the panel in the frame of the application to the teacher home panel.
     */
    static void startTeacherHomeScreen() {
        TeacherHomeScreen teacherHomeScreen = new TeacherHomeScreen();
        MAIN_FRAME.setContentPane(teacherHomeScreen.teacherHomePanel);
        MAIN_FRAME.setTitle("Team Atlas Language App - Teacher Home");
        MAIN_FRAME.setVisible(true);
    }

    /**
     * Creates a AdminHomeScreen object and
     * switches the panel in the frame of the application to the admin home panel.
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
     * Switches the application to the context selection panel.
     */
    static void startContextSelectionScreen(String langID) {
        startContextSelectionScreen selectConversation = new startContextSelectionScreen(langID);
        MAIN_FRAME.setContentPane(selectConversation.MainContextSelectionPanel);
        MAIN_FRAME.setTitle("Team Atlas Language App - Context Selection");
        MAIN_FRAME.setVisible(true);
    }

    /**
     * Switches the application to the sub context selection panel.
     */
    static void startSubContextSelectionScreen(ArrayList<Conversation> conversations) {
        startSubContextSelectionScreen selectSubContext = new startSubContextSelectionScreen(conversations);
        MAIN_FRAME.setContentPane(selectSubContext.MainSubConPanel);
        MAIN_FRAME.setTitle("Team Atlas Language App - SubContext Selection");
        MAIN_FRAME.setVisible(true);

    }

    /**
     * Switches the application to the level selection panel.
     */
    static void startLevelSelectionScreen(ArrayList<Conversation> conversations) {
        startLevelSelectionScreen selectLevel = new startLevelSelectionScreen(conversations);
        MAIN_FRAME.setContentPane(selectLevel.MainLevelPanel);
        MAIN_FRAME.setTitle("Team Atlas Language App - Level Selection");
        MAIN_FRAME.setVisible(true);
    }

    static void startUserSelectionScreen(ArrayList<Conversation> conversations) {
        startUserSelectionScreen selectUser = new startUserSelectionScreen(conversations);
        MAIN_FRAME.setContentPane(selectUser.UserSelectionPanel);
        MAIN_FRAME.setTitle("Team Atlas Language App - Level Selection");
        MAIN_FRAME.setVisible(true);
    }

    /**
     * Switches the application to the interaction pair selection panel.
     */
    static void startPairSelectionScreen() {
        // TODO Switch to the interaction pair selection panel
        System.out.println("To be implemented");
    }

    /**
     * Switches the application to the personal student progress analytics panel.
     */
    static void startPersonalProgressScreen() {
        PersonalProgressScreen personalProgressScreen = new PersonalProgressScreen(currentUser);
        MAIN_FRAME.setContentPane(personalProgressScreen.studentProgressPanel);
        MAIN_FRAME.setTitle("Team Atlas Language App - Personal progress");
        MAIN_FRAME.setVisible(true);
    }

    /**
     * Switches the application to the searched student progress analytics panel.
     */
    static void startStudentProgressScreen(String emailAddress) {
        User userToDisplay = AppHandler.queryUser(emailAddress);
        if (userToDisplay != null) {
            PersonalProgressScreen personalProgressScreen = new PersonalProgressScreen(userToDisplay);
            MAIN_FRAME.setContentPane(personalProgressScreen.studentProgressPanel);
            MAIN_FRAME.setTitle("Team Atlas Language App - Student Home");
            MAIN_FRAME.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(MAIN_FRAME, "No such user");
        }
    }

    /**
     * Switches the application to the overall progress analytics panel.
     */
    static void startOverallProgressScreen() {
        // TODO Switch to the overall progress analytics panel
        System.out.println("To be implemented");
    }

    /**
     * Switches the application to the user data monitoring panel.
     */
    static void startUserDataMonitoringScreen(String emailAddress) {
        UserDataMonitoringScreen  selectDataMonitoring = new UserDataMonitoringScreen (emailAddress);
        MAIN_FRAME.setContentPane(selectDataMonitoring.MonitoringPanel);
        MAIN_FRAME.setTitle("Team Atlas Language App - SubContext Selection");
        MAIN_FRAME.setVisible(true);
    }

    /**
     * Creates a PairMonitoringScreen object and
     * switches the panel in the frame of the application to the pair interaction history analytics monitoring panel.
     */
    static void startPairHistoryScreen() {
        PairMonitoringScreen pairMonitoringScreen = new PairMonitoringScreen();
        MAIN_FRAME.setContentPane(pairMonitoringScreen.pairMonitoringPanel);
        MAIN_FRAME.setTitle("Team Atlas Language App - Pair Interaction History");
        MAIN_FRAME.setVisible(true);
    }

    /**
     * Logs the current user or admin out of the application and switches back to the login screen.
     * Sets the logout timestamp for users and saves their user activity into the database.
     * Intended to be called when a logged-in user/admin presses a logout button on a panel.
     */
    static void logout() {
        if (currentUser != null) {
            if (currentUser.isTeacher()) {
                System.out.println("Teacher: '" + currentUser.getEmailAddress() + "' logged out");
            } else {
                System.out.println("Student: '" + currentUser.getEmailAddress() + "' logged out");
            }
            currentActivity.setLogoutTimestamp();
            addActivity(currentActivity);
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
     * Sets the logout timestamp for users and saves their user activity into the database.
     * Intended to be called when a logged-in user/admin closes the application window.
     */
    static void exit() {
        if (currentUser != null) {
            if (currentUser.isTeacher()) {
                System.out.println("Teacher: '" + currentUser.getEmailAddress() + "' exited the application and was logged out");
            } else {
                System.out.println("Student: '" + currentUser.getEmailAddress() + "' exited the application and was logged out");
            }
            currentActivity.setLogoutTimestamp();
            addActivity(currentActivity);
        }
        if (currentAdmin != null) {
            System.out.println("Admin: '" + currentAdmin.getEmailAddress() + "' exited the application and was logged out");
        }
    }

    /**
     * Passes INSERT statements to the database.
     *
     * @param toQuery The INSERT statement to pass
     */
    private static void insert(String toQuery) {
        Connection connection = ConnectDatabase.getConnection();
        Statement statement = null;
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
     * Adds users to the database.
     *
     * @param user The User object to be added
     */
    public static void addUser(User user) {
        String emailAddress = user.getEmailAddress();
        String password = user.getPassword();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String userID = user.getUserID();
        String salt = user.getSalt();
        boolean isTeacher = user.isTeacher();
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
                "" + isTeacher + "," +
                "'" + salt + "'" +
                ");";
        System.out.println(Statement);
        insert(Statement);
    }

    /**
     * Adds user activities to the database.
     *
     * @param activity the UserActivity object to be added
     */
    public static void addActivity(UserActivity activity) {
        Date loginTimeStamp = activity.getLoginTimestamp();
        Date logoutTimeStamp = activity.getLogoutTimestamp();
        String emailAddress = activity.getEmailAddress();
        String ID = activity.getActivityID();
        String Statement = "INSERT INTO UserActivity (" +
                "activityID," +
                "loginTimestamp," +
                "logoutTimestamp," +
                "EmailAddress" +
                ")" +
                " VALUES (" +
                "'" + ID + "'," +
                "'" + loginTimeStamp + "'," +
                "'" + logoutTimeStamp + "'," +
                "'" + emailAddress + "'" +
                ");";
        System.out.println(Statement);
        insert(Statement);
    }

    /**
     * Adds pair interactions to the database.
     *
     * @param interaction the Interaction object to be added
     */
    public static void addInteraction(Interaction interaction) {
        String User1 = interaction.getEmailAddressUser1();
        String User2 = interaction.getEmailAddressUser2();
        String pairID = interaction.getPairID();
        String conversationID = interaction.getConversationID();
        String dateAndTime = interaction.getInteractionDateAndTime().toString();
        int hintsUSed = interaction.getHintsUsed();
        boolean isCompletedInfo = interaction.isConversationCompleted();
        int isCompleted;
        if (isCompletedInfo) {
            isCompleted = 1;
        } else {
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
                "'" + User2 + "'" +
                ");";
        insert(Statement);
    }

    /**
     * Queries a conversation from the database using its ID.
     *
     * @param conversationID The ID of the conversation
     * @return A Conversation object if there is a match, null otherwise
     */
    public static Conversation queryConversation(String conversationID) {
        Connection connection = ConnectDatabase.getConnection();
        Statement statement = null;
        String toFind = conversationID.toUpperCase();
        String toQuery = "SELECT * FROM Conversations WHERE ConversationID='" + toFind + "'";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(toQuery);
            return new Conversation(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8),
                    resultSet.getString(9),
                    resultSet.getString(11),
                    resultSet.getString(10)
            );
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
     * Queries a conversation list from the database using its language.
     *
     * @param langID The ID of the language
     * @return An arraylist of Conversation objects if there is a match, null otherwise
     */
    public static ArrayList<Conversation> queryConversationOfLang(String langID) {
        Connection connection = ConnectDatabase.getConnection();
        Statement statement = null;
        String toFind = langID.toUpperCase();
        String toQuery = "SELECT * FROM Conversations WHERE languageID ='" + toFind + "'";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(toQuery);
            ArrayList<Conversation> output = new ArrayList<>();
            while (resultSet.next()) {
                Conversation temp = new Conversation(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(11),
                        resultSet.getString(10)
                );
                output.add(temp);
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
     * Queries all pair interactions from the database.
     *
     * @return An arraylist of Interaction objects if there are any, null otherwise
     */
    public static ArrayList<Interaction> queryAllInteractions() {
        Connection connection = ConnectDatabase.getConnection();
        Statement statement = null;
        String toQuery = "SELECT * FROM UserConversationInteraction";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(toQuery);
            ArrayList<Interaction> output = new ArrayList<>();
            SimpleDateFormat dateFormat = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            Date date;
            while (resultSet.next()) {
                date = dateFormat.parse(resultSet.getString(4));
                Interaction temp = new Interaction(
                        resultSet.getString(1),
                        resultSet.getString(7),
                        resultSet.getString(3),
                        resultSet.getString(2),
                        date,
                        resultSet.getInt(5),
                        resultSet.getBoolean(6));
                output.add(temp);
            }
            return output;
        } catch (SQLException exception) {
            System.err.println("SQLException: " + exception.getMessage());
        } catch (ParseException exception) {
            System.err.println("ParseException: " + exception.getMessage());
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
     * Queries all pair interactions from the database of particular user.
     *
     * @return An arraylist of Interaction objects if there are any, null otherwise
     */
    public static ArrayList<Interaction> queryAllInteractionsOf(String emailAddress) {
        Connection connection = ConnectDatabase.getConnection();
        Statement statement = null;
        String toQuery = "SELECT * FROM UserConversationInteraction WHERE EmailAddress1='" + emailAddress + "' OR EmailAddress2='" + emailAddress + "' ";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(toQuery);
            ArrayList<Interaction> output = new ArrayList<>();
            SimpleDateFormat dateFormat = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            Date date;
            while (resultSet.next()) {
                date = dateFormat.parse(resultSet.getString(4));
                Interaction temp = new Interaction(
                        resultSet.getString(1),
                        resultSet.getString(7),
                        resultSet.getString(3),
                        resultSet.getString(2),
                        date,
                        resultSet.getInt(5),
                        resultSet.getBoolean(6));
                output.add(temp);
            }
            return output;
        } catch (SQLException exception) {
            System.err.println("SQLException: " + exception.getMessage());
        } catch (ParseException exception) {
            System.err.println("ParseException: " + exception.getMessage());
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
     * Queries all pair interactions from the database using the email addresses of a user pair.
     * The order of the entered email addresses does not matter,
     * as it returns the distinct values from both select statements.
     *
     * @param person1Email The email address of the first user.
     * @param person2Email The email address of the second user.
     * @return An arraylist of Interaction objects if there are any matches, null otherwise
     */
    public static ArrayList<Interaction> queryInteractionsBetween(String person1Email, String person2Email) {
        Connection connection = ConnectDatabase.getConnection();
        Statement statement = null;
        String toQuery = "SELECT * FROM UserConversationInteraction " +
                "WHERE EmailAddress1='" + person1Email + "' AND EmailAddress2='" + person2Email + "' " +
                "UNION " +
                "SELECT * FROM UserConversationInteraction " +
                "WHERE EmailAddress1='" + person2Email + "' AND EmailAddress2='" + person1Email + "'";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(toQuery);
            ArrayList<Interaction> output = new ArrayList<>();
            SimpleDateFormat dateFormat = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            Date date;
            while (resultSet.next()) {
                date = dateFormat.parse(resultSet.getString(4));
                Interaction temp = new Interaction(
                        resultSet.getString(1),
                        resultSet.getString(7),
                        resultSet.getString(3),
                        resultSet.getString(2),
                        date,
                        resultSet.getInt(5),
                        resultSet.getBoolean(6));
                output.add(temp);
            }
            return output;
        } catch (SQLException exception) {
            System.err.println("SQLException: " + exception.getMessage());
        } catch (ParseException exception) {
            System.err.println("ParseException: " + exception.getMessage());
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
     * Queries all user activities from the database.
     *
     * @return An arraylist of UserActivity objects if there are any, null otherwise
     */
    public static ArrayList<UserActivity> queryAllActivity() {
        Connection connection = ConnectDatabase.getConnection();
        Statement statement = null;
        String toQuery = "SELECT * FROM UserActivity";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(toQuery);
            ArrayList<UserActivity> output = new ArrayList<>();
            while (resultSet.next()) {
                UserActivity temp = new UserActivity(
                        resultSet.getString(4),
                        resultSet.getDate(2),
                        resultSet.getString(1),
                        resultSet.getDate(1)

                );
                output.add(temp);
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
     * Queries a user activity from the database using the email address of a user.
     *
     * @param emailAddress The email address of a user.
     * @return A UserActivity object if there is a match, null otherwise
     */
    public static ArrayList<UserActivity> queryActivity(String emailAddress) {
        Connection connection = ConnectDatabase.getConnection();
        Statement statement = null;
        String toFind = emailAddress.toLowerCase();
        String toQuery = "SELECT * FROM UserActivity WHERE EmailAddress='" + toFind + "'";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(toQuery);
            ArrayList<UserActivity> output = new ArrayList<>();
            while (resultSet.next()) {
                UserActivity temp = new UserActivity(
                        resultSet.getString(4),
                        resultSet.getDate(2),
                        resultSet.getString(1),
                        resultSet.getDate(1)

                );
                output.add(temp);
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
     * Queries a sub-context from the database using its ID.
     *
     * @param subContextID The ID of the sub-context
     * @return A SubContext object if there is a match, null otherwise
     */
    public static SubContext querySubContext(String subContextID) {
        Connection connection = ConnectDatabase.getConnection();
        Statement statement = null;
        String toFind = subContextID.toUpperCase();
        String toQuery = "SELECT * FROM SubContext WHERE SubContextID='" + toFind + "'";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(toQuery);
            return new SubContext(
                    resultSet.getString(1),
                    resultSet.getString(2)
            );
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
     * Queries all sub-contexts from the database.
     *
     * @return An arraylist of SubContext objects if there are any, null otherwise
     */
    public static ArrayList<SubContext> queryAllSubContext() {
        Connection connection = ConnectDatabase.getConnection();
        Statement statement = null;
        String toQuery = "SELECT * FROM SubContext";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(toQuery);
            ArrayList<SubContext> output = new ArrayList<>();
            while (resultSet.next()) {
                SubContext temp = new SubContext(
                        resultSet.getString(1),
                        resultSet.getString(2));
                output.add(temp);
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
     * Queries a level from the database using its ID.
     *
     * @param levelID The ID of the level
     * @return A Level object if there is a match, null otherwise
     */
    public static Level queryLevel(String levelID) {
        Connection connection = ConnectDatabase.getConnection();
        Statement statement = null;
        String toFind = levelID.toUpperCase();
        String toQuery = "SELECT * FROM Levels WHERE levelID='" + toFind + "'";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(toQuery);
            return new Level(
                    resultSet.getString(1),
                    resultSet.getString(2)
            );
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
     * Queries all levels from the database.
     *
     * @return An arraylist of Level object if there are any, null otherwise
     */
    public static ArrayList<Level> queryAllLevels() {
        Connection connection = ConnectDatabase.getConnection();
        Statement statement = null;
        String toQuery = "SELECT * FROM Levels";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(toQuery);
            ArrayList<Level> output = new ArrayList<>();
            while (resultSet.next()) {
                Level temp = new Level(
                        resultSet.getString(1),
                        resultSet.getString(2));
                output.add(temp);
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
     * Queries a context from the database using its ID.
     *
     * @param contextID The ID of the context
     * @return A Context object if there is a match, null otherwise
     */
    public static Context queryContext(String contextID) {
        Connection connection = ConnectDatabase.getConnection();
        Statement statement = null;
        String toFind = contextID.toUpperCase();
        String toQuery = "SELECT * FROM Context WHERE contextID = '" + toFind + "'";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(toQuery);
            return new Context(
                    resultSet.getString(1),
                    resultSet.getString(2)
            );
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
     * Queries all contexts from the database.
     *
     * @return An arraylist of Context objects if there are any, null otherwise
     */
    public static ArrayList<Context> queryAllContext() {
        Connection connection = ConnectDatabase.getConnection();
        Statement statement = null;
        String toQuery = "SELECT * FROM Context";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(toQuery);
            ArrayList<Context> output = new ArrayList<>();
            while (resultSet.next()) {
                Context temp = new Context(
                        resultSet.getString(1),
                        resultSet.getString(2));
                output.add(temp);
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
     * Queries a language from the database using its ID.
     *
     * @param languageID The ID of the language
     * @return A Language object if there is a match, null otherwise
     */
    public static Language queryLanguage(String languageID) {
        Connection connection = ConnectDatabase.getConnection();
        Statement statement = null;
        String toFind = languageID.toUpperCase();
        String toQuery = "SELECT * FROM Lang WHERE languageID='" + toFind + "'";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(toQuery);
            return new Language(
                    resultSet.getString(1),
                    resultSet.getString(2)
            );
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
     * Queries all languages from the database.
     *
     * @return An arraylist of Language objects if there are any, null otherwise
     */
    public static ArrayList<Language> queryAllLanguages() {
        Connection connection = ConnectDatabase.getConnection();
        Statement statement = null;
        String toQuery = "SELECT * FROM Lang";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(toQuery);
            ArrayList<Language> output = new ArrayList<>();
            while (resultSet.next()) {
                Language temp = new Language(
                        resultSet.getString(1),
                        resultSet.getString(2));
                output.add(temp);
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

    public static ArrayList<User> queryAllUsers() {
        Connection connection = ConnectDatabase.getConnection();
        Statement statement = null;
        String toQuery = "SELECT * FROM RegularUser";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(toQuery);
            ArrayList<User> output = new ArrayList<>();
            while (resultSet.next()) {
                String email = resultSet.getString("EmailAddress");
                String pass = resultSet.getString("Pass");
                String salt = resultSet.getString("Salt");
                String fName = resultSet.getString("FirstName");
                String lName = resultSet.getString("LastName");
                String userID = resultSet.getString("UserID");
                boolean isTeacher = resultSet.getBoolean("IsTeacher");
                int experience = resultSet.getInt("Experience");
                User temp = new User(email, pass, salt, fName, lName, userID, isTeacher, experience);
                output.add(temp);
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
     * Queries a user from the database using their email address.
     *
     * @param emailAddress The email address of the user
     * @return A User object if there is a match, null otherwise
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
                int experience = rs.getInt("Experience");
                return new User(email, pass, salt, fName, lName, userID, isTeacher, experience);
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
     * Queries a user from the database using their email address and password.
     *
     * @param emailAddress The email address of the user
     * @param password     The password of the user
     * @return A User object if there is a match, null otherwise
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
                int experience = rs.getInt("Experience");
                return new User(email, pass, salt, fName, lName, userID, isTeacher, experience);
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
     * Queries an admin from the database using their email address.
     *
     * @param emailAddress The email address of the admin
     * @return An Admin object if there is a match, null otherwise
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
     * Queries an admin from the database using their email address and password.
     *
     * @param emailAddress The email address of the admin
     * @param password     The password of the admin
     * @return An Admin object if there is a match, null otherwise
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

    /**
     * Queries all user activity IDs from the database.
     *
     * @return An arraylist of strings (activity IDs) if there are any, null otherwise
     */
    public static ArrayList<String> queryAllActivityIDs() {
        Connection connection = ConnectDatabase.getConnection();
        Statement statement = null;
        String toQuery = "SELECT activityID FROM UserActivity";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(toQuery);
            ArrayList<String> output = new ArrayList<>();
            while (resultSet.next()) {
                String temp = resultSet.getString(1);
                output.add(temp);
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
     * Queries all user IDs from the database.
     *
     * @return An arraylist of strings (user IDs) if there are any, null otherwise
     */
    public static ArrayList<String> queryAllUserIDs() {
        Connection connection = ConnectDatabase.getConnection();
        Statement statement = null;
        String toQuery = "SELECT UserID FROM RegularUser";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(toQuery);
            ArrayList<String> output = new ArrayList<>();
            while (resultSet.next()) {
                String temp = resultSet.getString(1);
                output.add(temp);
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
}
