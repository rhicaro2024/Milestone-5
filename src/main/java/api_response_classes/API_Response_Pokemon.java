package api_response_classes;

import api_assets_weather.*;
import api_assets_pokemon.*;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Acts as an object that simply houses methods specifically for getting the API Pokemon Response
 * @author raphaelhicaro
 */
public class API_Response_Pokemon{  
    
    /**
     * Method to return a list of pokemon based on the element type
     * @param pokemonType String version of element type
     * @return PokemonResponseName
     */
    public PokemonResponseName getPokemonResponseName(String pokemonType){
        Gson gson = new Gson();
        try {
            URL url = new URL("https://pokeapi.co/api/v2/type/" + pokemonType);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
            String tmp = in.readLine();
            PokemonResponseName genPokemonResponse = gson.fromJson(tmp, PokemonResponseName.class);
            return genPokemonResponse;
        } catch (MalformedURLException ex) {
            Logger.getLogger(City.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(City.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Similar to above method but is used for general information on said pokemon
     * @param pokemonName string name of the pokemon
     * @return PokemonResponseGeneral
     */
    public PokemonResponseGeneral getPokemonResponseGeneral(String pokemonName){
        Gson gson = new Gson();
        try {
            URL url = new URL("https://pokeapi.co/api/v2/pokemon/" + pokemonName);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
            String tmp = in.readLine();
            PokemonResponseGeneral genPokemonResponse = gson.fromJson(tmp, PokemonResponseGeneral.class);
            return genPokemonResponse;
        } catch (MalformedURLException ex) {
            Logger.getLogger(City.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(City.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Similar to above methods but is used to get the falvor text of the pokemon
     * @param pokemonName String name of the pokemon
     * @return PokemonResponseDescription
     */
    public PokemonResponseDescription getPokemonResponseDescription(String pokemonName){
        Gson gson = new Gson();
        try {
            URL url = new URL("https://pokeapi.co/api/v2/pokemon-species/" + pokemonName);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
            String tmp = in.readLine();
            PokemonResponseDescription genPokemonResponse = gson.fromJson(tmp, PokemonResponseDescription.class);
            return genPokemonResponse;
        } catch (MalformedURLException ex) {
            Logger.getLogger(City.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(City.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
