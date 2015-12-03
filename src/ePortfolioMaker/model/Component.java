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
    String imageCaption;
    Image imageComponent;
    double scaledWidth = DEFAULT_THUMBNAIL_WIDTH;
    double perc;
    double scaledHeight;
	        
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
        perc = scaledWidth / imageComponent.getWidth();
        scaledHeight = imageComponent.getHeight() * perc;
    }
    
    public Component(Media video) {
        
    }
    
   /* public Component(Slideshow slideshow) {
        
    }
    
    public Component(Hyperlink hyperlink) {
    }
    */
   
    
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
    
    
  /*  public String getComponentID() {
        return componentID;
    }*/
}
