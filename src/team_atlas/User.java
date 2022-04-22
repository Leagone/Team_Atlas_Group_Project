package team_atlas;

/**
 * The User class holding all attributes of a user.
 * Includes getters for all attributes.
 * @author Andrzej Baum, Dominik Deak
 */
public class User {

    private final String password, emailAddress, firstName, lastName, userID, salt;
    private final boolean isTeacher;

    User(String emailAddress, String password, String firstName, String lastName, String userID, Boolean isTeacher, String salt) {
        this.emailAddress = emailAddress;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userID = userID;
        this.isTeacher = isTeacher;
        this.salt = salt;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserID() {
        return userID;
    }

    public boolean isTeacher() {
        return isTeacher;
    }

    public String getSalt() {
        return salt;
    }
}
