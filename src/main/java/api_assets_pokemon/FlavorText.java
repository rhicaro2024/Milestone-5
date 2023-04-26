/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api_assets_pokemon;

/**
 *
 * @author raphaelhicaro
 */
public class FlavorText {
    private String flavor_text;
    private FlavorTextInner language;
    
    public String getText(){
        return this.flavor_text;
    }
    
    public FlavorTextInner getFlavorTextInner(){
        return language;
    }
}
