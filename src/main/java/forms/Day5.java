    package forms;

import api_assets_weather.*;
import api_assets_pokemon.*;
import api_response_classes.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import weather_objects.*;
import pokemon_objects.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Day5 extends javax.swing.JPanel {
    private Pokeframe pokeframe;
    
    private Response weatherResponse;
    private String[] pokemonTypes;
    private TemperatureObject tempObj;
    private CityObject cityObj;
    private DateObject dateObj;
    private WeatherObject weatherObj;
    private DefaultListModel model;
    private Random rand;
    URL url;

    
    private ArrayList<String> pokemonNameList;
    private String type1;
    private String type2;
    private String type3;
    private API_Response_Pokemon pokemonNameResponse;
    private PokemonResponseName pokemonNameResponseType1;
    private PokemonResponseName pokemonNameResponseType2;
    private PokemonResponseName pokemonNameResponseType3;
    private ArrayList<PokemonResponseName> pokemonTypeList;

            

    //Cite this
    private static final DecimalFormat df = new DecimalFormat("0");
    private static final DecimalFormat df2 = new DecimalFormat("0.00");
    
    /**
     * Creates new form Day1
     */
    public Day5() {
        initComponents();
        pokemonNameResponse = new API_Response_Pokemon();
        tempObj = new TemperatureObject();
        weatherObj = new WeatherObject();
        cityObj = new CityObject();
        dateObj = new DateObject();
        
        weatherResponse = null;
        pokemonTypes = null;
                
        pokemonTypeList = new ArrayList<>();
        pokemonNameResponseType1 = new PokemonResponseName();
        pokemonNameResponseType2 = new PokemonResponseName();
        pokemonNameResponseType3 = new PokemonResponseName();
        
        model = new DefaultListModel();
        pokemonNameList = new ArrayList<>();
        pokemonList.setModel(model);
        rand = new Random();
        
        model.clear();
    }
    
    /**
     * sets pokeframe as the creator
     * @param myCreator 
     */
    public void setPokeframe(Pokeframe myCreator){
        pokeframe = myCreator;
    }
    
    /**
     * updates the panel when a new city is selected
     * @param weatherResponse1 weather response based on the city
     * @param pokemonTypes list of elements
     */
    public void updatePanel(Response weatherResponse1, String[] pokemonTypes){
        weatherResponse = weatherResponse1;
        setWeatherInfo(weatherResponse, 31);
        setWeatherImage(weatherResponse);
        pokemonTypeList = setTypes(pokemonTypes, this.pokemonTypeList);
        for (PokemonResponseName type: pokemonTypeList){
            setPokemonList(type, model);
        }
    }
    
    /**
     * sets the windows information
     * @param weatherResponse weather api response
     * @param index index in api
     */
    public void setWeatherInfo(Response weatherResponse, int index){
        windspeed.setText(df.format(weatherObj.windCall(weatherResponse, index)));
        humidity.setText(df.format(weatherObj.humidityCall(weatherResponse, index)));
        currentWeather.setText(weatherObj.weatherCall(weatherResponse, index));
        maxTemperature.setText(df.format(tempObj.tempCallHigh(weatherResponse, index)));
        minTemperature.setText(df.format(tempObj.tempCallLow(weatherResponse, index)));
        city.setText(cityObj.cityCall(weatherResponse));
        country.setText(cityObj.countryCall(weatherResponse));
        date.setText(dateObj.dateCall(weatherResponse, index));
        
    }
    
     /**
     * sets the list with pokemon
     * @param pokemonNameResp api response 
     * @param model UI list
     */
    public void setPokemonList(PokemonResponseName pokemonNameResp, DefaultListModel model){
        int numberOfPokemon = pokemonNameResp.getPokemonList().length;
        for (int i=0; i<4; i++){
            int randomIndex = rand.nextInt(numberOfPokemon);
            String pokemonName = pokemonNameResp.getPokemonList()[randomIndex].
                    getPokemon().getPokemonName();
            pokemonNameList.add(pokemonName);
        }
        model.addAll(pokemonNameList);
        pokemonNameList.clear();
    }

    /**
     * sets the arrayList to the element type
     * @param pokemonTypes string array of elements
     * @param pokemonTypeList arrayList to add the information to
     * @return 
     */
    public ArrayList<PokemonResponseName> setTypes(String[] pokemonTypes, ArrayList<PokemonResponseName> pokemonTypeList){
        if (pokemonTypes.length == 2){
            type1 = pokemonTypes[0];
            type2 = pokemonTypes[1];
            pokemonNameResponseType1 = pokemonNameResponse.getPokemonResponseName(type1);
            pokemonNameResponseType2 = pokemonNameResponse.getPokemonResponseName(type2);
            pokemonTypeList.add(pokemonNameResponseType1);
            pokemonTypeList.add(pokemonNameResponseType2);
            return pokemonTypeList;
        } else {
            type1 = pokemonTypes[0];
            type2 = pokemonTypes[1];
            type3 = pokemonTypes[2];
            pokemonNameResponseType1 = pokemonNameResponse.getPokemonResponseName(type1);
            pokemonNameResponseType2 = pokemonNameResponse.getPokemonResponseName(type2);
            pokemonNameResponseType3 = pokemonNameResponse.getPokemonResponseName(type3);
            pokemonTypeList.add(pokemonNameResponseType1);
            pokemonTypeList.add(pokemonNameResponseType2);
            pokemonTypeList.add(pokemonNameResponseType3);
            return pokemonTypeList;
        }
    }
    
    /**
     * sets the image
     * @param weatherResponse api response
     */
    public void setWeatherImage(Response weatherResponse){ //changes the img based on the current weather
        String weatherDescription = weatherResponse.getList()[31].getWeather()[0].getDescription();
        if (weatherDescription.contains("clear") || weatherDescription.contains("sun")){
            weatherSprite.setIcon(new ImageIcon("src/main/resources/sun.png"));
        } else if (weatherDescription.contains("cloud") || weatherDescription.contains("part")){
            weatherSprite.setIcon(new ImageIcon("src/main/resources/cloud.png"));
        } else if (weatherDescription.contains("rain")){
            weatherSprite.setIcon(new ImageIcon("src/main/resources/rain.png"));
        } else if (weatherDescription.contains("wind")){
            weatherSprite.setIcon(new ImageIcon("src/main/resources/wind.png"));
        } else if (weatherDescription.contains("thunder") || weatherDescription.contains("storm") || weatherDescription.contains("lightening")){
            weatherSprite.setIcon(new ImageIcon("src/main/resources/thunder.png"));
        } else if (weatherDescription.contains("snow")){
            weatherSprite.setIcon(new ImageIcon("src/main/resources/snow.png"));
        }
    }
    
    /**
     * changes everything to metric system
     */
    public void change2Metric(){
        double temp2 = weatherObj.convertWindSpeedMetric(parseDouble(windspeed.getText()));
        double temp3 = tempObj.convert2Celsius(parseDouble(maxTemperature.getText()));
        double temp4 = tempObj.convert2Celsius(parseDouble(minTemperature.getText()));
        
        windSpeedType.setText("KPH");
        maxTemperatureType.setText("°Celsius");
        minTemperatureType.setText("°Celsius");
        
        windspeed.setText(df.format(temp2));
        maxTemperature.setText(df.format(temp3));
        minTemperature.setText(df.format(temp4));
    }
    
    /**
     * changes back to imperial
     * @param weatherResponse api response
     * @param index api index
     */
    public void change2Imperial(Response weatherResponse, int index){
        windspeed.setText(df.format(weatherObj.windCall(weatherResponse, index)));
        maxTemperature.setText(df.format(tempObj.tempCallHigh(weatherResponse, index)));
        minTemperature.setText(df.format(tempObj.tempCallLow(weatherResponse, index)));
        
        windSpeedType.setText("MPH");
        maxTemperatureType.setText("°Farenheit");
        minTemperatureType.setText("°Farenheit");
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel21 = new javax.swing.JLabel();
        locationLabel = new javax.swing.JLabel();
        city = new javax.swing.JLabel();
        windLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pokemonList = new javax.swing.JList<>();
        humidtyLabel = new javax.swing.JLabel();
        weatherLabel = new javax.swing.JLabel();
        windspeed = new javax.swing.JLabel();
        windSpeedType = new javax.swing.JLabel();
        humidity = new javax.swing.JLabel();
        currentWeather = new javax.swing.JLabel();
        pokemonListLabel = new javax.swing.JLabel();
        pokemonSprite = new javax.swing.JLabel();
        weatherSprite = new javax.swing.JLabel();
        maxTemperatureLabel = new javax.swing.JLabel();
        minTemperatureLabel = new javax.swing.JLabel();
        minTemperature = new javax.swing.JLabel();
        maxTemperature = new javax.swing.JLabel();
        maxTemperatureType = new javax.swing.JLabel();
        minTemperatureType = new javax.swing.JLabel();
        percentageLabel = new javax.swing.JLabel();
        country = new javax.swing.JLabel();
        locationComma = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        date = new javax.swing.JLabel();

        jLabel21.setText("°Farenheit");

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));

        locationLabel.setText("Current Location:");

        city.setText("City");

        windLabel.setText("Wind Speed:");

        pokemonList.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        pokemonList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        pokemonList.setAutoscrolls(false);
        pokemonList.setMaximumSize(new java.awt.Dimension(170, 170));
        pokemonList.setMinimumSize(new java.awt.Dimension(170, 170));
        pokemonList.setPreferredSize(new java.awt.Dimension(170, 170));
        pokemonList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                pokemonListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(pokemonList);

        humidtyLabel.setText("Humidity:");

        weatherLabel.setText("Current Weather:");

        windspeed.setText("__");

        windSpeedType.setText("MPH");

        humidity.setText("__");

        currentWeather.setText("Place Holder");

        pokemonListLabel.setText("Pokemon Potentially Available:");

        pokemonSprite.setBackground(new java.awt.Color(0, 0, 0));
        pokemonSprite.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        weatherSprite.setMaximumSize(new java.awt.Dimension(100, 100));
        weatherSprite.setPreferredSize(new java.awt.Dimension(100, 100));

        maxTemperatureLabel.setText("Max Temperature:");

        minTemperatureLabel.setText("Min Temperature:");

        minTemperature.setText("__");

        maxTemperature.setText("__");

        maxTemperatureType.setText("°Farenheit");

        minTemperatureType.setText("°Farenheit");

        percentageLabel.setText("%");

        country.setText("Country");

        locationComma.setText(",");

        dateLabel.setText("Date:");

        date.setText("__/__/____");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(maxTemperatureLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(maxTemperature)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(maxTemperatureType))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(minTemperatureLabel)
                                .addGap(8, 8, 8)
                                .addComponent(minTemperature)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(minTemperatureType))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(windLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(windspeed)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(windSpeedType))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(weatherLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(currentWeather))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(humidtyLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(humidity)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(percentageLabel))
                            .addComponent(pokemonListLabel)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(weatherSprite, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(pokemonSprite, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(locationLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(city)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(locationComma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(country)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dateLabel)
                            .addComponent(date))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(windLabel)
                            .addComponent(windspeed)
                            .addComponent(windSpeedType))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(humidtyLabel)
                            .addComponent(humidity)
                            .addComponent(percentageLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(weatherLabel)
                            .addComponent(currentWeather))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(maxTemperatureLabel)
                            .addComponent(maxTemperature)
                            .addComponent(maxTemperatureType))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(minTemperatureLabel)
                            .addComponent(minTemperature)
                            .addComponent(minTemperatureType))
                        .addGap(28, 28, 28)
                        .addComponent(pokemonListLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(locationLabel)
                            .addComponent(city)
                            .addComponent(locationComma)
                            .addComponent(country))
                        .addGap(18, 18, 18)
                        .addComponent(weatherSprite, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(pokemonSprite, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pokemonListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_pokemonListValueChanged
        String currentPokemon = pokemonList.getSelectedValue();
        String pokemonURL = pokemonNameResponse.getPokemonResponseGeneral(currentPokemon).getSprite().getImageURL();
        if (pokemonURL == null){
            pokemonSprite.setIcon(new ImageIcon("src/main/resources/pokeball.png"));
        } else {
            try {
                url = new URL(pokemonURL);
                BufferedImage image = ImageIO.read(url);
                ImageIcon icon = new ImageIcon(image);
                pokemonSprite.setIcon(icon);
            } catch (MalformedURLException ex) {
                Logger.getLogger(Day5.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Day5.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_pokemonListValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel city;
    private javax.swing.JLabel country;
    private javax.swing.JLabel currentWeather;
    private javax.swing.JLabel date;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel humidity;
    private javax.swing.JLabel humidtyLabel;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel locationComma;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JLabel maxTemperature;
    private javax.swing.JLabel maxTemperatureLabel;
    private javax.swing.JLabel maxTemperatureType;
    private javax.swing.JLabel minTemperature;
    private javax.swing.JLabel minTemperatureLabel;
    private javax.swing.JLabel minTemperatureType;
    private javax.swing.JLabel percentageLabel;
    private javax.swing.JList<String> pokemonList;
    private javax.swing.JLabel pokemonListLabel;
    private javax.swing.JLabel pokemonSprite;
    private javax.swing.JLabel weatherLabel;
    private javax.swing.JLabel weatherSprite;
    private javax.swing.JLabel windLabel;
    private javax.swing.JLabel windSpeedType;
    private javax.swing.JLabel windspeed;
    // End of variables declaration//GEN-END:variables
}
