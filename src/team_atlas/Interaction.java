package team_atlas;

import java.util.Date;

public class Interaction {

    private String emailAddresUser1;
    private String emailAddresUser2;
    private String pairID;
    private String conversationID;
    private Date interactionDateAndTime;
    private int hintsUsed;
    private boolean ConversationCompleted;


    Interaction(String emailAddresUser1, String emailAddresUser2, String pairID,String conversationID, Date interactionDateAndTime, int hintUsed, boolean conversationCompleted){

        this.emailAddresUser1 = emailAddresUser1;
        this.emailAddresUser2 = emailAddresUser2;
        this.pairID = pairID;
        this.conversationID = conversationID;
        this.interactionDateAndTime = interactionDateAndTime;
        this.hintsUsed = hintsUsed;
        this.ConversationCompleted = conversationCompleted;

    }

    public String getConversationID() {
        return conversationID;
    }

    public boolean isConversationCompleted() {
        return ConversationCompleted;
    }

    public String getInteractionDateAndTime() {
        return interactionDateAndTime.toString();
    }

    public int getHintsUsed() {
        return hintsUsed;
    }

    public String getEmailAddresUser1() {
        return emailAddresUser1;
    }

    public String getEmailAddresUser2() {
        return emailAddresUser2;
    }

    public String getPairID() {
        return pairID;
    }

}
