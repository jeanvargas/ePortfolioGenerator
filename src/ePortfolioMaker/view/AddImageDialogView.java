/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.view;

import ePortfolioMaker.LanguagePropertyType;
import static ePortfolioMaker.StartupConstants.PATH_SLIDE_SHOW_IMAGES;
import static ePortfolioMaker.StartupConstants.STYLE_SHEET_UI;
import ePortfolioMaker.controller.PageEditController;
import ePortfolioMaker.error.ErrorHandler;
import java.io.File;
import java.net.URL;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Jeanmarie
 */
public class AddImageDialogView {
    Stage stage;
    Scene scene;
    VBox imageBox;
    GridPane image;
    Label widthLabel, heightLabel, captionLabel;
    TextField widthField, heightField, captionField;
    Button okButton;
    PageEditController pageEditController;
    ePortfolioMakerView ui;
    
    public AddImageDialogView(ePortfolioMakerView initUI) {
        ui = initUI;
    }
    
    public void setUpDialog(){
     stage = new Stage();
     stage.setWidth(300);
     stage.setHeight(150); 
     
     imageBox = new VBox();
     image = new GridPane();
     widthLabel = new Label("Enter width:    ");
     widthField = new TextField();
     
     image.add(widthLabel,0,0);
     image.add(widthField,1,0);
     
     heightLabel = new Label("Enter height:   ");
     heightField = new TextField();
     image.add(heightLabel,0,1);
     image.add(heightField,1,1);
     
     captionLabel = new Label("Enter Image Caption:   ");
     captionField = new TextField();
     image.add(captionLabel,0,2);
     image.add(captionField,1,2);
     
           okButton = new Button("Ok");
     okButton.setOnAction(e-> {
         processSelectImage();
     });
     
     imageBox.getChildren().add(image);
     imageBox.getChildren().add(okButton);
     
     scene = new Scene(imageBox);
        scene.getStylesheets().add(STYLE_SHEET_UI);
        stage.setScene(scene);
        stage.show();
     
  
    }
    
    public void processSelectImage() {
        pageEditController = new PageEditController(ui);
	FileChooser imageFileChooser = new FileChooser();
	
	// SET THE STARTING DIRECTORY
	imageFileChooser.setInitialDirectory(new File(PATH_SLIDE_SHOW_IMAGES));
	
	// LET'S ONLY SEE IMAGE FILES
	FileChooser.ExtensionFilter jpgFilter = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
	FileChooser.ExtensionFilter pngFilter = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
	FileChooser.ExtensionFilter gifFilter = new FileChooser.ExtensionFilter("GIF files (*.gif)", "*.GIF");
        FileChooser.ExtensionFilter jpegFilter = new FileChooser.ExtensionFilter("JPEG files (*.jpeg)", "*.JPEG");

	imageFileChooser.getExtensionFilters().addAll(jpgFilter, pngFilter, gifFilter, jpegFilter);
	
	File file = imageFileChooser.showOpenDialog(null);
	if (file != null) {
            try {
                URL fileURL = file.toURI().toURL();
                Image imageComponent = new Image(fileURL.toExternalForm());
                pageEditController.processAddComponentRequest(imageComponent);
                stage.close();
                
            } catch(Exception e) {
                ErrorHandler eH = new ErrorHandler(null);
                eH.processError(LanguagePropertyType.ERROR_UNEXPECTED);
                stage.close();
            }
	}
    }
}
