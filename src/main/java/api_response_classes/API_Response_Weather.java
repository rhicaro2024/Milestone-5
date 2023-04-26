/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api_response_classes;

import api_assets_weather.City;
import api_assets_weather.Location;
import api_assets_weather.Response;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author raphaelhicaro
 */
public class API_Response_Weather {
    /**
 * calls the API response
 * will include later so that it holds API calls.
 * @param lat latitude
 * @param lon longitude
 * @return the first portion of the API call 
 */
    public Response getResponse(double lat, double lon){
        Gson gson = new Gson();
        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/forecast?lat=" + lat + 
                    "&lon=" + lon + "&appid=cbd0dd1ec0267431ba7bdb41a4f8051e");
            HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
            BufferedReader in = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));
            String tmp = in.readLine();
            Response gen_resp = gson.fromJson(tmp, Response.class);
            return gen_resp;
        } catch (MalformedURLException ex) {
            Logger.getLogger(City.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(City.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
/**
 * returns the area specific information of the city, will use later to hold
 * the API call instead of having it in the window itself
 * @param city_name city name to be put into API
 * @return Another portion of the API that allows the program to access the
 * lat and lon of the given city
 */
    public Location[] getLocationResp(String city_name){
        Gson gson = new Gson();
        try {
            URL url = new URL("http://api.openweathermap.org/geo/1.0/direct?q=" 
                    + city_name + "&limit=5&appid=cbd0dd1ec0267431ba7bdb41a4f8051e");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
            String tmp = in.readLine();
            Location[] location_resp = gson.fromJson(tmp, Location[].class);
            return location_resp;
        } catch (MalformedURLException ex) {
            Logger.getLogger(City.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(City.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
