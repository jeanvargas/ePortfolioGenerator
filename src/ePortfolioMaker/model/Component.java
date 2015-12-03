/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.model;

import static ePortfolioMaker.StartupConstants.DEFAULT_THUMBNAIL_WIDTH;
import static ePortfolioMaker.StartupConstants.IMAGE;
import static ePortfolioMaker.StartupConstants.TEXT;
import static ePortfolioMaker.StartupConstants.VIDEO;
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
 
    //IMAGE COMPONENT VARIABLES
    Image imageComponent;
    double scaledWidth;
    double perc;
    double scaledHeight;
    String imagePosition;
    String imageCaption;
    String imageFileName;
    String imagePath;
    
    //VIDEO COMPONENT VARIABLES
    Media videoComponent;
    double videoWidth, videoHeight;
    String videoPosition, videoCaption, videoFileName, videoFilePath;
	        
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
        type = VIDEO;
        idCounter++;
        id = idCounter;
        videoComponent = video;    
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
    
    public void setVideoWidth(double w) {
        videoWidth = w;
    }
    
    public void setVideoHeight(double h) {
        videoHeight = h;
    }
    
    public void setVideoPosition(String p) {
        videoPosition = p;
    }
    
    public void setVideoCaption(String c) {
        videoCaption = c;
    }
    
    public void setVideoFileName(String vFileName) {
        videoFileName = vFileName;
    }
    
    public void setVideoFilePath(String vFilePath) {
        videoFilePath = vFilePath;
    }
    
    public void setImagePos(String p) {
        imagePosition = p;
    }
    
    public void setImageCaption(String s) {
        imageCaption = s;
    }
    
    public void setImageFilePath(String filePath) {
        
    }
    
    public void setImageFileName(String fileName) {
        
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
    
    public String getImageFilePath() {
        return imagePath;
    }
    
    public String getImageFileName() {
        return imageFileName;
    }
    
    public double getVideoHeight() {
        return videoHeight;
    }
    
    public double getVideoWidth() {
        return videoWidth;
    }
    
    public String getVideoPosition() {
        return videoPosition;
    }
    
    public String getVideoCaption() {
        return videoCaption;
    }
    
    public String getVideoFilePath() {
        return videoFilePath;
    }
    
    public String getVideoFileName() {
        return videoFileName;
    }
    
    public Media getVideoComponent() {
        return videoComponent;
    }
  /*  public String getComponentID() {
        return componentID;
    }*/
}
