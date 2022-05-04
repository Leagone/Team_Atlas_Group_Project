package team_atlas;

/**
 * The class representing the user entities in the database.
 *
 * @author Andrzej Baum, Dominik Deak
 */
public class User {

    private final String emailAddress, password, salt, firstName, lastName, userID;
    private final boolean isTeacher;
    private int experience;

    User(String emailAddress, String password, String salt, String firstName, String lastName, String userID, Boolean isTeacher, int experience) {
        this.emailAddress = emailAddress;
        this.password = password;
        this.salt = salt;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userID = userID;
        this.isTeacher = isTeacher;
        this.experience = experience;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void addExperience(int experience) {
        this.experience = this.experience + experience;
    }

    public int getExperience() {
        return experience;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
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
}
