/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.model;

import static ePortfolioMaker.StartupConstants.DEFAULT_THUMBNAIL_WIDTH;
import static ePortfolioMaker.StartupConstants.IMAGE;
import static ePortfolioMaker.StartupConstants.TEXT;
import javafx.scene.image.Image;
import javafx.scene.media.Media;

/**
 *
 * @author Jeanmarie
 */
public class Component {
    String type;
   // String componentID;
    static int idCounter;
    int id;
    
    //TEXT COMPONENT VARIABLES
    String textCompData;
 //   String textCompType;
    
    /*public Component(String initType){
        TYPE = initType;
        idCounter++;
        id = idCounter;
     //   componentID = TYPE + id;
    }*/
    
    //IMAGE COMPONENT VARIABLES
    Image imageComponent;
    double scaledWidth;
    double perc;
    double scaledHeight;
    String imagePosition;
    String imageCaption;
	        
    public Component(String data) {
        type = TEXT;
        idCounter++;
        id = idCounter;
        
        textCompData = data;
    }
    
    public Component(Image image) {
        type = IMAGE;
        idCounter++;
        id = idCounter;
        imageComponent = image;
    }
    
    public Component(Media video) {
        
    }
    
   /* public Component(Slideshow slideshow) {
        
    }
    
    public Component(Hyperlink hyperlink) {
    }
    */
   
    public void setWidth(double w) {
        scaledWidth = w;
    }
    
    public void setHeight(double h) {
        scaledHeight = h;
    }
    
    public void setImagePos(String p) {
        imagePosition = p;
    }
    
    public void setImageCaption(String s) {
        imageCaption = s;
    }
    
    public String getType(){
        return type;
    }
    
    public int getID() {
        return id;
    }
    
    public String getTextComponentData() {
       return textCompData; 
    }
    
    public Image getImageComponent() {
        return imageComponent;
    }
    
    public double getImageHeight() {
        return scaledHeight;
    }
    
    public double getImageWidth() {
        return scaledWidth;
    }
    
    public String getImagePos() {
        return imagePosition;
    }
    
    public String getImageCaption() {
        return imageCaption;
    }
    
  /*  public String getComponentID() {
        return componentID;
    }*/
}
