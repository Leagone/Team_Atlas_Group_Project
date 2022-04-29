package team_atlas;

/**
 * The class representing the admin entities in the database.
 * @author Dominik Deak
 */
public class Admin {

    private final String emailAddress, password, salt, adminID;

    Admin(String emailAddress, String password, String salt, String adminID) {
        this.emailAddress = emailAddress;
        this.password = password;
        this.salt = salt;
        this.adminID = adminID;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public String getAdminID() {
        return adminID;
    }
}
