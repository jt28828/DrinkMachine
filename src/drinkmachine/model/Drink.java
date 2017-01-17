/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkmachine.model;

import java.util.StringTokenizer;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author James
 */
public class Drink {

    private StringProperty mDrinkName; // The name of the drink
    private StringProperty mDrinkImage; // The Image associated with the drink  
    private StringProperty mIngredient1; // The ingredients of the drink
    private StringProperty mIngredient2; // The ingredients of the drink
    private StringProperty mIngredient3; // The ingredients of the drink
    private StringProperty mIngredient4; // The ingredients of the drink
    private int mIngredientAmount1; //The amount in mls of each ingredient
    private int mIngredientAmount2; //The amount in mls of each ingredient
    private int mIngredientAmount3; //The amount in mls of each ingredient
    private int mIngredientAmount4; //The amount in mls of each ingredient

    /**
     * The Default Constructor for the drink object
     */
    public Drink() {
        this(null, null, null, null, null, null, 0, 0, 0, 0);
    }

    /**
     * The constructor for the drink object.
     * Used to create and store details about mixed drinks
     * 
     * @param drinkName The name of the drink
     * @param drinkImage The Image associated with the drink
     * @param ingredient1 The ingredients of the drink
     * @param ingredient2 The ingredients of the drink
     * @param ingredient3 The ingredients of the drink
     * @param ingredient4 The ingredients of the drink
     * @param ingredientAmount1 The amount in mls of each ingredient
     * @param ingredientAmount2 The amount in mls of each ingredient
     * @param ingredientAmount3 The amount in mls of each ingredient
     * @param ingredientAmount4 The amount in mls of each ingredient
     */
    public Drink(String drinkName, String drinkImage, String ingredient1,
            String ingredient2, String ingredient3, String ingredient4,
            int ingredientAmount1, int ingredientAmount2, int ingredientAmount3,
            int ingredientAmount4) {

        this.mDrinkName = new SimpleStringProperty(drinkName);
        this.mDrinkImage = new SimpleStringProperty(drinkImage);
        this.mIngredient1 = new SimpleStringProperty(ingredient1);
        this.mIngredient2 = new SimpleStringProperty(ingredient2);
        this.mIngredient3 = new SimpleStringProperty(ingredient3);
        this.mIngredient4 = new SimpleStringProperty(ingredient4);
        this.mIngredientAmount1 = ingredientAmount1;
        this.mIngredientAmount2 = ingredientAmount2;
        this.mIngredientAmount3 = ingredientAmount3;
        this.mIngredientAmount4 = ingredientAmount4;
    }
    
    public static Drink createDrink(String line) {
        StringTokenizer token = new StringTokenizer(line, ",");
        Drink newDrink = new Drink();
        if (token.countTokens() == 8) {
            newDrink.setDrinkName(token.nextToken().trim());
            newDrink.setDrinkImage(token.nextToken().trim());
            newDrink.setIngredient1(token.nextToken().trim());
            newDrink.setIngredient2(token.nextToken().trim());
            newDrink.setIngredient3(token.nextToken().trim());
            newDrink.setIngredient4(token.nextToken().trim());
            return newDrink;
        } else {
            return null;
        }
    }

    public String getDrinkName() {
        return mDrinkName.get();
    }

    public void setDrinkName(String drinkName) {
        this.mDrinkName.set(drinkName);
    }

    public String getDrinkImage() {
        return mDrinkImage.get();
    }

    public void setDrinkImage(String drinkImage) {
        this.mDrinkImage.set(drinkImage);
    }

    public String getIngredient1() {
        return mIngredient1.get();
    }

    public void setIngredient1(String ingredient1) {
        this.mIngredient1.set(ingredient1);
    }

    public String getIngredient2() {
        return mIngredient2.get();
    }

    public void setIngredient2(String ingredient2) {
        this.mIngredient2.set(ingredient2);
    }

    public String getIngredient3() {
        return mIngredient3.get();
    }

    public void setIngredient3(String ingredient3) {
        this.mIngredient3.set(ingredient3);
    }

    public String getIngredient4() {
        return mIngredient4.get();
    }

    public void setIngredient4(String ingredient4) {
        this.mIngredient4.set(ingredient4);
    }

    public int getIngredientAmount1() {
        return mIngredientAmount1;
    }

    public void setIngredientAmount1(int ingredientAmount1) {
        this.mIngredientAmount1 = ingredientAmount1;
    }

    public int getIngredientAmount2() {
        return mIngredientAmount2;
    }

    public void setIngredientAmount2(int ingredientAmount2) {
        this.mIngredientAmount2 = ingredientAmount2;
    }

    public int getIngredientAmount3() {
        return mIngredientAmount3;
    }

    public void setIngredientAmount3(int ingredientAmount3) {
        this.mIngredientAmount3 = ingredientAmount3;
    }

    public int getIngredientAmount4() {
        return mIngredientAmount4;
    }

    public void setIngredientAmount4(int ingredientAmount4) {
        this.mIngredientAmount4 = ingredientAmount4;
    }  
}
