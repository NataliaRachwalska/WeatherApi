package org.example;

import javax.swing.*;
import java.awt.*;

public class Main {
    private JPanel mainPanel;
    private JPanel panelContainer;
    private CardLayout cardLayout;
    private InfoPanel infoPanel;

    public Main() {
        cardLayout = new CardLayout();
        panelContainer = new JPanel(cardLayout);

        Weather weatherPanel = new Weather(this);
        infoPanel = new InfoPanel();

        panelContainer.add(weatherPanel.getMainPanel(), "WeatherPanel");
        panelContainer.add(infoPanel.getMainPanel(), "InfoPanel");

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(panelContainer, BorderLayout.CENTER);

        cardLayout.show(panelContainer, "WeatherPanel");
    }

    public void showPanel(String panelName) {
        cardLayout.show(panelContainer, panelName);
    }

    public void updateInfoPanel(String city, String condition,int pressure, int temperature, int feelsLike) {
        infoPanel.getCitytextField().setText(city);
        infoPanel.getConditiontextField().setText(condition);
        infoPanel.getPressuretextField().setText(String.valueOf(pressure) + " hPa");
        infoPanel.getTemperaturetextField().setText(String.valueOf(temperature) + " °C");
        infoPanel.getPTemptextField().setText(String.valueOf(feelsLike) + " °C");
        showPanel("InfoPanel");
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Weather Application");
        frame.setContentPane(new Main().getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}
