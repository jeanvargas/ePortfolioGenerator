/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.view;

import ePortfolioMaker.LanguagePropertyType;
import static ePortfolioMaker.StartupConstants.DEFAULT_THUMBNAIL_WIDTH;
import static ePortfolioMaker.StartupConstants.PATH_VIDEOS;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Jeanmarie
 */
public class AddVideoDialogView {
    ePortfolioMakerView ui;
    Stage stage;
    Scene scene;
    VBox imageBox;
    GridPane image;
    Label widthLabel, heightLabel, captionLabel;
    TextField widthField, heightField, captionField;
    Button okButton, videoButton;
    PageEditController pageEditController;
    FileChooser videoFileChooser;
    File file;
    URL fileURL;
    Media video;
     ComboBox position;
    ObservableList<String> positionOptions;
    String pos = "default";
    double perc;
    double scaledHeight;
    String videoFileName, videoFilePath;
    
    public AddVideoDialogView(ePortfolioMakerView initUI){
        ui = initUI;
    }
    
    public void setUpDialog(){
        stage = new Stage();
     stage.setWidth(400);
     stage.setHeight(200); 
     
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
     
     captionLabel = new Label("Enter Video Caption:   ");
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
     
     videoButton = new Button("Click to Select a Video");
     videoButton.setOnAction(e-> {
         processSelectVideo();
     });
     
           okButton = new Button("Ok");
           okButton.setDisable(true);
           position.getSelectionModel().select("Default");
     okButton.setOnAction(e-> {
         double width, height;
         String caption = captionField.getText();
         pos = position.getSelectionModel().getSelectedItem().toString();
         
         try {   
         if(widthField.getText()==null || widthField.getText().trim().isEmpty()) {
             width = 300.0;
         }else {
             width = Double.parseDouble(widthField.getText());
         }
         
         if(heightField.getText()==null || heightField.getText().trim().isEmpty()) {
            // perc = width / video.getWidth();
             height = 169.0; 
         }else {
             height = Double.parseDouble(heightField.getText());
         }
         pageEditController.processAddComponentRequest(video, caption, pos, width, height, videoFileName, videoFilePath);
         stage.close();
         } catch(Exception a) {
                ErrorHandler eH = new ErrorHandler(null);
                eH.processError(LanguagePropertyType.ERROR_UNEXPECTED);
            }
     });
     
     imageBox.getChildren().add(videoButton);
     imageBox.getChildren().add(image);
     imageBox.getChildren().add(okButton);
     
     scene = new Scene(imageBox);
        scene.getStylesheets().add(STYLE_SHEET_UI);
        stage.setScene(scene);
        stage.show();
     
    }
    
    public void processSelectVideo() {
        pageEditController = new PageEditController(ui);
        videoFileChooser = new FileChooser();
        
        videoFileChooser.setInitialDirectory(new File(PATH_VIDEOS));
        
        FileChooser.ExtensionFilter mp4Filter = new FileChooser.ExtensionFilter("MP4 files (*.mp4)", "*.MP4");
	
	videoFileChooser.getExtensionFilters().addAll(mp4Filter);
        
        file = videoFileChooser.showOpenDialog(null);
        if (file != null) {
            try {
                fileURL = file.toURI().toURL();
                video = new Media(fileURL.toExternalForm());
                videoFileName = file.getName();
                videoFilePath = file.getPath().substring(0, file.getPath().indexOf(file.getName()));
                okButton.setDisable(false);
            } catch(Exception e) {
                ErrorHandler eH = new ErrorHandler(null);
                eH.processError(LanguagePropertyType.ERROR_UNEXPECTED);
            }
	}
    }

}
