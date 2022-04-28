package team_atlas;

import java.util.Date;
import java.util.Random;

/**
 * @author Andrzej Baum, Dominik Deak
 */
public class UserActivity {

    private final String emailAddress;
    private final Date loginTimestamp;
    private final String activityID;
    private Date logoutTimestamp = null;

    UserActivity(String emailAddress) {
        this.emailAddress = emailAddress;
        this.loginTimestamp = new Date();
        activityID = "ua" + new Random().nextInt(10) + (10000000 + new Random().nextInt(90000000));
        // TODO Check if the ID exists in the database
    }

    UserActivity(String emailAddress, Date loginTimestamp ,String activityID ,Date logoutTimestamp) {
        this.emailAddress = emailAddress;
        this.loginTimestamp = loginTimestamp;
        this.activityID = activityID;
        this.logoutTimestamp = logoutTimestamp;
    }

    public void setLogoutTimestamp() {
        this.logoutTimestamp = new Date();
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Date getLoginTimestamp() {
        return loginTimestamp;
    }

    public Date getLogoutTimestamp() {
        return logoutTimestamp;
    }

    public String getActivityID() {
        return activityID;
    }
}
