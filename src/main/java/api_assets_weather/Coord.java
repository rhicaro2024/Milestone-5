//needed for api
package api_assets_weather;

//JSON object

public class Coord { //same as json now
    private double lat;
    private double lon;

    public double getLat(){ //returns the latitude
        return this.lat;
    }

    public double getLon(){ //returns the longitude
        return this.lon;
    }
}
