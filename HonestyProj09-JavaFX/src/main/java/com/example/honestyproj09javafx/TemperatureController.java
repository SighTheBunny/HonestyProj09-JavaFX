package com.example.honestyproj09javafx;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class TemperatureController {
    @FXML
    private Label welcomeText;

    @FXML
    private Label celsiusLabel;
    @FXML
    private Label fahrenheightLabel;
    @FXML
    private TextField degreeText;
    @FXML
    private TextField scaleText;
    @FXML
    private Button convertButton;
    @FXML
    private Button clearButton;
    @FXML
    private Button saveButton;
    @FXML
    private ComboBox<String> temperatureDropdown1;
    @FXML
    private ComboBox<String> temperatureDropdown2;
    @FXML
    private Button compareButton;
    @FXML
    private Label equalsLabel;
    @FXML
    private Label greaterThanLabel;
    @FXML
    private Label lessThanLabel;

    private final int MAX_TEMPERATURES = 4;
    private Temperature[] savedTemperatures = new Temperature[MAX_TEMPERATURES];
    private int savedCount = 0; // counts num of temperatures saved


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void onConvertButtonClick()
    {
        String degreeInput = degreeText.getText();
        String scaleInput = scaleText.getText();
        double userDegree;
        char userScale;

        if (degreeInput.isEmpty())
        {
            userDegree = 0.00;
        }
        else
        {
            userDegree = Double.parseDouble(degreeText.getText());
        }

        if (scaleInput.isEmpty())
        {
            userScale = 'c'; // Defaults to celsius if scale is empty
        }
        else
        {
            userScale = scaleText.getText().toLowerCase().charAt(0);
        }
        Temperature temp = new Temperature(userDegree, userScale);

        celsiusLabel.setText(String.format("%.2f", temp.getDegreeInCelsius()));
        fahrenheightLabel.setText(String.format("%.2f", temp.getDegreeInFahrenheight()));
    }
    @FXML
    protected void onClearButtonClick()
    {
        celsiusLabel.setText("");
        fahrenheightLabel.setText("");
    }
    @FXML
    protected void onSaveButtonClick()
    {
        String degreeInput = degreeText.getText();
        String scaleInput = scaleText.getText();
        double userDegree;
        char userScale;

        if (savedCount < MAX_TEMPERATURES)
        {
            if (degreeInput.isEmpty())
            {
                userDegree = 0.00;
            }
            else
            {
                userDegree = Double.parseDouble(degreeText.getText());
            }
            if (scaleInput.isEmpty())
            {
                userScale = 'c'; // Defaults to celsius if scale is empty
            }
            else
            {
                userScale = scaleText.getText().toLowerCase().charAt(0);
            }

            savedTemperatures[savedCount++] = new Temperature(userDegree, userScale);
            updateDropdowns();
        }
        else
        {
            saveButton.setDisable(true);
        }
    }
    @FXML
    protected void onCompareButtonClick()
    {
        int index1 = temperatureDropdown1.getSelectionModel().getSelectedIndex();
        int index2 = temperatureDropdown2.getSelectionModel().getSelectedIndex();

        if (index1 >= 0 && index2 >= 0)
        {
            Temperature temp1 = savedTemperatures[index1];
            Temperature temp2 = savedTemperatures[index2];

            equalsLabel.setText(
                    "Temperature 1 is " +
                    (temp1.equals(temp2) ? "equal to" : "not equal to") +
                    " Temperature 2."
            );
            greaterThanLabel.setText(
                    "Temperature 1 is " +
                    (temp1.isGreaterThan(temp2) ? "greater than" : "not greater than") +
                    " Temperature 2."
            );
            lessThanLabel.setText(
                    "Temperature 1 is " +
                    (temp1.isLessThan(temp2) ? "less than" : "not less than") +
                    " Temperature 2."
            );
        }
    }

    private void updateDropdowns()
    {
        String[] temperatureNames = new String[savedCount];

        for (int i = 0; i < savedCount; i++)
        {
            temperatureNames[i] = "Temperature " + (i + 1);
        }
        temperatureDropdown1.getItems().setAll(temperatureNames);
        temperatureDropdown2.getItems().setAll(temperatureNames);
    }

}