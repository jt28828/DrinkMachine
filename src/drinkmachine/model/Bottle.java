/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkmachine.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author James
 */
public class Bottle {
    
    private StringProperty mBottleContents;     // The Bottle Name 
    private int mBottleNumber;    // The Subject Load
    
    /**
     * The Default Constructor for the bottle object
     */
    public Bottle() {
        this(null, 0);
    }
    

    /**
     * A bottle object
     * 
     * @param bottleContents
     * @param bottleNumber 
     */
    public Bottle(String bottleContents, int bottleNumber) {
        this.mBottleContents = new SimpleStringProperty(bottleContents);
        this.mBottleNumber = bottleNumber;
    }

    public String getBottleContents() {
        return mBottleContents.get();
    }

    public void setBottleContents(String bottleContents) {
        this.mBottleContents.set(bottleContents);
    }

    public int getBottleNumber() {
        return mBottleNumber;
    }

    public void setBottleNumber(int bottleNumber) {
        this.mBottleNumber = bottleNumber;
    }
    
    
    
}
