package api_assets_weather;

//JSON object

public class Weather {
    private int id;
    private String main;
    private String description;
    private String icon;

    public int getId(){
        return this.id;
    }
    public String getMain(){
        return this.main;
    }
    public String getDescription(){ //returns a description of the current weater
        return this.description;
    }
    public String getIcon(){ //returns an icon of the weather probablt through url
        return this.icon;
    }        
}
