package pokemon_objects;

import api_assets_pokemon.*;
import classes.*;

public class PokemonDescriptionObject extends PokemonAPICall{
    /**
     * gets the name of the pokemon
     * @param resp api response
     * @param index index in api list
     * @return string
     */
    @Override
    public String getName(PokemonResponseName resp, int index) {
        String temp = resp.getPokemonList()[index].getPokemon().getPokemonName();
        return temp;
    }

    /**
     * gets the description of the pokemon
     * @param resp api response
     * @return string
     */
    @Override
    public String getDescription(PokemonResponseDescription resp) {
        String temp = englishDescription(resp);
        return temp;
    }

    /**
     * gets the url sprite
     * @param resp api response
     * @return string
     */
    @Override
    public String getSprite(PokemonResponseGeneral resp) {
        String temp = resp.getSprite().getImageURL();
        return temp;
    }
    
    /**
     * finds the english version of the flavor text
     * @param pokemon api response
     * @return string
     */
    public String englishDescription(PokemonResponseDescription pokemon){
        String temp = "";
        String description = "";
        FlavorText[] entryList = pokemon.getFlavorText();
        for (int i=0; i<entryList.length;i++){
            if("en".equals(entryList[i].getFlavorTextInner().getlanguageName())){
                description = entryList[i].getText();
                String[] split = description.split("\n");
                for (int j=0;j<split.length;j++){
                    if (j == 0){
                        temp = temp + split[j];
                    } else {
                    temp = temp + " " +split[j];
                    }
                }
                return temp;
            }   
        }
        return "No entry";
    }
    
    /**
     * checks and matches types with weather condition
     * @param weatherType type of weather available
     * @return String
     */
    public String checkPokemonType(String weatherType){//Need to move this to an object
        if (weatherType.contains("clear")||weatherType.contains("sun")){
            return "fire,grass,ground";
        } else if (weatherType.contains("cloud")||weatherType.contains("overcast")){
            return "fighting,poison,fairy";
        } else if (weatherType.contains("part")||weatherType.contains("scattered")||
                weatherType.contains("few")){
            return "normal,rock";
        }else if (weatherType.contains("rain")){
            return "water,electric,bug";
        }else if (weatherType.contains("wind")){
            return "flying,psychic,dragon";
        }else if (weatherType.contains("fog")){
            return "ghost,dark";
        }else if (weatherType.contains("snow")){
            return "ice,steel";
        } else {
            return null;
        }
    }
//==============================================================================
    @Override
    public double getHeight(PokemonResponseGeneral resp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double getWeight(PokemonResponseGeneral resp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
