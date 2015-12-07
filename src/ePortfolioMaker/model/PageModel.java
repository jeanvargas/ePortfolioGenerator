/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.model;

import static ePortfolioMaker.StartupConstants.COLOR_BLUE;
import static ePortfolioMaker.StartupConstants.DEFAULT_PAGE_TITLE;
import static ePortfolioMaker.StartupConstants.LAYOUT_ONE;
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
   String studentName;
   String layoutType;
   String colorLayoutType;
   
   public PageModel(ePortfolioMakerView initUI){
        ui = initUI;
        components = FXCollections.observableArrayList();
        title = DEFAULT_PAGE_TITLE;
        ui.getEPortfolio().setSelectedPage(this);
        studentName = ui.getEPortfolio().getStudentName();
        layoutType = LAYOUT_ONE;
        colorLayoutType = COLOR_BLUE;
        reset();
   }
   
   public ePortfolioModel getEPortfolio() {
       return ui.getEPortfolio();
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
   
   public String getStudentName() {
       return studentName;
   }
   
   public void setTitle(String t) {
       title = t;
   }
   
   public void setStudentName(String n) {
       studentName = n;
   }
   
   public void setLayout(String l) {
       layoutType = l;
   }
   
   public void setColor(String c) {
       colorLayoutType = c;
   }
   
   public String getLayout() {
       return layoutType;
   }
   
   public String getColor() {
       return colorLayoutType;
   }
   
   public void reset() {
       components.clear();
           selectedComponent = null;
   }
   
   public void addComponent(String data, String type) {
       Component compToAdd = new Component(data, type);
       components.add(compToAdd);
       ui.reloadPage();
   }
   
   public void addComponent(ObservableList<String> array, String type) {
       Component compToAdd = new Component(array, type);
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
      System.out.println("add component Image file name: " + compToAdd.getImageFileName());
            System.out.println("add component Image file path: " + compToAdd.getImageFilePath());

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
    
    public void addComponent(SlideShowModel slideShow) {
        Component compToAdd = new Component(slideShow);
        components.add(compToAdd);
        ui.reloadPage();
    }
    
    public void removeSelectedComponent() {
        if(isComponentSelected()) {
            components.remove(selectedComponent);
            selectedComponent = null;
            ui.reloadPage();
        }
    }
}
