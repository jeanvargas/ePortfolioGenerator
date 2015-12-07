/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.view;

import ePortfolioMaker.LanguagePropertyType;
import static ePortfolioMaker.StartupConstants.PATH_SLIDE_SHOW_IMAGES;
import ePortfolioMaker.error.ErrorHandler;
import ePortfolioMaker.model.ePortfolioModel;
import java.io.File;
import java.net.URL;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Jeanmarie
 */
public class AddBannerDialogView {

    
    public void processSelectImage(ePortfolioModel ePortfolio) {
	FileChooser imageFileChooser = new FileChooser();
        URL fileURL;
        Image selectedImage;
	
	// SET THE STARTING DIRECTORY
	imageFileChooser.setInitialDirectory(new File(PATH_SLIDE_SHOW_IMAGES));
	
	// LET'S ONLY SEE IMAGE FILES
	FileChooser.ExtensionFilter jpgFilter = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
	FileChooser.ExtensionFilter pngFilter = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
	FileChooser.ExtensionFilter gifFilter = new FileChooser.ExtensionFilter("GIF files (*.gif)", "*.GIF");
	imageFileChooser.getExtensionFilters().addAll(jpgFilter, pngFilter, gifFilter);
	
	// LET'S OPEN THE FILE CHOOSER
	File file = imageFileChooser.showOpenDialog(null);
	if (file != null) {
            try {
                fileURL = file.toURI().toURL();
                String path = file.getPath().substring(0, file.getPath().indexOf(file.getName()));
                String fileName = file.getName();
                selectedImage = new Image(fileURL.toExternalForm());
                ePortfolio.setBannerImageFileNamePath(path);
                ePortfolio.setBannerImageFileName(fileName);
                ePortfolio.setBannerImage(selectedImage);
            }catch(Exception e) {
                ErrorHandler eH = new ErrorHandler(null);
                eH.processError(LanguagePropertyType.ERROR_UNEXPECTED);
            }
	   // slideToEdit.setImage(path, fileName);
	   // view.updateSlideImage();
	}
    }


}
