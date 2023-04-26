//Needed for api
package api_assets_weather;
//JSON object
public class City {
    private int id;
    private String name;
    private String country;
    private int population;
    private int timezone;
    private Coord coord;

    public String getName(){ //returns the name of the city
        return this.name;
    }
    public String getCountry(){ //returns the country
        return this.country;
    }
    public int getPopulation(){
        return this.population;
    }
    public int getTime(){   //returns the time zone of the coordinates
        return this.timezone;
    }
}
