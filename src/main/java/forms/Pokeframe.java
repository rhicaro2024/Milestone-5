package forms;

import api_assets_pokemon.*;
import api_assets_weather.*;
import api_response_classes.*;
import java.util.ArrayList;
import javax.swing.JPanel;
import pokemon_objects.*;
import weather_objects.*;

public class Pokeframe extends javax.swing.JFrame {
    public int stateNumber;
    public int buttonState;
    private Response weatherResponse;
    private PokemonResponseName pokeNameResponse;
    private String[] pokemonTypes;
    private TemperatureObject tempObj;
    
    private API_Response_Weather weatherResponseObject;
    private API_Response_Pokemon pokemonResponseObject;
    private PokemonDescriptionObject descriptionObj;
            
    private CityForm cityform;
    private Day1 day1;
    private Day2 day2;
    private Day3 day3;
    private Day4 day4;
    private Day5 day5;
    private PokemonList pokemonlist;
    private Pokedex pokedex;
    private ArrayList<JPanel> JPanelList;
        
    public Pokeframe() {
        initComponents();
        stateNumber = 0;
        buttonState = 0;
        weatherResponse = null;
        pokeNameResponse = null;
        pokemonTypes = null;
        weatherResponseObject = new API_Response_Weather();
        pokemonResponseObject = new API_Response_Pokemon();
        descriptionObj = new PokemonDescriptionObject();
        
        cityform = new CityForm();
        day1 = new Day1();
        day2 = new Day2();
        day3 = new Day3();
        day4 = new Day4();
        day5 = new Day5();
        pokemonlist = new PokemonList();
        pokedex = new Pokedex();
        tempObj = new TemperatureObject();
        
        JPanelList = new ArrayList<>();
        JPanelList.add(cityform);
        JPanelList.add(day1);
        JPanelList.add(day2);
        JPanelList.add(day3);
        JPanelList.add(day4);
        JPanelList.add(day5);
        JPanelList.add(pokemonlist);
        JPanelList.add(pokedex);
        
        cityform.setPokeframe(this);//use array list
        day1.setPokeframe(this);
        day2.setPokeframe(this);
        day3.setPokeframe(this);
        day4.setPokeframe(this);
        day5.setPokeframe(this);
        pokemonlist.setPokeframe(this);
        
        for (JPanel panel:JPanelList){
            panel.setSize(400,400);
            descriptionPanel.add(panel);
        }
        
        changeState(stateNumber);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pokedexPanel = new javax.swing.JPanel();
        descriptionPanel = new javax.swing.JPanel();
        userPanel = new javax.swing.JPanel();
        windowDisplayInfo = new javax.swing.JPanel();
        windowNameDisplay = new javax.swing.JLabel();
        enterBtn = new javax.swing.JButton();
        nextBtn = new javax.swing.JButton();
        returnBtn = new javax.swing.JButton();
        tempChangeBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pokedexPanel.setBackground(new java.awt.Color(255, 51, 51));
        pokedexPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
        pokedexPanel.setMaximumSize(new java.awt.Dimension(500, 700));
        pokedexPanel.setPreferredSize(new java.awt.Dimension(500, 700));

        descriptionPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
        descriptionPanel.setMaximumSize(new java.awt.Dimension(400, 400));
        descriptionPanel.setPreferredSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout descriptionPanelLayout = new javax.swing.GroupLayout(descriptionPanel);
        descriptionPanel.setLayout(descriptionPanelLayout);
        descriptionPanelLayout.setHorizontalGroup(
            descriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );
        descriptionPanelLayout.setVerticalGroup(
            descriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        userPanel.setBackground(new java.awt.Color(99, 99, 99));
        userPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
        userPanel.setPreferredSize(new java.awt.Dimension(400, 150));

        windowDisplayInfo.setBackground(new java.awt.Color(141, 198, 69));
        windowDisplayInfo.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, java.awt.Color.darkGray));
        windowDisplayInfo.setPreferredSize(new java.awt.Dimension(260, 100));

        windowNameDisplay.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        windowNameDisplay.setText("Blank");

