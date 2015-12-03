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
      // PropertiesManager props = PropertiesManager.getPropertiesManager();
           selectedComponent = null;
   }
   
   public void addComponent(String data) {
       Component compToAdd = new Component(data);
       components.add(compToAdd);
       ui.reloadPage();
   }
   
   public void addComponent(Image image) {
      Component compToAdd = new Component(image);
      components.add(compToAdd);
      ui.reloadPage();
   }
}
