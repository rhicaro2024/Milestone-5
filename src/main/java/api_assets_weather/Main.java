//needed for api
package api_assets_weather;

//JSON object

public class Main {
    private double temp;
    private double temp_min;
    private double temp_max;
    private int humidity;

    public double getTemp(){ //returns the current temperature
        return this.temp;
    }   
    public double getTemp_min(){ //returns the min temperature
        return this.temp_min;
    }
    public double getTemp_max(){ //returns the max temperature
        return this.temp_max;
    }
    
    public int getHumidity(){
        return this.humidity;
    }
}
