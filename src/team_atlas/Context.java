package team_atlas;

public class Context {

    private String ContextID;
    private String Context;

    Context(String ContextID, String Context){
        this.ContextID = ContextID;
        this.Context = Context;
    }

    public String getContext() {
        return Context;
    }

}