//needed for api
package api_assets_weather;

//JSON object

public class Sys {
    public String pod;
    
    public String getPod(){ //returns the part of the day (day [d], night [n])
        return this.pod;
    }
}
