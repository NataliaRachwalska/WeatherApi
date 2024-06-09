package org.example;

import javax.swing.*;

public class InfoPanel {
    private JPanel MainPanel;
    private JTextField CitytextField;
    private JTextField ConditiontextField;
    private JTextField PressuretextField;
    private JTextField TemperaturetextField;
    private JTextField PTemptextField;

    public JTextField getCitytextField() {
        return CitytextField;
    }

    public JTextField getConditiontextField() {
        return ConditiontextField;
    }

    public JTextField getPTemptextField() {
        return PTemptextField;
    }

    public JTextField getPressuretextField() {
        return PressuretextField;
    }

    public JTextField getTemperaturetextField() {
        return TemperaturetextField;
    }

    public JPanel getMainPanel() {
        return MainPanel;
    }
}
