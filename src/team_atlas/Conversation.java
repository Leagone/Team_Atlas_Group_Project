package team_atlas;

/**
 * The class representing the conversation entities in the database.
 * @author Andrzej Baum
 */
public class Conversation {
    private String ConversationID, languageID, levelID, ContextID, SubContextID, Grammar, KeyVocab, PersonAText, PersonAKey, PersonBText, PersonBKey;

    Conversation(String ConversationID, String languageID ,String levelID ,String ContextID, String SubContextID,
                 String Grammar ,String KeyVocab, String PersonAText ,String PersonAKey ,String PersonBText ,String PersonBKey) {
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

    public String getContextID() {
        return ContextID;
    }

    public String getGrammar() {
        return Grammar;
    }

    public String getKeyVocab() {
        return KeyVocab;
    }

    public String getLanguageID() {
        return languageID;
    }

    public String getLevelID() {
        return levelID;
    }

    public String getPersonAKey() {
        return PersonAKey;
    }

    public String getPersonAText() {
        return PersonAText;
    }

    public String getPersonBKey() {
        return PersonBKey;
    }

    public String getPersonBText() {
        return PersonBText;
    }

    public String getSubContextID() {
        return SubContextID;
    }

    public void setConversationID(String conversationID) {
        ConversationID = conversationID;
    }

    public void setContextID(String contextID) {
        ContextID = contextID;
    }

    public void setGrammar(String grammar) {
        Grammar = grammar;
    }

    public void setKeyVocab(String keyVocab) {
        KeyVocab = keyVocab;
    }

    public void setLanguageID(String languageID) {
        this.languageID = languageID;
    }

    public void setLevelID(String levelID) {
        this.levelID = levelID;
    }

    public void setPersonAKey(String personAKey) {
        PersonAKey = personAKey;
    }

    public void setPersonAText(String personAText) {
        PersonAText = personAText;
    }

    public void setPersonBKey(String personBKey) {
        PersonBKey = personBKey;
    }

    public void setPersonBText(String personBText) {
        PersonBText = personBText;
    }

    public void setSubContextID(String subContextID) {
        SubContextID = subContextID;
    }
}
