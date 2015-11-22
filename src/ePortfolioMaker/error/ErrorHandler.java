/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.error;

import ePortfolioMaker.LanguagePropertyType;
import ePortfolioMaker.view.ePortfolioMakerView;
import javafx.scene.control.Alert;
import properties_manager.PropertiesManager;

/**
 *
 * @author Jeanmarie
 */
public class ErrorHandler {
    // APP UI
    private ePortfolioMakerView ui;
    
    // KEEP THE APP UI FOR LATER
    public ErrorHandler(ePortfolioMakerView initUI) {
	ui = initUI;
    }
    
    public void processError(LanguagePropertyType errorType)
    {
        // GET THE FEEDBACK TEXT
        PropertiesManager props = PropertiesManager.getPropertiesManager();
        String errorFeedbackText = props.getProperty(errorType);
             
        // POP OPEN A DIALOG TO DISPLAY TO THE USER
        Alert alertDialog = new Alert(Alert.AlertType.WARNING, errorFeedbackText);
	alertDialog.showAndWait();
    }  
}
