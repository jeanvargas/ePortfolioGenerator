/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.file;

import ePortfolioMaker.model.Component;
import java.util.List;
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
public class PageFileManager {
    public static String JSON_PAGE_TITLE = "title";
    public static String JSON_STUDENT_NAME = "student_name";
    public static String JSON_BANNER_IMAGE_FILE_NAME = "banner_image_file_name";
    public static String JSON_BANNER_IMAGE_FILE_PATH = "banner_image_path";
    public static String JSON_COMPONENTS = "components";
    public static String JSON_EXT = ".json";
    public static String SLASH = "/";
    
   /* private JsonArray makeComponentsJsonArray(List<Component> components) {
        
    }
    
    private JsonObject makeTextComponentObject(Component component) {
        
    }
    
    private JsonObject makeImageComponentObject
    
    private JsonArray makeSlidesJsonArray(List<Slide> slides) {
	JsonArrayBuilder jsb = Json.createArrayBuilder();
	for (Slide slide : slides) {
	    JsonObject jso = makeSlideJsonObject(slide);
	    jsb.add(jso);
	}
	JsonArray jA = jsb.build();
	return jA;
    }

    private JsonObject makeSlideJsonObject(Slide slide) {
	JsonObject jso = Json.createObjectBuilder()
		.add(JSON_IMAGE_FILE_NAME, slide.getImageFileName())
		.add(JSON_IMAGE_PATH, slide.getImagePath())
		.add(JSON_CAPTION, slide.getCaption())
		.build();
	return jso;
    }*/
}

