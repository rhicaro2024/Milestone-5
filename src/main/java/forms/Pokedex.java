/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package forms;

import api_assets_pokemon.*;
import api_response_classes.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import pokemon_objects.*;

/**
 *
 * @author raphaelhicaro
 */
public class Pokedex extends javax.swing.JPanel {
    private PokemonResponseDescription pokemonDescriptionResponse;
    private PokemonResponseGeneral pokemonGeneralResponse;
    
    private PokemonDescriptionObject descriptionObj;
    private PokemonPhysicalObject physicalObj;
    private API_Response_Pokemon pokedexResponse;
    
    private static final DecimalFormat df = new DecimalFormat("0");
    private static final DecimalFormat df2 = new DecimalFormat("0.00");
    private URL url;
    
    public Pokedex() {
        initComponents();
        pokemonDescriptionResponse = new PokemonResponseDescription();
        pokemonGeneralResponse = new PokemonResponseGeneral();
        
        descriptionObj = new PokemonDescriptionObject();
        physicalObj = new PokemonPhysicalObject();
        pokedexResponse = new API_Response_Pokemon();
    }
    
    /**
     * updates the panel
     * @param pokemonName string name of pokemon
     */
    public void updatePanel(String pokemonName){
        this.pokemonDescriptionResponse = pokedexResponse.
                getPokemonResponseDescription(pokemonName);
        this.pokemonGeneralResponse = pokedexResponse.
                getPokemonResponseGeneral(pokemonName);
        updatePokedex(this.pokemonDescriptionResponse,
                this.pokemonGeneralResponse, pokemonName);
    }
    
    /**
     * updates the pokedex with specific information about the pokemon
     * @param responseDescription api response for flavor text
     * @param responseGeneral api response for general information about pokemon
     * @param pokemonName name of pokemon
     */
    public void updatePokedex(PokemonResponseDescription responseDescription, 
            PokemonResponseGeneral responseGeneral, String pokemonName){
        double pokemonWeight = physicalObj.getWeight(responseGeneral);
        double pokemonHeight = physicalObj.getHeight(responseGeneral);
        weight.setText(df2.format(pokemonWeight));//Is in hectograms
        height.setText(df2.format(pokemonHeight));//Is in decimeters
        name.setText(pokemonName);
        description.setText(descriptionObj.getDescription(responseDescription));
        setPokemonSprite(responseGeneral);
        switch (responseGeneral.getTypes().length) {
            case 1:
                type.setText(responseGeneral.getTypes()[0].getType().getTypeName());
                break;
            case 2:
                type.setText(responseGeneral.getTypes()[0].getType().getTypeName()
                        + ", " + responseGeneral.getTypes()[1].getType().getTypeName());
                break;
            case 3:
                type.setText(responseGeneral.getTypes()[0].getType().getTypeName() 
                        + ", " + responseGeneral.getTypes()[1].getType().getTypeName()
                        + ", " + responseGeneral.getTypes()[2].getType().getTypeName());
                break;
        }
    }
        
    /**
     * sets the sprite of the pokemon
     * @param responseGeneral 
     */
    public void setPokemonSprite(PokemonResponseGeneral responseGeneral){
        String pokemonURL = descriptionObj.getSprite(responseGeneral);
        if (pokemonURL == null){
            pokemonSprite.setIcon(new ImageIcon("src/main/resources/pokeball.png"));
        } else {
            try {
                url = new URL(pokemonURL);
                BufferedImage image = ImageIO.read(url);
                ImageIcon icon = new ImageIcon(image);//make an arrayList of imageIcon to make pictures load faster.
                pokemonSprite.setIcon(icon);
            } catch (MalformedURLException ex) {
                Logger.getLogger(Day1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Day1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * converts the height and weight to metric
     */
    public void convertStats(){
        double temp1 = physicalObj.convert2MetricWeight(parseDouble(weight.getText()));
        double temp2 = physicalObj.convert2MetricHeight(parseDouble(height.getText()));
        weight.setText(df2.format(temp1));
        height.setText(df2.format(temp2));
        weightTypeLabel.setText("kg");
        heightTypeLabel.setText("m");
    }
    
    /**
     * converts height and weight to Imperial
     */
    public void revertStats(){
        weight.setText(df2.format(physicalObj.getWeight(this.pokemonGeneralResponse)));
        height.setText(df2.format(physicalObj.getHeight(this.pokemonGeneralResponse)));
        weightTypeLabel.setText("lbs");
        heightTypeLabel.setText("ft");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pokemonSprite = new javax.swing.JLabel();
        weightLabel = new javax.swing.JLabel();
        heightLabel = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        weight = new javax.swing.JLabel();
        weightTypeLabel = new javax.swing.JLabel();
        height = new javax.swing.JLabel();
        heightTypeLabel = new javax.swing.JLabel();
        type = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        nameLabel = new javax.swing.JLabel();
        name = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        weightLabel.setText("Pokémon Weight:");

        heightLabel.setText("Pokémon Height:");

        typeLabel.setText("Pokémon Type:");

        weight.setText("##.##");

        weightTypeLabel.setText("lbs");

        height.setText("#.#");

        heightTypeLabel.setText("ft");

        type.setText("Place Holder");

        description.setColumns(20);
        description.setRows(5);
        jScrollPane1.setViewportView(description);

        nameLabel.setText("Pokémon Name:");

        name.setText("Place Holder");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(typeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(type))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(heightLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(height)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(heightTypeLabel))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(weightLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(weight)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(weightTypeLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pokemonSprite, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(pokemonSprite, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(weightLabel)
                    .addComponent(weight)
                    .addComponent(weightTypeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(heightLabel)
                    .addComponent(height)
                    .addComponent(heightTypeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeLabel)
                    .addComponent(type))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea description;
    private javax.swing.JLabel height;
    private javax.swing.JLabel heightLabel;
    private javax.swing.JLabel heightTypeLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel name;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel pokemonSprite;
    private javax.swing.JLabel type;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JLabel weight;
    private javax.swing.JLabel weightLabel;
    private javax.swing.JLabel weightTypeLabel;
    // End of variables declaration//GEN-END:variables
}
