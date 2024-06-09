package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Weather {
    private JPanel MainPanel;
    private JButton searchButton;
    private JComboBox<String> CitycomboBox;
    private final Main main;

    public Weather(Main main) {
        this.main = main;

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String city = (String) CitycomboBox.getSelectedItem();
                fetchWeatherData(city);
            }
        });
    }

    private void fetchWeatherData(String city) {
        String city_api="";
        String apiKey = "790d009aaa18a4aa46f1271e72d613af";

        switch (city){
            case "London":
                city_api="London,uk";
                break;
            case "Rome":
                city_api="Rome,it";
                break;
            case "Paris":
                city_api="Paris,fr";
                break;
            case "Warsaw":
                city_api="Warsaw,pl";
                break;
            case "Amsterdam":
                city_api="Amsterdam,nl";
                break;
            case "Oslo":
                city_api="Oslo,no";
                break;
            case "Madrid":
                city_api="Madrid,es";
                break;
            case "Berlin":
                city_api="Berlin,de";
                break;
        }
        String urlString = String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&APPID=%s", city_api, apiKey);

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder content = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(content.toString());
            String weatherCondition = jsonNode.get("weather").get(0).get("description").asText();
            int pressure = jsonNode.get("main").get("pressure").asInt();
            int temperature = jsonNode.get("main").get("temp").asInt();
            int feelsLike = jsonNode.get("main").get("feels_like").asInt();

            this.main.updateInfoPanel(city, weatherCondition,pressure, temperature, feelsLike);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JPanel getMainPanel() {
        return MainPanel;
    }
}
