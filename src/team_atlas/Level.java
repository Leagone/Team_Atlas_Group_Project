package team_atlas;

public class Level {

    private final String levelID;
    private final String level;

    Level(String levelID,String level){
        this.levelID = levelID;
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}
