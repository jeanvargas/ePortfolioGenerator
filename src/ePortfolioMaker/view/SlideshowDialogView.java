/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.view;

import ePortfolioMaker.LanguagePropertyType;
import static ePortfolioMaker.LanguagePropertyType.LABEL_SLIDESHOW_TITLE;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_ADD_SLIDE;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_MOVE_DOWN;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_MOVE_UP;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_REMOVE_SLIDE;
import static ePortfolioMaker.StartupConstants.CSS_CLASS_SELECTED_SLIDE_EDIT_VIEW;
import static ePortfolioMaker.StartupConstants.CSS_CLASS_SLIDE_EDIT_VIEW;
import static ePortfolioMaker.StartupConstants.CSS_CLASS_SLIDE_SHOW_EDIT_VBOX;
import static ePortfolioMaker.StartupConstants.CSS_CLASS_VERTICAL_TOOLBAR_BUTTON;
import static ePortfolioMaker.StartupConstants.ICON_ADD_SLIDE;
import static ePortfolioMaker.StartupConstants.ICON_MOVE_DOWN;
import static ePortfolioMaker.StartupConstants.ICON_MOVE_UP;
import static ePortfolioMaker.StartupConstants.ICON_REMOVE_SLIDE;
import static ePortfolioMaker.StartupConstants.PATH_ICONS;
import static ePortfolioMaker.StartupConstants.STYLE_SHEET_UI;
import ePortfolioMaker.controller.PageEditController;
import ePortfolioMaker.controller.SlideshowController;
import ePortfolioMaker.error.ErrorHandler;
import ePortfolioMaker.file.SlideShowFileManager;
import ePortfolioMaker.model.Component;
import ePortfolioMaker.model.Slide;
import ePortfolioMaker.model.SlideShowModel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import properties_manager.PropertiesManager;

/**
 *
 * @author Jeanmarie
 */
public class SlideshowDialogView {
    // THIS IS THE MAIN APPLICATION UI WINDOW AND ITS SCENE GRAPH
    Stage primaryStage;
    Scene primaryScene;

    // THIS PANE ORGANIZES THE BIG PICTURE CONTAINERS FOR THE
    // APPLICATION GUI
    BorderPane ssmPane;
    
    // WORKSPACE
    HBox workspace;

    // THIS WILL GO IN THE LEFT SIDE OF THE SCREEN
    VBox slideEditToolbar;
    Button addSlideButton;
    Button removeSlideButton;
    Button moveSlideUpButton;
    Button moveSlideDownButton;
    Button doneButton;
    
    // FOR THE SLIDE SHOW TITLE
    FlowPane titlePane;
    Label titleLabel;
    TextField titleTextField;
    
    // AND THIS WILL GO IN THE CENTER
    ScrollPane slidesEditorScrollPane;
    VBox slidesEditorPane;

    // THIS IS THE SLIDE SHOW WE'RE WORKING WITH
    SlideShowModel slideShow;

    // THIS IS FOR SAVING AND LOADING SLIDE SHOWS
    SlideShowFileManager fileManager;

    // THIS CLASS WILL HANDLE ALL ERRORS FOR THIS PROGRAM
   private ErrorHandler errorHandler;
   
private SlideshowController editController;
ePortfolioMakerView ePortfolio;
    public SlideshowDialogView(ePortfolioMakerView e) {
        ePortfolio = e;
        
	// MAKE THE DATA MANAGING MODEL
	slideShow = new SlideShowModel(ePortfolio, this);

        fileManager = new SlideShowFileManager();
	// WE'LL USE THIS ERROR HANDLER WHEN SOMETHING GOES WRONG
//	errorHandler = new ErrorHandler(ePortfolio);
    }

    // ACCESSOR METHODS
    public SlideShowModel getSlideShow() {
	return slideShow;
    }

    public Stage getWindow() {
	return primaryStage;
    }

    public ErrorHandler getErrorHandler() {
	return errorHandler;
    }
    
