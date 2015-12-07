/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.file;

import static ePortfolioMaker.StartupConstants.IMAGE;
import static ePortfolioMaker.StartupConstants.PATH_EPORTFOLIOS;
import static ePortfolioMaker.StartupConstants.PATH_SLIDE_SHOWS;
import static ePortfolioMaker.StartupConstants.SLIDESHOW;
import static ePortfolioMaker.StartupConstants.TEXT;
import static ePortfolioMaker.StartupConstants.TEXT_HEADER;
import static ePortfolioMaker.StartupConstants.TEXT_LIST;
import static ePortfolioMaker.StartupConstants.TEXT_PARAGRAPH;
import static ePortfolioMaker.StartupConstants.VIDEO;
import ePortfolioMaker.model.Component;
import ePortfolioMaker.model.PageModel;
import ePortfolioMaker.model.Slide;
import ePortfolioMaker.model.SlideShowModel;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
/*public static String JSON_TITLE ="title";
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
}*/
    
    public static String JSON_PAGE_TITLE = "title";
    public static String JSON_STUDENT_NAME = "student_name";
    public static String JSON_BANNER_IMAGE_FILE_NAME = "banner_image_file_name";
    public static String JSON_BANNER_IMAGE_FILE_PATH = "banner_image_path";
    public static String JSON_PAGE_LAYOUT = "layout";
    public static String JSON_PAGE_COLOR = "color";
    public static String JSON_COMPONENTS = "components";
    public static String JSON_EXT = ".json";
    public static String SLASH = "/";
    
    //IMAGE COMPONENTS
    public static String JSON_IMAGE_COMPONENT_TYPE = "type";
    public static String JSON_IMAGE_COMPONENT_FILE_PATH = "image_comp_file_path";
    public static String JSON_IMAGE_COMPONENT_FILE_NAME = "image_comp_file_name";
    public static String JSON_IMAGE_COMPONENT_CAPTION = "image_comp_caption";
    public static String JSON_IMAGE_COMPONENT_FLOAT = "image_comp_float";
    public static String JSON_IMAGE_COMPONENT_WIDTH = "image_comp_width";
    public static String JSON_IMAGE_COMPONENT_HEIGHT = "image_comp_height";
    
    //VIDEO COMPONENTS
    public static String JSON_VIDEO_COMPONENT_TYPE = "type";
    public static String JSON_VIDEO_COMPONENT_FILE_PATH = "video_comp_file_path";
    public static String JSON_VIDEO_COMPONENT_FILE_NAME = "video_comp_file_name";
    public static String JSON_VIDEO_COMPONENT_CAPTION = "video_comp_caption";
    public static String JSON_VIDEO_COMPONENT_FLOAT = "video_comp_float";
    public static String JSON_VIDEO_COMPONENT_WIDTH = "video_comp_width";
    public static String JSON_VIDEO_COMPONENT_HEIGHT = "video_comp_height";
    
    //SLIDESHOW COMPONENTS
    public static String JSON_SLIDESHOW_TITLE = "slideshow_title";
    public static String JSON_SLIDES = "slides";
    public static String JSON_SLIDE_IMAGE_FILE_NAME = "slide_image_file_name";
    public static String JSON_SLIDE_IMAGE_PATH = "slide_image_file_path";
    public static String JSON_SLIDE_CAPTION = "slide_caption";
    
    //TEXT COMPONENTS
    public static String JSON_TEXT_COMPONENT_TYPE = "type";
    public static String JSON_TEXT_COMPONENT_TEXT_TYPE = "text_type";
    public static String JSON_TEXT_COMPONENT_FONT = "font";
    public static String JSON_TEXT_COMPONENT_DATA = "text_comp_data";
    public static String JSON_TEXT_COMP_LIST_ELEMENTS = "list_elements";
    public static String JSON_TEXT_COMPONENT_LIST_DATA = "text_comp_list_element_data";
    public static String JSON_TEXT_COMP_HYPERLINK_DISPLAY = "hyperlink_display";
    public static String JSON_TEXT_COMP_HYPERLINK_TARGET = "hyperlink_target";


    public void savePage(PageModel pageToSave) throws IOException {
        StringWriter sw = new StringWriter();
        
        //BUILD COMPONENTS ARRAY
        JsonArray componentsArray = makeComponentsJsonArray(pageToSave.getComponents());
        
        JsonObject pageJsonObject = Json.createObjectBuilder()
		.add(JSON_PAGE_TITLE, pageToSave.getTitle())
		.add(JSON_STUDENT_NAME, pageToSave.getStudentName())
                .add(JSON_BANNER_IMAGE_FILE_NAME, pageToSave.getEPortfolio().getBannerImageFileName())
                .add(JSON_BANNER_IMAGE_FILE_PATH, pageToSave.getEPortfolio().getBannerImageFileNamePath())
                .add(JSON_PAGE_LAYOUT, pageToSave.getLayout())
                .add(JSON_PAGE_COLOR, pageToSave.getColor())
                .add(JSON_COMPONENTS, componentsArray)
		.build();
        
       Map<String, Object> properties = new HashMap<>(1);
	properties.put(JsonGenerator.PRETTY_PRINTING, true);

	JsonWriterFactory writerFactory = Json.createWriterFactory(properties);
	JsonWriter jsonWriter = writerFactory.createWriter(sw);
	jsonWriter.writeObject(pageJsonObject);
	jsonWriter.close();
        
        // INIT THE WRITER
	String pageTitle = "" + pageToSave.getTitle();
	String jsonFilePath = PATH_EPORTFOLIOS + SLASH + pageTitle + JSON_EXT;
        System.out.println("jsonFilePth" + jsonFilePath);
	OutputStream os = new FileOutputStream(jsonFilePath);
	JsonWriter jsonFileWriter = Json.createWriter(os);
	jsonFileWriter.writeObject(pageJsonObject);
	String prettyPrinted = sw.toString();
	PrintWriter pw = new PrintWriter(jsonFilePath);
	pw.write(prettyPrinted);
	pw.close();
	System.out.println(prettyPrinted);
    }
    
    private JsonArray makeComponentsJsonArray(List<Component> components) {
        JsonArrayBuilder jsb = Json.createArrayBuilder();
        for(Component component : components) {
            System.out.println("File path: " + component.getImageFilePath());
                       System.out.println("File name: " + component.getImageFileName());
            if(component.getType().equals(IMAGE)) {
                JsonObject jso = makeImageComponentObject(component);
                jsb.add(jso);
            }
            if(component.getType().equals(VIDEO)) {
                JsonObject jso = makeVideoComponentObject(component);
                jsb.add(jso);
            }
            if(component.getType().equals(SLIDESHOW)) {
                JsonObject jso = makeSlideshowComponentObject(component);
                jsb.add(jso);
            }
            if(component.getType().equals(TEXT)) {
                if(component.getTextType().equals(TEXT_PARAGRAPH)) {
                    JsonObject jso = makeTextParagraphComponentObject(component);
                    jsb.add(jso);
                }
                if(component.getTextType().equals(TEXT_HEADER)) {
                    JsonObject jso = makeTextHeaderComponentObject(component);
                    jsb.add(jso);
                }
                if(component.getTextType().equals(TEXT_LIST)) {
                    JsonObject jso = makeTextListComponentObject(component);
                    jsb.add(jso);
                }
            }
                
        }
        JsonArray jA = jsb.build();
        return jA;
    }
    
    private JsonObject makeTextParagraphComponentObject(Component component) {
        JsonObject jso = Json.createObjectBuilder()
                .add(JSON_TEXT_COMPONENT_TYPE, component.getType())
                .add(JSON_TEXT_COMPONENT_TEXT_TYPE, component.getTextType())
                .add(JSON_TEXT_COMPONENT_FONT, component.getFont())
                .add(JSON_TEXT_COMPONENT_DATA, component.getTextComponentData())
                .build();
        return jso;
    }
    
    private JsonObject makeTextHeaderComponentObject(Component component) {
       JsonObject jso = Json.createObjectBuilder()
               .add(JSON_TEXT_COMPONENT_TYPE,  component.getType())
               .add(JSON_TEXT_COMPONENT_TEXT_TYPE, component.getTextType())
               .add(JSON_TEXT_COMPONENT_FONT, component.getFont())
               .add(JSON_TEXT_COMPONENT_DATA, component.getTextComponentData())
               .build();
        return jso;
    }
    
    private JsonObject makeTextListComponentObject(Component component) {
        JsonArray listElementsArray = makeListElementsArray(component.getTextArray());
        
        JsonObject jso = Json.createObjectBuilder()
                .add(JSON_TEXT_COMPONENT_TYPE, component.getType())
                .add(JSON_TEXT_COMPONENT_TEXT_TYPE, component.getTextType())
                .add(JSON_TEXT_COMP_LIST_ELEMENTS, listElementsArray).build();
        
        return jso;
    }
    
    private JsonArray makeListElementsArray(List<String> elements) {
        JsonArrayBuilder jsb = Json.createArrayBuilder();
        for(String element : elements) {
            JsonObject jso = Json.createObjectBuilder().add(JSON_TEXT_COMPONENT_LIST_DATA, element).build();
            jsb.add(jso);
        }
        JsonArray jA = jsb.build();
        return jA;
    }
    
    private JsonObject makeImageComponentObject(Component component) {
                       System.out.println("File path: " + component.getImageFilePath());
                       System.out.println("File name: " + component.getImageFileName());


        JsonObject jso = Json.createObjectBuilder()
                .add(JSON_IMAGE_COMPONENT_TYPE, component.getType())
                .add(JSON_IMAGE_COMPONENT_FILE_PATH, component.getImageFilePath())
                .add(JSON_IMAGE_COMPONENT_FILE_NAME, component.getImageFileName())
                .add(JSON_IMAGE_COMPONENT_CAPTION, component.getImageCaption())
                .add(JSON_IMAGE_COMPONENT_FLOAT, component.getImagePos())
                .add(JSON_IMAGE_COMPONENT_WIDTH, component.getImageWidth())
                .add(JSON_IMAGE_COMPONENT_HEIGHT, component.getImageHeight()).build();
        return jso;
    }
    
    private JsonObject makeVideoComponentObject(Component component) {
        JsonObject jso = Json.createObjectBuilder()
                .add(JSON_VIDEO_COMPONENT_TYPE, component.getType())
                .add(JSON_VIDEO_COMPONENT_FILE_PATH, component.getVideoFilePath())
                .add(JSON_VIDEO_COMPONENT_FILE_NAME, component.getVideoFileName())
                .add(JSON_VIDEO_COMPONENT_CAPTION, component.getVideoCaption())
                .add(JSON_VIDEO_COMPONENT_FLOAT, component.getVideoPosition())
                .add(JSON_VIDEO_COMPONENT_WIDTH, component.getVideoWidth())
                .add(JSON_VIDEO_COMPONENT_HEIGHT, component.getVideoHeight()).build();
        return jso;
    }
    
    private JsonObject makeSlideshowComponentObject(Component component) {
        SlideShowModel slideshow = component.getSlideShowComponent();
        
        JsonArray slidesJsonArray = makeSlidesJsonArray(slideshow.getSlides());
      
        JsonObject slideShowJsonObject = Json.createObjectBuilder()
		.add(JSON_SLIDESHOW_TITLE, slideshow.getTitle())
		.add(JSON_SLIDES, slidesJsonArray)
		.build();
        
        return slideShowJsonObject;
    }
    
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
		.add(JSON_SLIDE_IMAGE_FILE_NAME, slide.getImageFileName())
		.add(JSON_SLIDE_IMAGE_PATH, slide.getImagePath())
		.add(JSON_SLIDE_CAPTION, slide.getCaption())
		.build();
	return jso;
    }
  /*  private JsonObject makeVideoComponentObject(Component component) {
        
    }*/
       
}
