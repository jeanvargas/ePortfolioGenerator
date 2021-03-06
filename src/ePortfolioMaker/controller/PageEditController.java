/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.controller;

import ePortfolioMaker.model.PageModel;
import ePortfolioMaker.model.SlideShowModel;
import ePortfolioMaker.view.ePortfolioMakerView;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.media.Media;

/**
 *
 * @author Jeanmarie
 */
public class PageEditController {
    private ePortfolioMakerView ui;
    
    public PageEditController(ePortfolioMakerView initUI) {
        ui = initUI;
    }
    
    public void processAddComponentRequest(String type, String textType) {
        PageModel page = ui.getPage();
        page.addComponent(type, textType);
    }
    
    public void processAddComponentRequest(ObservableList<String> array, String textType) {
        PageModel page = ui.getPage();
        page.addComponent(array, textType);
    }
    
    public void processAddComponentRequest(Image image, String caption, 
            String position, double width, double height, String fileName, String filePath) {
        PageModel page = ui.getPage();
        page.addComponent(image, caption, position, width, height, fileName, filePath);
    }
    
    public void processAddComponentRequest(Media video, String caption, 
            String position, double width, double height, String fileName, String filePath) {
        PageModel page = ui.getPage();
        page.addComponent(video, caption, position, width, height, fileName, filePath);
    }
    
    public void processAddComponentRequest(SlideShowModel slideShow) {
        PageModel page = ui.getPage();
        page.addComponent(slideShow);
    }
}
