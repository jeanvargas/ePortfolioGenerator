var contentTypes;//array of different elements, types of components
var textTypes;//array of different types of text elements - header, paragraph, list
var components;//array of the different components on a web page
var pages;//array of the page names, used to set up the menu

var title;//page name/title
var div;
var tag;
var content;

var siteMapFile;
var pageDataFile;

var eportfolio_title;
var student_name;
var banner_image;

//initMenu();

function initMenu()
{
    siteMapFile = "./json files/site_map.json";
    pageDataFile = "./json files/index.json";
    loadMenuData(siteMapFile);
}

function loadMenuData(siteMapFile)
{
     $.getJSON(siteMapFile, function(json) {
      getPageInfo(json);  
    });
}

function getPageInfo(siteDataFile)
{
    eportfolio_title = siteDataFile.eportfolio_title;
    student_name = siteDataFile.student_name;
    banner_image = siteDataFile.banner_image;
    pages = new Array();
    
    for(var i = 0; i < siteDataFile.pages.length; i++)
    {
        //var t = siteDataFile.pages[i].title;
        //pages[i] = t;
        pages[i] = siteDataFile.pages[i].title;
    }
    
    setUpMenu(pages);
}
    
function setUpMenu(pageArray)
{
    if(pages.length <= 2)
    {
        var append;
        if(pageArray.length === 1) 
            append = '<ul><li><a href="index.html">Home</a></li></ul>';
        else
            append = '<ul><li><a href="index.html">Home</a></li><li><a href="' + pageArray[1] + '.html">' + pageArray[1] + "</a></li></ul>";
        
        $('.menu').append(append);
    }else
    {
        var append;
        append = '<ul><li><a href="index.html">Home</a></li><li>Portfolio<ul>';
       // $('.menu').append(append);
        for(var i = 1; i < pageArray.length; i++)
        {
            append += '<li><a href="' + pageArray[i] + '.html">' + pageArray[i] + '</a></li>';
            //$('.menu').append(append);
        }
        $('.menu').append(append);
        $('.menu').append('</ul></li></ul>');
    }
}
