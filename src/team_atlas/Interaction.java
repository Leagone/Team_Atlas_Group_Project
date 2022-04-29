package team_atlas;

import java.util.Date;

/**
 * The class representing the interaction entities in the database.
 * @author Andrzej Baum
 */
public class Interaction {

    private final String user1Email, user2email, pairID, conversationID, language, level, context, subContext;
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
        Conversation conversation = AppHandler.queryConversation(conversationID);
        this.language = AppHandler.queryLanguage(conversation.getLanguageID()).getLanguage();
        this.level = AppHandler.queryLevel(conversation.getLevelID()).getLevel();
        this.context = AppHandler.queryContext(conversation.getContextID()).getContext();
        this.subContext = AppHandler.querySubContext(conversation.getSubContextID()).getSubContext();
    }

    public String getConversationID() {
        return conversationID;
    }

    public Date getInteractionDateAndTime() {
        return interactionDateAndTime;
    }

    public String getLanguage() {
        return language;
    }

    public String getLevel() {
        return level;
    }

    public String getContext() {
        return context;
    }

    public String getSubContext() {
        return subContext;
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
