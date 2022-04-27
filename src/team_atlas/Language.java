package team_atlas;

public class Language {

    private final String languageID;
    private final String language;

    Language(String languageID, String language){
        this.languageID = languageID;
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }
}
