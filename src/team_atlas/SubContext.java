package team_atlas;

/**
 * The class representing the sub-context entities in the database.
 *
 * @author Andrzej Baum
 */
public class SubContext {

    private final String subContextID, subContext;

    SubContext(String subContextID, String subContext) {
        this.subContextID = subContextID;
        this.subContext = subContext;
    }

    public String getSubContext() {
        return subContext;
    }

    public String getSubContextID() {
        return subContextID;
    }
}
