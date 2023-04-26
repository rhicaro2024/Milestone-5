//needed for api
package api_assets_weather;

//JSON object
//

public class Response { //same as json format
    private String cod;
    private int message;
    private int cnt;
    private Info[] list; 
    private City city;
    
    public String getCod(){
        return this.cod;
    }
    public int getMsg(){
        return this.message;
    }
    public int getCnt(){
        return this.cnt;
    }
    public Info[] getList(){
        return this.list;
    }
    public City getCity(){
        return this.city;
    }
}
