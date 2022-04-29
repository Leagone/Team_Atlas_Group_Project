package team_atlas;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * @author Andrzej Baum, Dominik Deak
 */
public class UserActivity {

    private final String emailAddress;
    private final Date loginTimestamp;
    private String activityID;
    private Date logoutTimestamp = null;

    UserActivity(String emailAddress) {
        this.emailAddress = emailAddress;
        loginTimestamp = new Date();
        ArrayList<String> existingIDs = AppHandler.queryAllActivityIDs();
        if (existingIDs != null) {
            do {
                activityID = "ua" + new Random().nextInt(10) + (10000000 + new Random().nextInt(90000000));
            } while (existingIDs.contains(activityID));
        } else {
            activityID = "ua" + new Random().nextInt(10) + (10000000 + new Random().nextInt(90000000));
        }
    }

    UserActivity(String emailAddress, Date loginTimestamp ,String activityID ,Date logoutTimestamp) {
        this.emailAddress = emailAddress;
        this.loginTimestamp = loginTimestamp;
        this.activityID = activityID;
        this.logoutTimestamp = logoutTimestamp;
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
