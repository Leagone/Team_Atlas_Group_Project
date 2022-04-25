package team_atlas;

public class SubContext {

    private String subContextID;
    private String subContext;

    SubContext(String subContextID, String subContext){
        this.subContextID = subContextID;
        this.subContext = subContext;
    }

    public String getSubContext() {
        return subContext;
    }

}
