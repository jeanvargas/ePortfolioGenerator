package ePortfolioMaker.view;


import ePortfolioMaker.LanguagePropertyType;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_ADD_HYPERLINK;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_ADD_IMAGE_COMP;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_ADD_NEW_PAGE;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_ADD_SLIDESHOW_COMP;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_ADD_TEXT_COMP;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_ADD_VIDEO_COMP;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_EXIT;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_EXPORT;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_LOAD_PORTFOLIO;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_NEW_PORTFOLIO;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_PAGE_EDITOR;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_REMOVE_COMP;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_REMOVE_PAGE;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_SAVE_AS;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_SAVE_PORTFOLIO;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_SELECT_BANNER_IMAGE;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_SELECT_COLOR_TEMPLATE;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_SELECT_COMP_FONT;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_SELECT_LAYOUT_TEMPLATE;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_SITE_VIEWER;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_UPDATE_FOOTER;
import static ePortfolioMaker.StartupConstants.CSS_CLASS_FILE_TOOLBAR;
import static ePortfolioMaker.StartupConstants.CSS_CLASS_FILE_TOOLBAR_BUTTON;
import static ePortfolioMaker.StartupConstants.CSS_CLASS_PAGE_EDITOR_WORKSPACE;
import static ePortfolioMaker.StartupConstants.CSS_CLASS_PAGE_REPRESENTATION;
import static ePortfolioMaker.StartupConstants.CSS_CLASS_SITE_TOOLBAR;
import static ePortfolioMaker.StartupConstants.CSS_CLASS_SITE_TOOLBAR_BUTTON;
import static ePortfolioMaker.StartupConstants.CSS_CLASS_STUDENT_NAME_LABEL;
import static ePortfolioMaker.StartupConstants.CSS_CLASS_WORKSPACE_MODE_TOOLBAR;
import static ePortfolioMaker.StartupConstants.CSS_CLASS_WORKSPACE_MODE_TOOLBAR_BUTTON;
import static ePortfolioMaker.StartupConstants.CSS_CLASS_WORKSPACE_TOOLBAR;
import static ePortfolioMaker.StartupConstants.DEFAULT_STUDENT_NAME;
import static ePortfolioMaker.StartupConstants.ICON_ADD_HYPERLINK;
import static ePortfolioMaker.StartupConstants.ICON_ADD_IMAGE_COMP;
import static ePortfolioMaker.StartupConstants.ICON_ADD_NEW_PAGE;
import static ePortfolioMaker.StartupConstants.ICON_ADD_SLIDESHOW_COMP;
import static ePortfolioMaker.StartupConstants.ICON_ADD_TEXT_COMP;
import static ePortfolioMaker.StartupConstants.ICON_ADD_VIDEO_COMP;
import static ePortfolioMaker.StartupConstants.ICON_CHOOSE_FONT_LARGE;
import static ePortfolioMaker.StartupConstants.ICON_EXIT_PROGRAM;
import static ePortfolioMaker.StartupConstants.ICON_EXPORT_EPORTFOLIO;
import static ePortfolioMaker.StartupConstants.ICON_LOAD_EPORTFOLIO;
import static ePortfolioMaker.StartupConstants.ICON_NEW_EPORTFOLIO;
import static ePortfolioMaker.StartupConstants.ICON_PAGE_EDITOR;
import static ePortfolioMaker.StartupConstants.ICON_REMOVE_COMP;
import static ePortfolioMaker.StartupConstants.ICON_REMOVE_PAGE;
import static ePortfolioMaker.StartupConstants.ICON_SAVEAS;
import static ePortfolioMaker.StartupConstants.ICON_SAVE_EPORTFOLIO;
import static ePortfolioMaker.StartupConstants.ICON_SELECT_BANNER_IMAGE;
import static ePortfolioMaker.StartupConstants.ICON_SELECT_COLOR_TEMPLATE;
import static ePortfolioMaker.StartupConstants.ICON_SELECT_LAYOUT_TEMPLATE;
import static ePortfolioMaker.StartupConstants.ICON_SITE_VIEWER;
import static ePortfolioMaker.StartupConstants.ICON_UPDATE_FOOTER;
import static ePortfolioMaker.StartupConstants.PATH_ICONS;
import static ePortfolioMaker.StartupConstants.STYLE_SHEET_UI;
import ePortfolioMaker.controller.FileController;
import ePortfolioMaker.error.ErrorHandler;
import ePortfolioMaker.file.ePortfolioFileManager;
import ePortfolioMaker.model.ePortfolioModel;
import javafx.scene.control.Button;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;
import javafx.stage.Screen;
import javafx.stage.Stage;
import properties_manager.PropertiesManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jeanmarie
 */
