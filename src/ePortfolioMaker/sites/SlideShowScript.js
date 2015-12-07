//if (!document.getElementById) document.write('<link rel="stylesheet" type="text/css" href="slideshow_style.css">');
var slideShowArray = [];
var title;
$.getJSON("Test.json", function(response) {
    JSON.stringify(response);
    var array = response.slides;
    title=response.title;
    for(var i=0; i<array.length; i++)
    {
        slideShowArray.push({image_file_name_path: array[i].image_path + array[i].image_file_name,
                             caption: array[i].caption});
    }
    var length = slideShowArray.length-1;
    var time;
    var index = 0;
    var fadeIn;
    var fadeOut;
    
    document.getElementById("title").innerHTML = title;
    document.getElementById("slideShow").src=slideShowArray[0].image_file_name_path;
    document.getElementById("caption").innerHTML = slideShowArray[0].caption;
    $("#pause_button").addClass("disabled");

    document.getElementById("play_button").addEventListener("click", function runSlideShow() {
        if(index===length)
           index=0;
       else
           index++;    
       document.getElementById("slideShow").src = slideShowArray[index].image_file_name_path; 
       document.getElementById("caption").innerHTML = slideShowArray[index].caption;
       time = setTimeout(runSlideShow, 3000);
       $("#play_button").addClass("disabled");
       $("#pause_button").removeClass("disabled");
    });
   
    document.getElementById("next").addEventListener("click", function(){
        if(index===length)
            index=0;
        else
            index++;   
        document.getElementById("slideShow").src = slideShowArray[index].image_file_name_path; 
        document.getElementById("caption").innerHTML = slideShowArray[index].caption;
    });
    
    document.getElementById("previous").addEventListener("click", function(){
        if(index===0)
            index=length;
        else
            index--;
        document.getElementById("slideShow").src = slideShowArray[index].image_file_name_path;
        document.getElementById("caption").innerHTML = slideShowArray[index].caption;
    });
    
    document.getElementById("pause_button").addEventListener("click", function(){
        clearTimeout(time);
        $("#pause_button").addClass("disabled");
        $("#play_button").removeClass("disabled");
    });
});