        javax.swing.GroupLayout windowDisplayInfoLayout = new javax.swing.GroupLayout(windowDisplayInfo);
        windowDisplayInfo.setLayout(windowDisplayInfoLayout);
        windowDisplayInfoLayout.setHorizontalGroup(
            windowDisplayInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(windowDisplayInfoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(windowNameDisplay)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        windowDisplayInfoLayout.setVerticalGroup(
            windowDisplayInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, windowDisplayInfoLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(windowNameDisplay)
                .addGap(28, 28, 28))
        );

        enterBtn.setText("Enter");
        enterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterBtn(evt);
            }
        });

        nextBtn.setText("Next");
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextPanelBtn(evt);
            }
        });

        returnBtn.setText("Return");
        returnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return2LastPanelBtn(evt);
            }
        });

        tempChangeBtn.setText("Change to Celsius");
        tempChangeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tempChangeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout userPanelLayout = new javax.swing.GroupLayout(userPanel);
        userPanel.setLayout(userPanelLayout);
        userPanelLayout.setHorizontalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(windowDisplayInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(returnBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nextBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tempChangeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(enterBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        userPanelLayout.setVerticalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userPanelLayout.createSequentialGroup()
                        .addComponent(enterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(returnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))
                    .addGroup(userPanelLayout.createSequentialGroup()
                        .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(windowDisplayInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tempChangeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38))))
        );

        javax.swing.GroupLayout pokedexPanelLayout = new javax.swing.GroupLayout(pokedexPanel);
        pokedexPanel.setLayout(pokedexPanelLayout);
        pokedexPanelLayout.setHorizontalGroup(
            pokedexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pokedexPanelLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(pokedexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descriptionPanel, 398, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userPanel, 398, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );
        pokedexPanelLayout.setVerticalGroup(
            pokedexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pokedexPanelLayout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(descriptionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(userPanel, 129, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pokedexPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pokedexPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void return2LastPanelBtn(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_return2LastPanelBtn
        if (stateNumber == 1 || stateNumber == 0){
            stateNumber -= 0;
        } else {
            stateNumber -= 1;
        }
        changeState(stateNumber);
    }//GEN-LAST:event_return2LastPanelBtn

    private void nextPanelBtn(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextPanelBtn
        if (stateNumber == 7 || stateNumber == 6){
            stateNumber += 0;
        } else if (stateNumber == 6){
            enterBtn.setText("View Seleceted Pokemon");
        } else {
        stateNumber += 1;
        }
        changeState(stateNumber);
    }//GEN-LAST:event_nextPanelBtn

    private void enterBtn(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterBtn
        if (stateNumber == 0){
            String cityName = cityform.getCityName();
            Location cityNameObj = weatherResponseObject.getLocationResp(cityName)[0];
            double cityLat = cityNameObj.getLat();
            double cityLon = cityNameObj.getLon();
            weatherResponse = weatherResponseObject.getResponse(cityLat, cityLon); //should now be accessible outside of the frame
            String weatherType = weatherResponse.getList()[0].getWeather()[0].getDescription();
            pokemonTypes = descriptionObj.checkPokemonType(weatherType).split(",");
            stateNumber += 1;
            changeState(stateNumber);
            day1.updatePanel(weatherResponse, pokemonTypes);
            day2.updatePanel(weatherResponse, pokemonTypes);
            day3.updatePanel(weatherResponse, pokemonTypes);
            day4.updatePanel(weatherResponse, pokemonTypes);
            day5.updatePanel(weatherResponse, pokemonTypes);
            pokemonlist.updatePanel(weatherResponse, pokemonTypes);
            
            tempChangeBtn.setText("Convert to Celsius");
            buttonState=0;
            change2Imperial();
            
        } else if (stateNumber != 0 && stateNumber < 6){
            stateNumber = 0;
            changeState(stateNumber);
        } else if (stateNumber == 6){
            stateNumber = 7;
            String selectedPokemon = pokemonlist.getSelectedPokemon();
            pokedex.updatePanel(selectedPokemon);
            changeState(stateNumber);
        } else if (stateNumber == 7){
            stateNumber = 6;
            changeState(stateNumber);
        }
    }//GEN-LAST:event_enterBtn

    private void tempChangeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tempChangeBtnActionPerformed
        if (buttonState == 0){
            change2Metric();
            buttonState+=1;
        } else if (buttonState == 1){
            change2Imperial();
            buttonState-=1;
        }
    }//GEN-LAST:event_tempChangeBtnActionPerformed
    
    /**
     * changes the scene (panel)
     * @param stateNumber state of the program
     */
    public void changeState(int stateNumber){
        cityform.setVisible(false);
        day1.setVisible(false);
        day2.setVisible(false);
        day3.setVisible(false);
        day4.setVisible(false);
        day5.setVisible(false);
        pokemonlist.setVisible(false);
        pokedex.setVisible(false);
                        
        if (stateNumber == 0){
            windowNameDisplay.setText("Enter City");
            enterBtn.setText("Enter");
            cityform.setVisible(true);
        }
        if (stateNumber == 1){
            windowNameDisplay.setText("   Day 1");
            enterBtn.setText("Change Location");
            day1.setVisible(true);
        }
        if (stateNumber == 2){
            windowNameDisplay.setText("   Day 2");
            day2.setVisible(true);
        }
        if (stateNumber == 3){
            windowNameDisplay.setText("   Day 3");
            day3.setVisible(true);
        }
        if (stateNumber == 4){
            windowNameDisplay.setText("   Day 4");
            day4.setVisible(true);
        }
        if (stateNumber == 5){
            windowNameDisplay.setText("   Day 5");
            enterBtn.setText("Change Location");
            day5.setVisible(true);
        }
        if (stateNumber == 6){
            windowNameDisplay.setText("Pokémon");
            enterBtn.setText("View Selected Pokemon");
            pokemonlist.setVisible(true);
        }
        if (stateNumber == 7){
            windowNameDisplay.setText(" Pokédex");
            enterBtn.setText("Return to Pokemon List");
            pokedex.setVisible(true);
        }
    }
    
    /**
     * changes everything to metric system
     */
    public void change2Metric(){
        tempChangeBtn.setText("Change to Farenheit");
        day1.change2Metric();
        day2.change2Metric();
        day3.change2Metric();
        day4.change2Metric();
        day5.change2Metric();
        pokedex.convertStats();
    }
    
    /**
     * changes everything to Imperial system
     */
    public void change2Imperial(){
        tempChangeBtn.setText("Change to Celsius");
        day1.change2Imperial(weatherResponse, 0);
        day2.change2Imperial(weatherResponse, 7);
        day3.change2Imperial(weatherResponse, 15);
        day4.change2Imperial(weatherResponse, 23);
        day5.change2Imperial(weatherResponse, 31);
        pokedex.revertStats();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pokeframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pokeframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pokeframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pokeframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pokeframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel descriptionPanel;
    private javax.swing.JButton enterBtn;
    private javax.swing.JButton nextBtn;
    private javax.swing.JPanel pokedexPanel;
    private javax.swing.JButton returnBtn;
    private javax.swing.JButton tempChangeBtn;
    private javax.swing.JPanel userPanel;
    private javax.swing.JPanel windowDisplayInfo;
    private javax.swing.JLabel windowNameDisplay;
    // End of variables declaration//GEN-END:variables
}
