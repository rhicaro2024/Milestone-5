package classes;
import api_assets_weather.Response;
/**
 * Weather Information is the subject in this observer pattern
 * 
 */
public abstract class WeatherAPICall{
    public abstract String cityCall(Response weatherData);
    public abstract String countryCall(Response weatherData);
    public abstract double tempCall(Response weatherData, int index);
    public abstract double tempCallHigh(Response weatherData, int index);
    public abstract double tempCallLow(Response weatherData, int index);
    public abstract String dateCall(Response weatherData, int index);
    public abstract double windCall(Response weatherData, int index);
    public abstract int humidityCall(Response weatherData, int index);
    public abstract String weatherCall(Response weatherData, int index);
}
