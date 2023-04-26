//needed for api
package api_assets_weather;

//JSON object

public class Location {
    private String name;
    private double lat;
    private double lon;
    private String country;
    private String state;
    
    public String getName() { 
    return this.name; 
    }

    public double getLat() { 
    return this.lat; 
    }

    public double getLon() { 
    return this.lon; 
    }

    public String getCountry() { 
    return this.country; 
    }

    public String getState() { 
    return this.state; 
    }
}
