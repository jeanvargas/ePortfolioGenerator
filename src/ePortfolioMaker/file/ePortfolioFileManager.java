/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.file;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;
/**
 *
 * @author Jeanmarie
 */
public class ePortfolioFileManager {
public static String JSON_TITLE ="title";
public static String JSON_PAGES = "pages";
public static String JSON_PAGE_TITLE = "page_title";
public static String JSON_COMPONENTS = "components";
public static String JSON_EXT = ".json";
public static String SLASH = "/";

public static String TEXT_COMP = "text";
public static String IMAGE_COMP = "image;";
public static String SLIDESHOW_COMP = "slideshow";
public static String VIDEO_COMP = "video";
public static String HYPERLINK_COMP = "hyperlink";    

public void saveEPortfolio() {
    
}

public void loadEPortfolio() {
    
}

private JsonObject loadArrayFromJSONFile() {
    return null;
}

private JsonArray makePagesArray(){
    return null;
}

private JsonArray makeComponentsArray() {
    return null;
}

private JsonObject makePageJsonObject() {
    return null;
}

private JsonObject makeComponentJsonObject() {
    return null;
}
        

}
