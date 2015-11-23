/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.view;

import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 *
 * @author Jeanmarie
 */
public class SiteViewer {
    ePortfolioMakerView ui;
    VBox root;
    final WebView browser;
    final WebEngine webEngine;
    
    
    public SiteViewer(ePortfolioMakerView initUI) {
        ui = initUI;
        browser = new WebView();
        webEngine = browser.getEngine();
        root = new VBox();
        webEngine.load("http://www.stonybrook.edu/");
        root.getChildren().addAll(browser);
    }
    
    public VBox getSiteViewer() {
        return root;
    }
}
