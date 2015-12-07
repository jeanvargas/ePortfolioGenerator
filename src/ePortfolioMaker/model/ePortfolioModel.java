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
import javafx.scene.image.Image;
import properties_manager.PropertiesManager;

/**
 *
 * @author Jeanmarie
 */
public class ePortfolioModel {
    ePortfolioMakerView ui;
    String title; //name of ePortfolio
    String studentName; //Student Name
    Image bannerImage;//Banner Image for ePortfolio
    String bannerImageFileName;
    String bannerImageFileNamePath;
    ObservableList<PageModel> pages;
    PageModel selectedPage;
    
    public ePortfolioModel(ePortfolioMakerView initUI) {
        ui = initUI;
        pages = FXCollections.observableArrayList();
        studentName = "Student Name";
        bannerImageFileName = "";
        bannerImageFileNamePath = "";
    }
    
    public void setBannerImageFileName(String s) {
        bannerImageFileName = s;
    }
    
    public void setBannerImageFileNamePath(String s) {
        bannerImageFileNamePath = s;
    }
    
    public String getBannerImageFileName() {
        return bannerImageFileName;
    }
    
    public String getBannerImageFileNamePath() {
        return bannerImageFileNamePath;
    }
    
    public boolean isPageSelected() {
        return selectedPage != null;
    }
    
    public boolean isSelectedPage(PageModel page) {
        return selectedPage == page;
    }
    
    public PageModel getSelectedPage() {
        return selectedPage;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setSelectedPage(PageModel initSelectedPage) {
        selectedPage =  initSelectedPage;
    }
    
    public void setTitle(String t) {
        title = t;
    }
    
    public void clear() {
        pages.clear();
        //PropertiesManager props = PropertiesManager.getPropertiesManager();
        selectedPage = null;
    }
    
    public void addPage() {
        PageModel pageToAdd = new PageModel(ui);
        pages.add(pageToAdd);
        ui.reloadPortfolioPages();
    }
    
    public void setStudentName(String name) {
         studentName = name;
    }
    
    public String getStudentName() {
        return studentName;
    }
    
    public void setBannerImage(Image image) {
        bannerImage = image;
    }
    
    public Image getBannerImage() {
        return bannerImage;
    }
    
    public void removeSelectedPage() {
        if(isPageSelected()) {
            pages.remove(selectedPage);
            int lastPage = pages.size();
            if(lastPage > 0) {
                selectedPage = pages.get(lastPage-1);
            }else {
                selectedPage = null;
            }
            ui.reloadPortfolioPages();
        }       
    }
    
    public void addNewPage(PageModel newPage) {
        pages.add(newPage);
    }
    
    public ObservableList<PageModel> getPages() {
        return pages;
    }
}