    public void loadSlideShow(Component comp) {
        editController = new SlideshowController(this, fileManager);
        setSlideShow(comp.getSlideShowComponent());
        editController.promptToOpen(slideShow);
    }
    
    public void setSlideShow(SlideShowModel s) {
        slideShow = s;
    }

     public void startUI(Stage initPrimaryStage, String windowTitle) {

        // INIT THE CENTER WORKSPACE CONTROLS BUT DON'T ADD THEM
	// TO THE WINDOW YET
	initWorkspace();

	// NOW SETUP THE EVENT HANDLERS
	initEventHandlers();

	// AND FINALLY START UP THE WINDOW (WITHOUT THE WORKSPACE)
	// KEEP THE WINDOW FOR LATER
	primaryStage = initPrimaryStage;
	initWindow(windowTitle);
        updateToolbarControls(true);
    }
     
     private void initWorkspace() {
	// FIRST THE WORKSPACE ITSELF, WHICH WILL CONTAIN TWO REGIONS
	workspace = new HBox();
	
	// THIS WILL GO IN THE LEFT SIDE OF THE SCREEN
	slideEditToolbar = new VBox();
	slideEditToolbar.getStyleClass().add(CSS_CLASS_SLIDE_SHOW_EDIT_VBOX);
	addSlideButton = this.initChildButton(slideEditToolbar,		ICON_ADD_SLIDE,	    TOOLTIP_ADD_SLIDE,	    CSS_CLASS_VERTICAL_TOOLBAR_BUTTON,  true);
	removeSlideButton = this.initChildButton(slideEditToolbar,	ICON_REMOVE_SLIDE,  TOOLTIP_REMOVE_SLIDE,   CSS_CLASS_VERTICAL_TOOLBAR_BUTTON,  true);
	moveSlideUpButton = this.initChildButton(slideEditToolbar,	ICON_MOVE_UP,	    TOOLTIP_MOVE_UP,	    CSS_CLASS_VERTICAL_TOOLBAR_BUTTON,  true);
	moveSlideDownButton = this.initChildButton(slideEditToolbar,	ICON_MOVE_DOWN,	    TOOLTIP_MOVE_DOWN,	    CSS_CLASS_VERTICAL_TOOLBAR_BUTTON,  true);
	slideEditToolbar.setAlignment(Pos.CENTER);
        slideEditToolbar.setSpacing(10);
	
        // AND THIS WILL GO IN THE CENTER
	slidesEditorPane = new VBox();
	slidesEditorScrollPane = new ScrollPane(slidesEditorPane);
	initTitleControls();
	
	// NOW PUT THESE TWO IN THE WORKSPACE
	workspace.getChildren().add(slideEditToolbar);
	workspace.getChildren().add(slidesEditorScrollPane);
    }
    
    private void initEventHandlers() {
	
	// SLIDE SHOW EDIT CONTROLS
	editController = new SlideshowController(this, fileManager);
	addSlideButton.setOnAction(e -> {
	    editController.processAddSlideRequest();
	});
	removeSlideButton.setOnAction(e -> {
	    editController.processRemoveSlideRequest();
	});
	moveSlideUpButton.setOnAction(e -> {
	    editController.processMoveSlideUpRequest();
	});
	moveSlideDownButton.setOnAction(e -> {
	    editController.processMoveSlideDownRequest();
	});
    }
    
      private void initWindow(String windowTitle) {
	// SET THE WINDOW TITLE
	primaryStage.setTitle(windowTitle);

	// GET THE SIZE OF THE SCREEN
	Screen screen = Screen.getPrimary();
	Rectangle2D bounds = screen.getVisualBounds();

	// AND USE IT TO SIZE THE WINDOW
	primaryStage.setX(bounds.getMinX());
	primaryStage.setY(bounds.getMinY());
	primaryStage.setWidth(bounds.getWidth());
	primaryStage.setHeight(bounds.getHeight());

        // SETUP THE UI, NOTE WE'LL ADD THE WORKSPACE LATER
	ssmPane = new BorderPane();
	primaryScene = new Scene(ssmPane);
	
        // NOW TIE THE SCENE TO THE WINDOW, SELECT THE STYLESHEET
	// WE'LL USE TO STYLIZE OUR GUI CONTROLS, AND OPEN THE WINDOW
	primaryScene.getStylesheets().add(STYLE_SHEET_UI);
	primaryStage.setScene(primaryScene);
	primaryStage.show();
    }
      
