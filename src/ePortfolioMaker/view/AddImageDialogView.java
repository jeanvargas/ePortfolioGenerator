/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.view;

import ePortfolioMaker.LanguagePropertyType;
import static ePortfolioMaker.StartupConstants.DEFAULT_THUMBNAIL_WIDTH;
import static ePortfolioMaker.StartupConstants.PATH_SLIDE_SHOW_IMAGES;
import static ePortfolioMaker.StartupConstants.STYLE_SHEET_UI;
import ePortfolioMaker.controller.PageEditController;
import ePortfolioMaker.error.ErrorHandler;
import java.io.File;
import java.net.URL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    Label widthLabel, heightLabel, captionLabel, positionLabel;
    TextField widthField, heightField, captionField;
    ComboBox position;
    ObservableList<String> positionOptions;
    Button imageButton, okButton;
    PageEditController pageEditController;
    ePortfolioMakerView ui;
    FileChooser imageFileChooser;
    File file;
    URL fileURL;
    Image imageComponent;
    String pos = "default";
    double perc;
    double scaledHeight;
    String imageFileName, imageFilePath;
    
    public AddImageDialogView(ePortfolioMakerView initUI) {
        ui = initUI;
    }
    
    public void setUpDialog(){
     stage = new Stage();
     stage.setWidth(400);
     stage.setHeight(200); 
     
     imageBox = new VBox();
     image = new GridPane();
     widthLabel = new Label("Enter image width(optional):    ");
     widthField = new TextField();
     
     image.add(widthLabel,0,0);
     image.add(widthField,1,0);
     
     heightLabel = new Label("Enter height(optional):   ");
     heightField = new TextField();
     image.add(heightLabel,0,1);
     image.add(heightField,1,1);
     
     captionLabel = new Label("Enter Image Caption(optional):   ");
     captionField = new TextField();
     image.add(captionLabel,0,2);
     image.add(captionField,1,2);
     
     positionOptions = FXCollections.observableArrayList(
        "Left",
        "Right",
        "Default");
     
     position = new ComboBox(positionOptions);
     position.setPromptText("Select Image Position(optional):   ");
     image.add(position,0,3);
     
           imageButton = new Button("Click to Select an Image");
     imageButton.setOnAction(e-> {
         processSelectImage();
     });
     
	position.getSelectionModel().select("Default");
     
     okButton = new Button("OK");
     okButton.setDisable(true);
     okButton.setOnAction(e-> {
         double width, height;
         String caption = captionField.getText();
         pos = position.getSelectionModel().getSelectedItem().toString();
         
         try {   
         if(widthField.getText()==null || widthField.getText().trim().isEmpty()) {
             width = DEFAULT_THUMBNAIL_WIDTH;
         }else {
             width = Double.parseDouble(widthField.getText());
         }
         
         if(heightField.getText()==null || heightField.getText().trim().isEmpty()) {
             perc = width / imageComponent.getWidth();
             height = imageComponent.getHeight() * perc;
         }else {
             height = Double.parseDouble(heightField.getText());
         }
         pageEditController.processAddComponentRequest(imageComponent, caption, pos, width, height, imageFileName, imageFilePath);
         stage.close();
         } catch(Exception a) {
                ErrorHandler eH = new ErrorHandler(null);
                eH.processError(LanguagePropertyType.ERROR_UNEXPECTED);
            }
     });
     
     imageBox.getChildren().add(imageButton);
     imageBox.getChildren().add(image);
     imageBox.getChildren().add(okButton);
     
     scene = new Scene(imageBox);
        scene.getStylesheets().add(STYLE_SHEET_UI);
        stage.setScene(scene);
        stage.show();
     
  
    }
    
    public void processSelectImage() {
        pageEditController = new PageEditController(ui);
	imageFileChooser = new FileChooser();
	
	// SET THE STARTING DIRECTORY
	imageFileChooser.setInitialDirectory(new File(PATH_SLIDE_SHOW_IMAGES));
	
	// LET'S ONLY SEE IMAGE FILES
	FileChooser.ExtensionFilter jpgFilter = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
	FileChooser.ExtensionFilter pngFilter = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
	FileChooser.ExtensionFilter gifFilter = new FileChooser.ExtensionFilter("GIF files (*.gif)", "*.GIF");
        FileChooser.ExtensionFilter jpegFilter = new FileChooser.ExtensionFilter("JPEG files (*.jpeg)", "*.JPEG");

	imageFileChooser.getExtensionFilters().addAll(jpgFilter, pngFilter, gifFilter, jpegFilter);
	
	file = imageFileChooser.showOpenDialog(null);
	if (file != null) {
            try {
                fileURL = file.toURI().toURL();
                imageComponent = new Image(fileURL.toExternalForm());
                imageFileName = file.getName();
                imageFilePath = file.getPath().substring(0, file.getPath().indexOf(file.getName()));
                okButton.setDisable(false);
            } catch(Exception e) {
                ErrorHandler eH = new ErrorHandler(null);
                eH.processError(LanguagePropertyType.ERROR_UNEXPECTED);
            }
	}
    }
}
