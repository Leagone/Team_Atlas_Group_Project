package team_atlas;

import java.util.Date;

public class Activity {

    private Date loginTimestamp;
    private Date logoutTimestamp;
    private String activityID;
    private String emailAddres;

    /**
     * Suggestion:
     *  Whenever user login :
     *      loginTimestamp Date object is created and stored
     *      emailAddress is stored
     *
     * When user logs out:
     *      logoutTimestamp Date object is created and stored
     *
     * Then all three are passed to the Activity object constructor
     *
     */


    Activity(String emailAddres, Date loginTimestamp, Date logoutTimestamp, String activityID) {

        this.emailAddres = emailAddres;
        this.loginTimestamp = loginTimestamp;
        this.logoutTimestamp = logoutTimestamp;
        this.activityID =activityID;


        // Gotta create ID somehow


    }

    public String getLoginTimeStamp(){
        return loginTimestamp.toString();
    }

    public String getLogoutTimeStamp(){
        return logoutTimestamp.toString();
    }

    public String getEmailAddress(){
        return emailAddres;
    }

    public String getID(){
        return activityID;
    }



}
