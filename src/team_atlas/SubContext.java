package team_atlas;

public class SubContext {

    private final String subContextID;
    private final String subContext;

    SubContext(String subContextID, String subContext){
        this.subContextID = subContextID;
        this.subContext = subContext;
    }

    public String getSubContext() {
        return subContext;
    }
}
