/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.controller;

import ePortfolioMaker.LanguagePropertyType;
import static ePortfolioMaker.LanguagePropertyType.DEFAULT_IMAGE_CAPTION;
import static ePortfolioMaker.StartupConstants.DEFAULT_SLIDE_IMAGE;
import static ePortfolioMaker.StartupConstants.PATH_SLIDE_SHOWS;
import static ePortfolioMaker.StartupConstants.PATH_SLIDE_SHOW_IMAGES;
import ePortfolioMaker.error.ErrorHandler;
import ePortfolioMaker.file.SlideShowFileManager;
import ePortfolioMaker.model.Component;
import ePortfolioMaker.model.SlideShowModel;
import ePortfolioMaker.view.SlideshowDialogView;
import ePortfolioMaker.view.ePortfolioMakerView;
import java.io.File;
import java.io.IOException;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import properties_manager.PropertiesManager;

/**
 *
 * @author Jeanmarie
 */
public class SlideshowController {
    // APP UI
    private SlideshowDialogView ui;
    private SlideShowFileManager slideShowIO;
    
    /**
     * This constructor keeps the UI for later.
     */
    public SlideshowController(SlideshowDialogView initUI, SlideShowFileManager initSlideShowFileManager) {
	ui = initUI;
        slideShowIO = initSlideShowFileManager;
    }
    
    /**
     * Provides a response for when the user wishes to add a new
     * slide to the slide show.
     */
    public void processAddSlideRequest() {
	SlideShowModel slideShow = ui.getSlideShow();
	PropertiesManager props = PropertiesManager.getPropertiesManager();
	slideShow.addSlide(DEFAULT_SLIDE_IMAGE, PATH_SLIDE_SHOW_IMAGES, props.getProperty(DEFAULT_IMAGE_CAPTION));
    }

    /**
     * Provides a response for when the user has selected a slide
     * and wishes to remove it from the slide show.
     */
    public void processRemoveSlideRequest() {
	SlideShowModel slideShow = ui.getSlideShow();
	slideShow.removeSelectedSlide();
	ui.reloadSlideShowPane();
    }

    /**
     * Provides a response for when the user has selected a slide
     * and wishes to move it up in the slide show.
     */
    public void processMoveSlideUpRequest() {
	SlideShowModel slideShow = ui.getSlideShow();
	slideShow.moveSelectedSlideUp();	
	
    }

    /**
     * Provides a response for when the user has selected a slide
     * and wises to move it down in the slide show.
     */
    public void processMoveSlideDownRequest() {
	SlideShowModel slideShow = ui.getSlideShow();
	slideShow.moveSelectedSlideDown();	
    }
    
    public boolean saveSlideShowRequest() {
        try {
            SlideShowModel slideShowToSave = ui.getSlideShow();
            slideShowIO.saveSlideShow(slideShowToSave);
            return true;
        } catch (IOException ioe) {
            ErrorHandler eH = ui.getErrorHandler();
            eH.processError(LanguagePropertyType.ERROR_UNEXPECTED);
	    return false;
        }
        
    }
    
    public void promptToOpen(SlideShowModel slideShow) {

        String absolutePath = PATH_SLIDE_SHOWS + slideShow.getTitle() + ".json";
        System.out.println("Absolute path: " + absolutePath);
            try {
		//SlideShowModel slideShowToLoad = ui.getSlideShow();
                slideShowIO.loadSlideShow(slideShow, absolutePath);
                ui.reloadSlideShowPane();
              //  saved = true;
                ui.updateToolbarControls(true);
            } catch (Exception e) {
                ErrorHandler eH = ui.getErrorHandler();
		eH.processError(LanguagePropertyType.ERROR_DATA_FILE_LOADING);
            }
        
    }

}
