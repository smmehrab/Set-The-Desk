package app.request;

public class RequestHandler {
    private String username;
    private String type;
    
    public RequestHandler(String username,String type) {
        this.username = username;
        this.type = type;
    }           
    
    public String getUsername(){
        return this.username;
    }
    public String getType(){
        return this.type;
    }
}
