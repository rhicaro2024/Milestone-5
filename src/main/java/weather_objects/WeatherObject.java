/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package weather_objects;

import classes.WeatherAPICall;
import api_assets_weather.Response;

/**
 *
 * @author raphaelhicaro
 */
public class WeatherObject extends WeatherAPICall{ 
    /**
     * gets the wind speed
     * @param weatherData api response
     * @param index api index
     * @return double
     */
    @Override
    public double windCall(Response weatherData, int index) {
        double temp = weatherData.getList()[index].getWind().getSpeed();
        return temp;
    }

    /**
     * gets the humidity level
     * @param weatherData api response
     * @param index api index
     * @return int
     */
    @Override
    public int humidityCall(Response weatherData, int index) {
        int temp = weatherData.getList()[index].getMain().getHumidity();
        return temp;
    }

    /**
     * gets the description of the weather
     * @param weatherData api response
     * @param index api index
     * @return string
     */
    @Override
    public String weatherCall(Response weatherData, int index) {
        String temp = weatherData.getList()[index].getWeather()[0].getDescription();
        return temp;
    }
    
    /**
     * converts from mph to kph
     * @param value mph value
     * @return double
     */
    public double convertWindSpeedMetric(double value){
        return value*1.609;
    }
    //==========================================================================
    @Override
    public String cityCall(Response weatherData) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String countryCall(Response weatherData) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double tempCall(Response weatherData, int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double tempCallHigh(Response weatherData, int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double tempCallLow(Response weatherData, int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String dateCall(Response weatherData, int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}