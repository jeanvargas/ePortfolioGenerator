package ePortfolioMaker.view;


import ePortfolioMaker.LanguagePropertyType;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_ADD_NEW_PAGE;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_EXIT;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_EXPORT;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_LOAD_PORTFOLIO;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_NEW_PORTFOLIO;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_PAGE_EDITOR;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_REMOVE_PAGE;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_SAVE_AS;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_SAVE_PORTFOLIO;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_SITE_VIEWER;
import static ePortfolioMaker.StartupConstants.CSS_CLASS_FILE_TOOLBAR;
import static ePortfolioMaker.StartupConstants.CSS_CLASS_FILE_TOOLBAR_BUTTON;
import static ePortfolioMaker.StartupConstants.CSS_CLASS_PAGE_EDITOR_WORKSPACE;
import static ePortfolioMaker.StartupConstants.CSS_CLASS_SITE_TOOLBAR;
import static ePortfolioMaker.StartupConstants.CSS_CLASS_SITE_TOOLBAR_BUTTON;
import static ePortfolioMaker.StartupConstants.CSS_CLASS_WORKSPACE_MODE_TOOLBAR;
import static ePortfolioMaker.StartupConstants.CSS_CLASS_WORKSPACE_MODE_TOOLBAR_BUTTON;
import static ePortfolioMaker.StartupConstants.CSS_CLASS_WORKSPACE_TOOLBAR;
import static ePortfolioMaker.StartupConstants.ICON_ADD_NEW_PAGE;
import static ePortfolioMaker.StartupConstants.ICON_EXIT_PROGRAM;
import static ePortfolioMaker.StartupConstants.ICON_EXPORT_EPORTFOLIO;
import static ePortfolioMaker.StartupConstants.ICON_LOAD_EPORTFOLIO;
import static ePortfolioMaker.StartupConstants.ICON_NEW_EPORTFOLIO;
import static ePortfolioMaker.StartupConstants.ICON_PAGE_EDITOR;
import static ePortfolioMaker.StartupConstants.ICON_REMOVE_PAGE;
import static ePortfolioMaker.StartupConstants.ICON_SAVEAS;
import static ePortfolioMaker.StartupConstants.ICON_SAVE_EPORTFOLIO;
import static ePortfolioMaker.StartupConstants.ICON_SITE_VIEWER;
import static ePortfolioMaker.StartupConstants.PATH_ICONS;
import static ePortfolioMaker.StartupConstants.STYLE_SHEET_UI;
import ePortfolioMaker.controller.FileController;
import ePortfolioMaker.error.ErrorHandler;
import ePortfolioMaker.file.ePortfolioFileManager;
import javafx.scene.control.Button;
import java.awt.ScrollPane;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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
Button newPortfolioButton, loadPortfolioButton, exitButton, savePortfolioButton, saveAsButton, exportButton;
HBox WorkspaceModeToolbar;

Button selectPageEditorWorkspace;
Button selectSiteViewerWorkspace;

HBox Workspace;
VBox siteToolbarPane;
HBox sPane;
Button addPageButton, removePageButton, selectPageButton;
ScrollPane PageTitles;
VBox pageEditorWorkspace;

ePortfolioFileManager fileManager;

FileController fileController;

// THIS CLASS WILL HANDLE ALL ERRORS FOR THIS PROGRAM
    private ErrorHandler errorHandler;

public ePortfolioMakerView(ePortfolioFileManager initFileManager) {
    fileManager = initFileManager;
    
    // WE'LL USE THIS ERROR HANDLER WHEN SOMETHING GOES WRONG
    errorHandler = new ErrorHandler(this);
}

public ErrorHandler getErrorHandler() {
	return errorHandler;
    }

public void startUI(Stage initPrimaryStage, String windowTitle){
    initFileToolbar();
    initWorkspaceModeToolbar();
    initSiteToolbarPane();
    initPageEditorWorkspace();
    initWorkspace();
        initEventHandlers();
    primaryStage = initPrimaryStage;
    initWindow(windowTitle);
    
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
}

public void initPageEditorWorkspace(){
    pageEditorWorkspace = new VBox();
    pageEditorWorkspace.getStyleClass().add(CSS_CLASS_PAGE_EDITOR_WORKSPACE);
}
        

public void initWorkspace(){
    // FIRST THE WORKSPACE ITSELF, WHICH WILL CONTAIN TWO REGIONS
              
}

public void initEventHandlers(){
  fileController = new FileController(this);  
  newPortfolioButton.setOnAction(e -> {
  fileController.handleNewEPortfolioRequest();
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
    
    pageEditorWorkspace.setPrefSize((primaryStage.getWidth()-siteToolbarPane.getWidth()), (primaryStage.getHeight()-fileToolbarPane.getHeight()));

    pmPane.setTop(fileToolbarPane);
    pmPane.setLeft(siteToolbarPane);
    pmPane.setCenter(pageEditorWorkspace);
    primaryScene = new Scene(pmPane);
    
    // NOW TIE THE SCENE TO THE WINDOW, SELECT THE STYLESHEET
	// WE'LL USE TO STYLIZE OUR GUI CONTROLS, AND OPEN THE WINDOW
	primaryScene.getStylesheets().add(STYLE_SHEET_UI);
	primaryStage.setScene(primaryScene);
	primaryStage.show();
    
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
    addPageButton.setDisable(false);
}

public void reloadFileSiteControls() {
    
}

public void reloadPortfolioPages()
{
    
}

}

    