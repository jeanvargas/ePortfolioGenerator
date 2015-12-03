/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.model;

import static ePortfolioMaker.StartupConstants.DEFAULT_PAGE_TITLE;
import ePortfolioMaker.view.ePortfolioMakerView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import properties_manager.PropertiesManager;

/**
 *
 * @author Jeanmarie
 */
public class PageModel {
   ePortfolioMakerView ui;
   ObservableList<Component> components;
   Component selectedComponent;
   String title; //page title
   
   public PageModel(ePortfolioMakerView initUI){
        ui = initUI;
        components = FXCollections.observableArrayList();
        title = DEFAULT_PAGE_TITLE;
        ui.getEPortfolio().setSelectedPage(this);
        reset();
   }
   
   public boolean isComponentSelected(){
       return selectedComponent != null;
   }
   
   public boolean isSelectedComponent(Component comp) {
       return selectedComponent == comp;
   }
   
   public ObservableList<Component> getComponents() {
       return components;
   }
   
   public Component getSelectedComponent(){
       return selectedComponent;
   }
   
   public void setSelectedComponent(Component initSelectedComponent) {
       selectedComponent = initSelectedComponent;
   }
   
   public String getTitle() {
       return title;
   }
   
   public void setTitle(String t) {
       title = t;
   }
   
   public void reset() {
       components.clear();
           selectedComponent = null;
   }
   
   public void addComponent(String data) {
       Component compToAdd = new Component(data);
       components.add(compToAdd);
       ui.reloadPage();
   }
   
   public void addComponent(Image image, String caption, String position, 
           double width, double height, String fileName, String filePath) {
      Component compToAdd = new Component(image);
      compToAdd.setWidth(width);
      compToAdd.setHeight(height);
      compToAdd.setImagePos(position);
      compToAdd.setImageCaption(caption);
      compToAdd.setImageFileName(fileName);
      compToAdd.setImageFilePath(filePath);
      components.add(compToAdd);
      ui.reloadPage();
   }
   
    public void addComponent(Media video, String caption, String position, 
            double width, double height, String fileName, String filePath) {
      Component compToAdd = new Component(video);
      compToAdd.setVideoWidth(width);
      compToAdd.setVideoHeight(height);
      compToAdd.setVideoPosition(position);
      compToAdd.setVideoCaption(caption);
      compToAdd.setVideoFileName(fileName);
      compToAdd.setVideoFilePath(filePath);
      components.add(compToAdd);
      ui.reloadPage();
   }
}
