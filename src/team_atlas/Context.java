package team_atlas;

/**
 * The class representing the context entities in the database.
 * @author Andrzej Baum
 */
public class Context {

    private final String ContextID, Context;

    Context(String ContextID, String Context){
        this.ContextID = ContextID;
        this.Context = Context;
    }

    public String getContext() {
        return Context;
    }

    public String getContextID() {
        return ContextID;
    }
}