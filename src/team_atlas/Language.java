package team_atlas;

public class Language {

    private String laguageID;
    private String laguage;

    Language(String laguageID, String laguage){
        this.laguageID = laguageID;
        this.laguage = laguage;
    }

    public String getLanguage() {
        return laguage;
    }

}