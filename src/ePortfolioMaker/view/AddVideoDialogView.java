/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.view;

import static ePortfolioMaker.StartupConstants.PATH_SLIDE_SHOWS;
import static ePortfolioMaker.StartupConstants.STYLE_SHEET_UI;
import java.io.File;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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
    Button okButton;
    
    public AddVideoDialogView(ePortfolioMakerView initUI){
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
     
     captionLabel = new Label("Enter Video Caption:   ");
     captionField = new TextField();
     image.add(captionLabel,0,2);
     image.add(captionField,1,2);
     
           okButton = new Button("Ok");
     okButton.setOnAction(e-> {
         promptToOpen();
     });
     
     imageBox.getChildren().add(image);
     imageBox.getChildren().add(okButton);
     
     scene = new Scene(imageBox);
        scene.getStylesheets().add(STYLE_SHEET_UI);
        stage.setScene(scene);
        stage.show();
     
    }
    
    public void promptToOpen() {
        // AND NOW ASK THE USER FOR THE COURSE TO OPEN
        FileChooser slideShowFileChooser = new FileChooser();
        slideShowFileChooser.setInitialDirectory(new File(PATH_SLIDE_SHOWS));
        File selectedFile = slideShowFileChooser.showOpenDialog(ui.getWindow());

        // ONLY OPEN A NEW FILE IF THE USER SAYS OK
       /* if (selectedFile != null) {
            try {
		SlideShowModel slideShowToLoad = ui.getSlideShow();
                slideShowIO.loadSlideShow(slideShowToLoad, selectedFile.getAbsolutePath());
                ui.reloadSlideShowPane();
                saved = true;
                ui.updateToolbarControls(saved);
            } catch (Exception e) {
                ErrorHandler eH = ui.getErrorHandler();
		eH.processError(LanguagePropertyType.ERROR_UNEXPECTED);
            }
        }*/
    }

}
