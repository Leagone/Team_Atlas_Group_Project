package team_atlas;

/**
 * The class representing the conversation entities in the database.
 *
 * @author Andrzej Baum
 */
public class Conversation {
    private String ConversationID, languageID, levelID, ContextID, SubContextID, Grammar, KeyVocab, PersonAText, PersonAKey, PersonBText, PersonBKey;

    Conversation(String ConversationID, String languageID, String levelID, String ContextID, String SubContextID,
                 String Grammar, String KeyVocab, String PersonAText, String PersonAKey, String PersonBText, String PersonBKey) {
        this.ConversationID = ConversationID;
        this.languageID = languageID;
        this.levelID = levelID;
        this.ContextID = ContextID;
        this.SubContextID = SubContextID;
        this.Grammar = Grammar;
        this.KeyVocab = KeyVocab;
        this.PersonAText = PersonAText;
        this.PersonAKey = PersonAKey;
        this.PersonBText = PersonBText;
        this.PersonBKey = PersonBKey;

    }

    public String getConversationID() {
        return ConversationID;
    }

    public void setConversationID(String conversationID) {
        ConversationID = conversationID;
    }

    public String getContextID() {
        return ContextID;
    }

    public void setContextID(String contextID) {
        ContextID = contextID;
    }

    public String getGrammar() {
        return Grammar;
    }

    public void setGrammar(String grammar) {
        Grammar = grammar;
    }

    public String getKeyVocab() {
        return KeyVocab;
    }

    public void setKeyVocab(String keyVocab) {
        KeyVocab = keyVocab;
    }

    public String getLanguageID() {
        return languageID;
    }

    public void setLanguageID(String languageID) {
        this.languageID = languageID;
    }

    public String getLevelID() {
        return levelID;
    }

    public void setLevelID(String levelID) {
        this.levelID = levelID;
    }

    public String getPersonAKey() {
        return PersonAKey;
    }

    public void setPersonAKey(String personAKey) {
        PersonAKey = personAKey;
    }

    public String getPersonAText() {
        return PersonAText;
    }

    public void setPersonAText(String personAText) {
        PersonAText = personAText;
    }

    public String getPersonBKey() {
        return PersonBKey;
    }

    public void setPersonBKey(String personBKey) {
        PersonBKey = personBKey;
    }

    public String getPersonBText() {
        return PersonBText;
    }

    public void setPersonBText(String personBText) {
        PersonBText = personBText;
    }

    public String getSubContextID() {
        return SubContextID;
    }

    public void setSubContextID(String subContextID) {
        SubContextID = subContextID;
    }
}
