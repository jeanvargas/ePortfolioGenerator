/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.model;

import ePortfolioMaker.LanguagePropertyType;
import ePortfolioMaker.view.ePortfolioMakerView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import properties_manager.PropertiesManager;

/**
 *
 * @author Jeanmarie
 */
public class ePortfolioModel {
    ePortfolioMakerView ui;
    String title;
    ObservableList<Page> pages;
    Page selectedPage;
    
    public ePortfolioModel(ePortfolioMakerView initUI) {
        ui = initUI;
        pages = FXCollections.observableArrayList();
        title = "Student Name";
    }
    
    public boolean isPageSelected() {
        return selectedPage != null;
    }
    
    public Page getSelectedPage() {
        return selectedPage;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setSelectedPage(Page initSelectedPage) {
        selectedPage =  initSelectedPage;
    }
    
    public void setTitle(String t) {
        title = t;
    }
    
    public void clear() {
        pages.clear();
        PropertiesManager props = PropertiesManager.getPropertiesManager();
        selectedPage = null;
    }
    
    public void addPage(String pageTitle) {
        Page pageToAdd = new Page(pageTitle);
        pages.add(pageToAdd);
        ui.reloadPortfolioPages();
    }
    
}
