/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkmachine;

import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

/**
 *
 * @author James
 */
public class DrinkController implements Initializable {

    //Variable declarations
    @FXML
    private AnchorPane createFields;
    @FXML
    private TextField drinkName;
    @FXML
    private TextField ing1amount, ing2amount, ing3amount, ing4amount;
    @FXML
    private ChoiceBox ing1, ing2, ing3, ing4;
    @FXML
    private ImageView drink1, drink2, drink3, drink4, drink5, drink6, drink7,
            drink8, drink9, drink10;
    @FXML
    private Button drinkButton, drinkButton1, drinkButton2, drinkButton3,
            drinkButton4, drinkButton5, drinkButton6, drinkButton7,
            drinkButton8, drinkButton9;
    @FXML
    private Button exitButton;

    private String drinkImage = null;

//Basic methods used throughout the program
    /**
     *
     * Presents the user with a dialog box to indicate whether they would like
     * to shut down the device.
     */
    @FXML
    private void closeApplication(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Shutdown");
        alert.setHeaderText("Do you want to shutdown?");

        //Wait for user to choose an option
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Platform.exit();
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }

    private void writeToFile(List<String> drink) throws IOException {
        FileWriter writer = new FileWriter("drinks.csv");
        for (int i = 0; i < drink.size(); i++) {
            writer.append(drink.get(i));
            writer.append(',');
        }
        writer.append('\n');
        writer.flush();
        writer.close();
    }

    @FXML
    private void shutdown(ActionEvent event) throws IOException {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Shutdown");
        alert.setHeaderText("Do you want to shutdown?");

        //Wait for user to choose an option
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Runtime.getRuntime().exec("shutdown -h now");
            System.exit(0);
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

//Methods used for choosing and pouring drinks    
    /**
     * Gets the chosen drink.
     */
    @FXML
    private void drinkSelected(ActionEvent event) {
        int selectedDrink = 0;
        Button source = (Button) event.getSource();

        if (source.getId().equals("drinkbutton")) {
            selectedDrink = 1;
        } else if (source.getId().equals("drinkbutton1")) {
            selectedDrink = 2;
        } else if (source.getId().equals("drinkbutton2")) {
            selectedDrink = 3;
        } else if (source.getId().equals("drinkbutton3")) {
            selectedDrink = 4;
        } else if (source.getId().equals("drinkbutton4")) {
            selectedDrink = 5;
        } else if (source.getId().equals("drinkbutton5")) {
            selectedDrink = 6;
        } else if (source.getId().equals("drinkbutton6")) {
            selectedDrink = 7;
        } else if (source.getId().equals("drinkbutton7")) {
            selectedDrink = 8;
        } else if (source.getId().equals("drinkbutton8")) {
            selectedDrink = 9;
        } else if (source.getId().equals("drinkbutton9")) {
            selectedDrink = 10;
        }
        pourDrink(selectedDrink);
    }

    /**
     * Colors the drink on screen to indicate to the user and pours the drink.
     * After pouring the color is reset
     *
     * @param selectedDrink The chosen mixed drink
     */
    private void pourDrink(int selectedDrink) {
        //Creating the inner shadow style
        InnerShadow style = new InnerShadow();
        style.setChoke(0.5);
        style.setWidth(44);
        style.setHeight(21);
        style.setRadius(16);
        style.setColor(Color.BLUE);

        switch (selectedDrink) {
            case 1:  //Mix Drink code Here
                drink1.setEffect(style);
                break;
            case 2:  //Mix Drink code Here
                drink2.setEffect(style);
                break;
            case 3:  //Mix Drink code Here
                drink3.setEffect(style);
                break;
            case 4:  //Mix Drink code Here
                drink4.setEffect(style);
                break;
            case 5:  //Mix Drink code Here
                drink5.setEffect(style);
                break;
            case 6:  //Mix Drink code Here
                drink6.setEffect(style);
                break;
            case 7:  //Mix Drink code Here
                drink7.setEffect(style);
                break;
            case 8:  //Mix Drink code Here
                drink8.setEffect(style);
                break;
            case 9:  //Mix Drink code Here
                drink9.setEffect(style);
                break;
            case 10: //Mix Drink code Here
                drink10.setEffect(style);
                break;
        }
    }

    /**
     * Sends data to the Arduino to pour the drink. Waits for a completed
     * confirmation before the method completes.
     */
    private void serialComm() {
    }

//Methods used in creating or changing drinks.
    /**
     * Used to empty out all user input
     */
    private void emptyFields() {
        drinkName.setText(null);
        ing1amount.setText(null);
        ing2amount.setText(null);
        ing3amount.setText(null);
        ing4amount.setText(null);
        ing1.setValue(null);
        ing2.setValue(null);
        ing3.setValue(null);
        ing4.setValue(null);
    }

    /**
     * Unlocks and clears the edit fields to create a new drink.
     */
    @FXML
    private void unlockFields() {
        emptyFields();
        createFields.setDisable(false);
    }

    /**
     * Empties and locks the edit fields when the user taps cancel
     */
    @FXML
    private void cancelCreateDrink() {
        emptyFields();
        createFields.setDisable(true);
    }

    /**
     * Gets the data from the fields and adds it to the csv file If fields are
     * empty alerts the user.
     */
    @FXML
    private void createDrink() throws IOException {
        //Check if the drink has a name and at least 1 ingredient
        if (!"".equals(drinkName.getText()) && !"".equals(ing1amount.getText())) {

            //Add drink name, image location and ingredients to Arraylist
            List<String> drinks = new ArrayList<String>();
            if (drinkImage != null) {
                drinks.add(drinkImage);
            }
            drinks.add(drinkName.getText());
            drinks.add(ing1.getValue().toString());
            drinks.add(ing1amount.getText());
            if (!"".equals(ing2.getValue().toString()) && !"".equals(ing2amount.getText())) {
                drinks.add(ing2.getValue().toString());
                drinks.add(ing2amount.getText());
            }
            if (!"".equals(ing3.getValue().toString()) && !"".equals(ing3amount.getText())) {
                drinks.add(ing3.getValue().toString());
                drinks.add(ing3amount.getText());
            }
            if (!"".equals(ing4.getValue().toString()) && !"".equals(ing4amount.getText())) {
                drinks.add(ing4.getValue().toString());
                drinks.add(ing4amount.getText());
            }
            writeToFile(drinks);
        }
    }

}
