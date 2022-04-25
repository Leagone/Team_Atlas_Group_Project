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
        loginTimestamp = new Date();
        activityID = "ua" + new Random().nextInt(10) + (10000000 + new Random().nextInt(90000000));
        // TODO Check if the ID exists in the database
    }

    public void setLogoutTimestamp() {
        logoutTimestamp = new Date();
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
