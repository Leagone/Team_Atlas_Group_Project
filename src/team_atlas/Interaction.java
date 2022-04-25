package team_atlas;

import java.util.Date;

/**
 * @author Andrzej Baum
 */
public class Interaction {

    private final String user1Email;
    private final String user2email;
    private final String pairID;
    private final String conversationID;
    private final Date interactionDateAndTime;
    private final int hintsUsed;
    private final boolean conversationCompleted;

    Interaction(String user1Email, String user2email, String pairID, String conversationID, Date interactionDateAndTime, int hintsUsed, boolean conversationCompleted) {
        this.user1Email = user1Email;
        this.user2email = user2email;
        this.pairID = pairID;
        this.conversationID = conversationID;
        this.interactionDateAndTime = interactionDateAndTime;
        this.hintsUsed = hintsUsed;
        this.conversationCompleted = conversationCompleted;
    }

    public String getConversationID() {
        return conversationID;
    }

    public String getInteractionDateAndTime() {
        return interactionDateAndTime.toString();
    }

    public int getHintsUsed() {
        return hintsUsed;
    }

    public String getEmailAddressUser1() {
        return user1Email;
    }

    public String getEmailAddressUser2() {
        return user2email;
    }

    public String getPairID() {
        return pairID;
    }

    public boolean isConversationCompleted() {
        return conversationCompleted;
    }
}
