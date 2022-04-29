package team_atlas;

/**
 * The class representing the level entities in the database.
 * @author Andrzej Baum
 */
public class Level {

    private final String levelID, level;

    Level(String levelID,String level){
        this.levelID = levelID;
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public String getLevelID() {
        return levelID;
    }
}