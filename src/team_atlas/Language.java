package team_atlas;

/**
 * The class representing the language entities in the database.
 * @author Andrzej Baum
 */
public class Language {

    private final String languageID, language;

    Language(String languageID, String language){
        this.languageID = languageID;
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public String getLanguageID() {
        return languageID;
    }
}
