/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.controller;

import ePortfolioMaker.model.PageModel;
import ePortfolioMaker.view.ePortfolioMakerView;
import javafx.scene.image.Image;

/**
 *
 * @author Jeanmarie
 */
public class PageEditController {
    private ePortfolioMakerView ui;
    
    public PageEditController(ePortfolioMakerView initUI) {
        ui = initUI;
    }
    
    public void processAddComponentRequest(String type) {
        PageModel page = ui.getPage();
        page.addComponent(type);
    }
    
    public void processAddComponentRequest(Image image) {
        PageModel page = ui.getPage();
        page.addComponent(image);
    }
}
