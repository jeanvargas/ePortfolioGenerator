/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.controller;

import ePortfolioMaker.LanguagePropertyType;
import static ePortfolioMaker.StartupConstants.SLIDESHOW;
import static ePortfolioMaker.StartupConstants.TEXT;
import ePortfolioMaker.error.ErrorHandler;
import ePortfolioMaker.file.SlideShowFileManager;
import ePortfolioMaker.file.ePortfolioFileManager;
import ePortfolioMaker.model.Component;
import ePortfolioMaker.model.PageModel;
import ePortfolioMaker.model.ePortfolioModel;
import ePortfolioMaker.view.AddBannerDialogView;
import ePortfolioMaker.view.AddHyperlinkDialogView;
import ePortfolioMaker.view.AddImageDialogView;
import ePortfolioMaker.view.AddVideoDialogView;
import ePortfolioMaker.view.ColorThemeDialog;
import ePortfolioMaker.view.FontDialogView;
import ePortfolioMaker.view.LayoutDialogView;
import ePortfolioMaker.view.SiteViewer;
import ePortfolioMaker.view.SlideshowDialogView;
import ePortfolioMaker.view.TextDialogView;
import ePortfolioMaker.view.ePortfolioMakerView;
import ePortfolioMaker.view.editFooterDialogView;
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
        PageModel newPage = new PageModel(ui);
        ePortfolioModel ePortfolio = ui.getEPortfolio();
        ePortfolio.addNewPage(newPage);
        ePortfolio.setSelectedPage(newPage);
        ui.reloadPortfolioPages();
        //ui.addPage(newPage);
    }
    
    public void handleSiteViewerWorkspaceRequest() {
        SiteViewer siteViewer = new SiteViewer(ui);
        System.out.println("page title: " + ui.getEPortfolio().getSelectedPage().getTitle());
        System.out.println("page title of getPage: " + ui.getPage().getTitle());
        System.out.println("type: " + ui.getPage().getComponents().get(0).getType());

        
        ePortfolioFileManager eportFileManager = new ePortfolioFileManager();
        try {
        eportFileManager.savePage(ui.getEPortfolio().getSelectedPage());
        } catch (IOException ioe) {
            ErrorHandler eH = ui.getErrorHandler();
            eH.processError(LanguagePropertyType.ERROR_DATA_FILE_LOADING);
        }
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
    
    public void handleAddFooterRequest() {
        editFooterDialogView edit = new editFooterDialogView(ui);
        edit.setUpDialog();
    }
    
    public void handleAddBannerRequest() {
        AddBannerDialogView addImage = new AddBannerDialogView();
        addImage.processSelectImage();
    }
    
    public void handleAddImageRequest() {
        AddImageDialogView image = new AddImageDialogView(ui);
        image.setUpDialog();
    }
    
    public void addVideoRequest() {
        AddVideoDialogView video = new AddVideoDialogView(ui);
        video.setUpDialog();    
    }
    
    public void addHyperlinkRequest() {
        AddHyperlinkDialogView hyperlink = new AddHyperlinkDialogView(ui);
        hyperlink.setUpDialog();
    }
    
    public void removeComponentRequest() {
        ui.getPage().removeSelectedComponent();
    }
    
    public void removePageRequest() {
        ui.getEPortfolio().removeSelectedPage();
    }
    
    public void editComponentRequest(Component comp) {
        if(comp.getType().equals(TEXT)) {
            TextDialogView textDialog = new TextDialogView(ui, comp);
        }
        if(comp.getType().equals(SLIDESHOW)) {
            System.out.println("Component Type:" + comp.getType());
            SlideshowDialogView slideShow = new SlideshowDialogView(ui);
            Stage stage = new Stage();
            slideShow.startUI(stage, "Slideshow");
            slideShow.loadSlideShow(comp);
     // ui.startUI(stage, "Slideshow");

           // Stage stage = new Stage();
           // slideShow.startUI(stage, "Slideshow");
            
       //     SlideShowFileManager io = new SlideShowFileManager();
      //      SlideshowController controller = new SlideshowController(slideShow, io);
       //     controller.promptToOpen(comp);
        }
    }
            
   }

