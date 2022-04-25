package team_atlas;

public class Level {

    private String levelID;
    private String level;

    Level(String levelID,String level){
        this.levelID = levelID;
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

}