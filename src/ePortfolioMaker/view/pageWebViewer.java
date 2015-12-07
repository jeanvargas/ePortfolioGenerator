/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.view;

import static ePortfolioMaker.StartupConstants.CSS_FOLDER;
import static ePortfolioMaker.StartupConstants.IMAGES_FOLDER;
import static ePortfolioMaker.StartupConstants.JS_FOLDER;
import static ePortfolioMaker.StartupConstants.PATH;
import static ePortfolioMaker.StartupConstants.PATH_SITES;
import ePortfolioMaker.model.Component;
import ePortfolioMaker.model.PageModel;
import java.io.File;
import java.io.IOException;
import javafx.collections.ObservableList;

/**
 *
 * @author Jeanmarie
 */
public class pageWebViewer {
    String directory;
    String imagesDir;
    String jsDir;
    String cssDir;
    String fileDir;
    
//    SlideShowFileManager fm = new SlideShowFileManager();
    ePortfolioMakerView parentView;
    PageModel page;
    ObservableList<Component> componentsArray;
    int length;   
    
     public pageWebViewer(ePortfolioMakerView parent, PageModel p) throws IOException
        {
            parentView = parent;
            page = p;
            componentsArray = page.getComponents();
            length = componentsArray.size();
            
            //Directory for new slideshow folder
            directory = PATH_SITES + page.getTitle();
            fileDir = PATH + page.getTitle();
            imagesDir = directory + IMAGES_FOLDER;
            jsDir = directory + JS_FOLDER;
            cssDir = directory + CSS_FOLDER;
            
            //create new directory
            new File(directory).mkdir();  
            
            //create images directory
            new File(imagesDir).mkdir();
            
            //create javascript directory
            new File(jsDir).mkdir();
            
            //create css directory
            new File(cssDir).mkdir();
            
         /*   //get page template and set up new page
            File htmlTemplateFile = new File(INDEX_HTML_TEMPLATE);
            setUpFromTemplates(directory, htmlTemplateFile, INDEX_HTML);
            
            //get javascript template and set up new javascript file in correct directory
            File jsTemplateFile = new File(SLIDESHOW_JS_TEMPLATE);
            setUpFromTemplates(jsDir, jsTemplateFile, SLIDESHOW_JS);
            
            //get css template and set up new css file in correct directory
            File cssTemplateFile = new File(SLIDESHOW_CSS_TEMPLATE);
            setUpFromTemplates(cssDir, cssTemplateFile, SLIDESHOW_STYLE);    
            
              copyImages();
            
              showWebView();*/
        }
}