public class ePortfolioMakerView {

Stage primaryStage;
Scene primaryScene;
BorderPane pmPane;

FlowPane fileToolbarPane;
Button newPortfolioButton, loadPortfolioButton, exitButton, savePortfolioButton,
        saveAsButton, exportButton;
HBox WorkspaceModeToolbar;

Button selectPageEditorWorkspace;
Button selectSiteViewerWorkspace;

VBox siteToolbarPane;
HBox sPane;
Button addPageButton, removePageButton, selectPageButton;
ScrollPane PageTitles;
BorderPane pageEditorWorkspace;

FlowPane studentNameImage;
TextField nameField;
Button addBannerImage;
   
VBox pageRepresentation;
ScrollPane pageComponents;
Label nameLabel;
Image bannerImage;
   
GridPane pageButtonsPane;
Button setLayoutButton, setColorButton, addFooterButton, addTextCompButton, editTextComp,
   addImageCompButton, editImageComp, addVideoCompButton, editVideoComp, addSlideShowCompButton, 
   editSlideShowComp, addHyperlinkCompButton, editHyperlinkComp, removeCompButton, chooseCompFontButton;

 ePortfolioModel ePortfolio;

ePortfolioFileManager fileManager;

FileController fileController;

// THIS CLASS WILL HANDLE ALL ERRORS FOR THIS PROGRAM
    private ErrorHandler errorHandler;

public ePortfolioMakerView(ePortfolioFileManager initFileManager) {
    fileManager = initFileManager;
    
    // WE'LL USE THIS ERROR HANDLER WHEN SOMETHING GOES WRONG
    errorHandler = new ErrorHandler(this);
    
    ePortfolio = new ePortfolioModel(this);
}

public ErrorHandler getErrorHandler() {
	return errorHandler;
    }

public void startUI(Stage initPrimaryStage, String windowTitle){
    initFileToolbar();
    initWorkspaceModeToolbar();
    initSiteToolbarPane();
    primaryStage = initPrimaryStage;
    initWindow(windowTitle);
    initPageEditorWorkspace();
    initEventHandlers();

    
}

public void initFileToolbar(){
    fileToolbarPane = new FlowPane();
    fileToolbarPane.getStyleClass().add(CSS_CLASS_FILE_TOOLBAR);

    // HERE ARE OUR FILE TOOLBAR BUTTONS, NOTE THAT SOME WILL
    // START AS ENABLED (false), WHILE OTHERS DISABLED (true)
    //PropertiesManager props = PropertiesManager.getPropertiesManager();
    
    newPortfolioButton = initChildButton(fileToolbarPane, ICON_NEW_EPORTFOLIO, TOOLTIP_NEW_PORTFOLIO, CSS_CLASS_FILE_TOOLBAR_BUTTON,false);
    loadPortfolioButton = initChildButton(fileToolbarPane, ICON_LOAD_EPORTFOLIO, TOOLTIP_LOAD_PORTFOLIO, CSS_CLASS_FILE_TOOLBAR_BUTTON,false);
    savePortfolioButton = initChildButton(fileToolbarPane, ICON_SAVE_EPORTFOLIO, TOOLTIP_SAVE_PORTFOLIO, CSS_CLASS_FILE_TOOLBAR_BUTTON,true);
    saveAsButton = initChildButton(fileToolbarPane, ICON_SAVEAS, TOOLTIP_SAVE_AS, CSS_CLASS_FILE_TOOLBAR_BUTTON,true);
    exportButton = initChildButton(fileToolbarPane, ICON_EXPORT_EPORTFOLIO, TOOLTIP_EXPORT, CSS_CLASS_FILE_TOOLBAR_BUTTON,true);
    exitButton = initChildButton(fileToolbarPane, ICON_EXIT_PROGRAM, TOOLTIP_EXIT, CSS_CLASS_FILE_TOOLBAR_BUTTON,false);
}

public void initWorkspaceModeToolbar(){
    WorkspaceModeToolbar = new HBox();
    
    selectPageEditorWorkspace = initChildButton(WorkspaceModeToolbar, ICON_PAGE_EDITOR, TOOLTIP_PAGE_EDITOR, CSS_CLASS_WORKSPACE_MODE_TOOLBAR_BUTTON, true);
    selectSiteViewerWorkspace = initChildButton(WorkspaceModeToolbar, ICON_SITE_VIEWER, TOOLTIP_SITE_VIEWER, CSS_CLASS_WORKSPACE_MODE_TOOLBAR_BUTTON, true);
}

public void initSiteToolbarPane() {
    siteToolbarPane = new VBox();
    sPane = new HBox();
    
    addPageButton = initChildButton(sPane, ICON_ADD_NEW_PAGE, TOOLTIP_ADD_NEW_PAGE, CSS_CLASS_SITE_TOOLBAR_BUTTON, true);
    removePageButton = initChildButton(sPane, ICON_REMOVE_PAGE, TOOLTIP_REMOVE_PAGE, CSS_CLASS_SITE_TOOLBAR_BUTTON, true);   

    siteToolbarPane.getChildren().add(sPane);
    
    testSiteToolbarPane();
}

public void initPageEditorWorkspace(){
    pageEditorWorkspace = new BorderPane();
   // pageEditorWorkspace.getStyleClass().add(CSS_CLASS_PAGE_EDITOR_WORKSPACE);
    pageEditorWorkspace.setPrefSize((primaryStage.getWidth()-siteToolbarPane.getWidth()), (primaryStage.getHeight()-fileToolbarPane.getHeight()));
    initStudentNameImagePane();
    initPageRepresentation();
    initPageButtonsPane();
    pageEditorWorkspace.setTop(studentNameImage);
    pageEditorWorkspace.setCenter(pageComponents);
    pageEditorWorkspace.setRight(pageButtonsPane);
    
}

public void initStudentNameImagePane() {
    studentNameImage = new FlowPane();
    studentNameImage.getStyleClass().add(CSS_CLASS_FILE_TOOLBAR);
    nameField = new TextField();
    nameField.setText(DEFAULT_STUDENT_NAME);
    studentNameImage.getChildren().add(nameField);
        
    addBannerImage = initChildButton(studentNameImage, 
    ICON_SELECT_BANNER_IMAGE, TOOLTIP_SELECT_BANNER_IMAGE, 
        CSS_CLASS_FILE_TOOLBAR_BUTTON, false);   
}

public void initPageRepresentation() {
  pageRepresentation = new VBox(); 
  pageComponents = new ScrollPane(pageRepresentation);
  pageRepresentation.getStyleClass().add(CSS_CLASS_PAGE_REPRESENTATION);
  nameLabel = new Label(ePortfolio.getTitle());
  nameLabel.getStyleClass().add(CSS_CLASS_STUDENT_NAME_LABEL);
  pageRepresentation.getChildren().add(nameLabel);
}
    
public void initPageButtonsPane () {
    pageButtonsPane = new GridPane();  
    setLayoutButton = initChildButton(ICON_SELECT_LAYOUT_TEMPLATE, TOOLTIP_SELECT_LAYOUT_TEMPLATE, CSS_CLASS_FILE_TOOLBAR, false);
    setColorButton = initChildButton(ICON_SELECT_COLOR_TEMPLATE, TOOLTIP_SELECT_COLOR_TEMPLATE, CSS_CLASS_FILE_TOOLBAR, false);
    addFooterButton = initChildButton(ICON_UPDATE_FOOTER, TOOLTIP_UPDATE_FOOTER, CSS_CLASS_FILE_TOOLBAR, false);
    
    addTextCompButton = initChildButton(ICON_ADD_TEXT_COMP, TOOLTIP_ADD_TEXT_COMP, CSS_CLASS_FILE_TOOLBAR, false);
    addImageCompButton = initChildButton(ICON_ADD_IMAGE_COMP, TOOLTIP_ADD_IMAGE_COMP, CSS_CLASS_FILE_TOOLBAR, false);
    addVideoCompButton = initChildButton(ICON_ADD_VIDEO_COMP, TOOLTIP_ADD_VIDEO_COMP, CSS_CLASS_FILE_TOOLBAR, false);
    
    addSlideShowCompButton = initChildButton(ICON_ADD_SLIDESHOW_COMP, TOOLTIP_ADD_SLIDESHOW_COMP, CSS_CLASS_FILE_TOOLBAR, false);
    addHyperlinkCompButton = initChildButton(ICON_ADD_HYPERLINK, TOOLTIP_ADD_HYPERLINK, CSS_CLASS_FILE_TOOLBAR, false);
    removeCompButton = initChildButton(ICON_REMOVE_COMP,TOOLTIP_REMOVE_COMP, CSS_CLASS_FILE_TOOLBAR, false);

    chooseCompFontButton = initChildButton(ICON_CHOOSE_FONT_LARGE,TOOLTIP_SELECT_COMP_FONT, CSS_CLASS_FILE_TOOLBAR, false);
    
    pageButtonsPane.add(setLayoutButton,0,0);
    pageButtonsPane.add(setColorButton,1,0);
    pageButtonsPane.add(addFooterButton,2,0);
    
    pageButtonsPane.add(addTextCompButton,0,1);
    pageButtonsPane.add(addImageCompButton,1,1);
    pageButtonsPane.add(addVideoCompButton,2,1);
    
    pageButtonsPane.add(addSlideShowCompButton,0,2);
    pageButtonsPane.add(addHyperlinkCompButton,1,2);
    pageButtonsPane.add(removeCompButton,2,2);
    
    pageButtonsPane.add(chooseCompFontButton,0,3);
    
}
public void initEventHandlers(){
  fileController = new FileController(this);  
  
  newPortfolioButton.setOnAction(e -> {
  fileController.handleNewEPortfolioRequest();
  });
  
  //SITE VIEWER WORKSPACE
  selectSiteViewerWorkspace.setOnAction(e -> {
      fileController.handleSiteViewerWorkspaceRequest();
  });
  selectPageEditorWorkspace.setOnAction(e -> {
     fileController.handlePageEditorWorkspaceRequest();
  });
  
  //COMPONENTS
  addTextCompButton.setOnAction(e -> {
      fileController.handleAddTextComponentRequest();
  });
  chooseCompFontButton.setOnAction(e -> {
      fileController.handleChooseCompFontRequest();
  });
  addSlideShowCompButton.setOnAction(e -> {
      fileController.handleSlideshowRequest();
  });
  
}

public void initWindow(String windowTitle){
    //SET WINDOW TITLE
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
    pmPane = new BorderPane();
    WorkspaceModeToolbar.setPrefSize(200, 50);
    WorkspaceModeToolbar.getStyleClass().add(CSS_CLASS_WORKSPACE_MODE_TOOLBAR);
    
    /*Path path = new Path();
    path.getElements().add(new MoveTo(50.0f, fileToolbarPane.getHeight()));
    path.getElements().add(new VLineTo(50.0f));
    WorkspaceModeToolbar.getChildren().add(path);*/
    
    
    fileToolbarPane.getChildren().add(WorkspaceModeToolbar);
    
    siteToolbarPane.setPrefSize(100, (primaryStage.getHeight()-fileToolbarPane.getHeight()));
    siteToolbarPane.getStyleClass().add(CSS_CLASS_SITE_TOOLBAR);
    
    pmPane.setTop(fileToolbarPane);
    pmPane.setLeft(siteToolbarPane);
    primaryScene = new Scene(pmPane);
    
    // NOW TIE THE SCENE TO THE WINDOW, SELECT THE STYLESHEET
	// WE'LL USE TO STYLIZE OUR GUI CONTROLS, AND OPEN THE WINDOW
	primaryScene.getStylesheets().add(STYLE_SHEET_UI);
	primaryStage.setScene(primaryScene);
	primaryStage.show();
    
}

public Button initChildButton(String iconFileName, LanguagePropertyType tooltip, String cssClass, boolean disabled) {
    PropertiesManager props = PropertiesManager.getPropertiesManager();
    String imagePath = "file:" + PATH_ICONS + iconFileName;
    Image buttonImage = new Image(imagePath);
    Button button = new Button();
    button.getStyleClass().add(cssClass);
    button.setDisable(disabled);
    button.setGraphic(new ImageView(buttonImage));
    Tooltip buttonTooltip = new Tooltip(props.getProperty(tooltip.toString()));
    button.setTooltip(buttonTooltip);
    return button;
}

public Button initChildButton(Pane toolbar, String iconFileName, LanguagePropertyType tooltip, String cssClass, boolean disabled) {
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

public void updateToolbarControls(boolean saved){
    //ADD PAGE EDITOR WORKSPACE
    pmPane.setCenter(pageEditorWorkspace);
    
    //ENABLE BUTTONS
    addPageButton.setDisable(false);
    selectSiteViewerWorkspace.setDisable(false);
    selectPageEditorWorkspace.setDisable(true);
    
    savePortfolioButton.setDisable(saved);
    saveAsButton.setDisable(saved);
}

public void reloadFileSiteControls() {
    
}

public void reloadPortfolioPages()
{
    
}

public void siteViewer(VBox siteViewer) {
    pmPane.setCenter(siteViewer);
    selectPageEditorWorkspace.setDisable(false);
    selectSiteViewerWorkspace.setDisable(true);
    addPageButton.setDisable(true);
    removePageButton.setDisable(true);
}

public void testSiteToolbarPane() {
    Button dummy1 = new Button("Page 1");
    Button dummy2 = new Button("Page 2");
    Button dummy3 = new Button("Page 3");
    Button dummy4 = new Button("Page 4");
    Button dummy5 = new Button("Page 5");
    
    siteToolbarPane.getChildren().add(dummy1);
    siteToolbarPane.getChildren().add(dummy2);
    siteToolbarPane.getChildren().add(dummy3);
    siteToolbarPane.getChildren().add(dummy4);
    siteToolbarPane.getChildren().add(dummy5);

}

}

    