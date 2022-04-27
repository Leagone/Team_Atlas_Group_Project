package team_atlas;

public class Context {

    private final String ContextID;
    private final String Context;

    Context(String ContextID, String Context){
        this.ContextID = ContextID;
        this.Context = Context;
    }

    public String getContext() {
        return Context;
    }
}
