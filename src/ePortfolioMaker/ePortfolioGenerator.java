package ePortfolioMaker;

import static ePortfolioMaker.LanguagePropertyType.TITLE_WINDOW;
import static ePortfolioMaker.StartupConstants.PATH_DATA;
import static ePortfolioMaker.StartupConstants.PROPERTIES_SCHEMA_FILE_NAME;
import static ePortfolioMaker.StartupConstants.UI_PROPERTIES_FILE_NAME;
import ePortfolioMaker.error.ErrorHandler;
import ePortfolioMaker.view.ePortfolioMakerView;
import ePortfolioMaker.file.ePortfolioFileManager;
import java.io.File;
import java.net.URL;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import properties_manager.PropertiesManager;
import xml_utilities.InvalidXMLFileFormatException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jeanmarie
 */
public class ePortfolioGenerator extends Application{

    ePortfolioFileManager fileManager = new ePortfolioFileManager();
    
    ePortfolioMakerView ui = new ePortfolioMakerView(fileManager);
    @Override
    public void start(Stage primaryStage) throws Exception {
        // SET THE WINDOW ICON
	/*String imagePath = PATH_IMAGES + ICON_WINDOW_LOGO;
	File file = new File(imagePath);
	
	// GET AND SET THE IMAGE
	URL fileURL = file.toURI().toURL();
	Image windowIcon = new Image(fileURL.toExternalForm());
	primaryStage.getIcons().add(windowIcon);*/
        
        // LOAD APP SETTINGS INTO THE GUI AND START IT UP
        boolean success = loadProperties();
        
        if (success) {
            PropertiesManager props = PropertiesManager.getPropertiesManager();
            String appTitle = props.getProperty(TITLE_WINDOW);

	    // NOW START THE UI IN EVENT HANDLING MODE
	    ui.startUI(primaryStage, appTitle);
	} // THERE WAS A PROBLEM LOADING THE PROPERTIES FILE
	else {
	    // LET THE ERROR HANDLER PROVIDE THE RESPONSE
	    ErrorHandler errorHandler = ui.getErrorHandler();
	    errorHandler.processError(LanguagePropertyType.ERROR_DATA_FILE_LOADING);
	    System.exit(0);
	}
    }
    
    public boolean loadProperties() {
          try {
            // LOAD THE SETTINGS FOR STARTING THE APP
            PropertiesManager props = PropertiesManager.getPropertiesManager();
            props.addProperty(PropertiesManager.DATA_PATH_PROPERTY, PATH_DATA);
	    props.loadProperties(UI_PROPERTIES_FILE_NAME, PROPERTIES_SCHEMA_FILE_NAME);
            return true;
       } catch (InvalidXMLFileFormatException ixmlffe) {
            // SOMETHING WENT WRONG INITIALIZING THE XML FILE
            ErrorHandler eH = ui.getErrorHandler();
            eH.processError(LanguagePropertyType.ERROR_PROPERTIES_FILE_LOADING);
           // eH.processError(LanguagePropertyType.ERROR_PROPERTIES_FILE_LOADING, "todo", "todo");
            return false;
        }        
    }
    
    public static void main(String[] args) {
	launch(args);
    }
    
}
