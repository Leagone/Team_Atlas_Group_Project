package team_atlas;

/**
 * The admin class holding the following attributes of an admin:
 * email address, password, salt, admin ID.
 * Includes getters for all attributes.
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
