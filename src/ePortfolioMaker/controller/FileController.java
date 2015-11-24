/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.controller;

import ePortfolioMaker.LanguagePropertyType;
import ePortfolioMaker.error.ErrorHandler;
import ePortfolioMaker.view.ColorThemeDialog;
import ePortfolioMaker.view.FontDialogView;
import ePortfolioMaker.view.LayoutDialogView;
import ePortfolioMaker.view.SiteViewer;
import ePortfolioMaker.view.SlideshowDialogView;
import ePortfolioMaker.view.TextDialogView;
import ePortfolioMaker.view.ePortfolioMakerView;
import java.io.IOException;
import javafx.stage.Stage;

/**
 *
 * @author Jeanmarie
 */
public class FileController {
    private ePortfolioMakerView ui;
    private boolean saved;
    
    public FileController(ePortfolioMakerView initUI) {
        ui = initUI;
        saved = true;
    }   
    
    public void handleNewEPortfolioRequest() {
        
            boolean continueToMakeNew = true;
            if(!saved) {
                //do something continueToMakeNew = somehing
            }
            
            if(continueToMakeNew) {
                ui.updateToolbarControls(saved);
                ui.reloadFileSiteControls();
                }
            
        }
    
    public void handleNewPageReqest()   {
        
    }
    
    public void handleSiteViewerWorkspaceRequest() {
        SiteViewer siteViewer = new SiteViewer(ui);
        ui.siteViewer(siteViewer.getSiteViewer());
    }
    
    public void handlePageEditorWorkspaceRequest() {
        ui.updateToolbarControls(saved);
    }
    
    public void handleAddTextComponentRequest() {
      TextDialogView textDialog = new TextDialogView(ui);
      textDialog.showDialog();
    }
    
    public void handleChooseCompFontRequest() {
        FontDialogView fontDialog = new FontDialogView(ui);
        fontDialog.setUpDialog();
    }
    
    public void handleSlideshowRequest() {
        SlideshowDialogView slideShow = new SlideshowDialogView(ui);
        Stage stage = new Stage();
        slideShow.startUI(stage, "Slideshow");
    }
    
    public void handleLayoutRequest() {
       LayoutDialogView layout = new LayoutDialogView(ui);
       layout.setUpDialog();
    }
    
    public void handleColorRequest() {
        ColorThemeDialog color = new ColorThemeDialog(ui);
        color.setUpDialog();
    }
            
   }