        public Button initChildButton(
	    Pane toolbar, 
	    String iconFileName, 
	    LanguagePropertyType tooltip, 
	    String cssClass,
	    boolean disabled) {
	PropertiesManager props = PropertiesManager.getPropertiesManager();
	String imagePath = "file:" + PATH_ICONS + iconFileName;
	Image buttonImage = new Image(imagePath);
	Button button = new Button();
	button.getStyleClass().add(cssClass);
	button.setDisable(disabled);
	button.setGraphic(new ImageView(buttonImage));
	Tooltip buttonTooltip = new Tooltip(props.getProperty(tooltip.toString()));
	button.setTooltip(buttonTooltip);
	toolbar.getChildren().add(button);
	return button;
    }
        
    public void updateSlideshowEditToolbarControls() {
	// AND THE SLIDESHOW EDIT TOOLBAR
	addSlideButton.setDisable(false);
	boolean slideSelected = slideShow.isSlideSelected();
	removeSlideButton.setDisable(!slideSelected);
	moveSlideUpButton.setDisable(!slideSelected);
	moveSlideDownButton.setDisable(!slideSelected);	
    }
    
    public void reloadSlideShowPane() {
	slidesEditorPane.getChildren().clear();
	reloadTitleControls();
	for (Slide slide : slideShow.getSlides()) {
	    SlideEditView slideEditor = new SlideEditView(slide);
	    if (slideShow.isSelectedSlide(slide))
		slideEditor.getStyleClass().add(CSS_CLASS_SLIDE_EDIT_VIEW);
	    else
		slideEditor.getStyleClass().add(CSS_CLASS_SELECTED_SLIDE_EDIT_VIEW);
	    slidesEditorPane.getChildren().add(slideEditor);
	    slideEditor.setOnMousePressed(e -> {
		slideShow.setSelectedSlide(slide);
		this.reloadSlideShowPane();
	    });
	}
	updateSlideshowEditToolbarControls();
    }
    
    private void initTitleControls() {
	titlePane = new FlowPane();
        /*PropertiesManager props = PropertiesManager.getPropertiesManager();
	String labelPrompt = props.getProperty(LABEL_SLIDESHOW_TITLE);
	titlePane = new FlowPane();
	titleLabel = new Label(labelPrompt);
	titleTextField = new TextField();
	
	titlePane.getChildren().add(titleLabel);
	titlePane.getChildren().add(titleTextField);
	
	String titlePrompt = props.getProperty(LanguagePropertyType.LABEL_SLIDESHOW_TITLE);
	titleTextField.setText("Enter title");*/
        PageEditController pageEditController = new PageEditController(ePortfolio);
        editController = new SlideshowController(this, fileManager);
        doneButton = new Button("Done");
        doneButton.setOnAction(e -> {
            editController.saveSlideShowRequest();
            pageEditController.processAddComponentRequest(slideShow);
            primaryStage.close();
        });
        titlePane.getChildren().add(doneButton);
        //handleSaveSlideShowRequest
                
	/*titleTextField.textProperty().addListener(e -> {
	    slideShow.setTitle(titleTextField.getText());
	});*/
    }
    
    public void reloadTitleControls() {
	slidesEditorPane.getChildren().add(titlePane);
    }
    
    public void updateToolbarControls(boolean saved) {
	// FIRST MAKE SURE THE WORKSPACE IS THERE
	ssmPane.setCenter(workspace);
	
	// NEXT ENABLE/DISABLE BUTTONS AS NEEDED IN THE FILE TOOLBAR
	//saveSlideShowButton.setDisable(saved);	
	updateSlideshowEditToolbarControls();
    }

}
