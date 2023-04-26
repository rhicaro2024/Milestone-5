/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api_assets_pokemon;

/**
 *
 * @author raphaelhicaro
 */
public class PokemonResponseGeneral {
    private int height, weight;
    private String name;
    private Types[] types;
    private Sprite sprites;
    
    public int getHeight(){
        return this.height;
    }
    public int getWeight(){
        return this.weight;
    }
    public String getName(){
        return this.name;
    }
    public Types[] getTypes(){
        return this.types;
    }
    public Sprite getSprite(){
        return this.sprites;
    }
}
