
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var CSS_LAYOUT_PATH;
var CSS_STYLE_PATH;

var siteMapFile;
var pageDataFile;

var student_name;//student name from site_map.json
var ePortfolio_name;//title of portfolio from site_map.json
var banner_img;//banner image from site_map.json
var pages;//array of ePortfolio pages, from site_map.json
var page;//represent a single page, from site_map.json
var css_layout;//css layout, site_map.json
var css_style;//css style, site_map.json

var page_title;//page title
var page_components;//array of components on webpage

function initStyle()
{
    CSS_LAYOUT_PATH = "./css/layout/";
    CSS_STYLE_PATH = "./css/style/";
    siteMapFile = "./json files/site_map.json";
    pageName = "index";
    pageDataFile = ".json files/" + pageName + ".json";
    loadSiteData(siteMapFile);
    //pages = new Array();
    //loadPageData(pageDataFile);
}

function Page(initPageTitle, initPageStyle, initPageLayout)
{
    this.title = initPageTitle;
    this.style = initPageStyle;
    this.layout = initPageLayout;
}

function loadSiteData(siteMapFile)
{
    $.getJSON(siteMapFile, function(json) {
      loadSite(json);  
    });
}

function loadSite(siteDataFile)
{
    ePortfolio_name = siteDataFile.eportfolio_title;
    student_name = siteDataFile.student_name;
    banner_img = siteDataFile.banner_image;
    pages = new Array();
    //var pageFile = pageName + ".html";
    
    for(var i = 0; i <siteDataFile.pages.length; i++)
    {
        var rawPage = siteDataFile.pages[i];
        var newPage = new Page(rawPage.title, rawPage.style, rawPage.layout);
        pages[i] = newPage;
        
        if(pageName === newPage.title)
        {
            page = newPage;
        }
    }

    css_style = CSS_STYLE_PATH + page.style;
    css_layout = CSS_LAYOUT_PATH + page.layout;
    
    setPageCSS(css_style, css_layout);
}

function setPageCSS(style, layout)
{
    var styleText = '<link rel ="stylesheet" href="' + style + '">'; 
    var layoutText = '<link rel ="stylesheet" href="' + layout + '">'; 
    $('head').append(styleText);
    $('head').append(layoutText);
}

function loadPageData(dataFile)
{
    $.getJSON(dataFile, function(json) {
       loadPageComponents(json);
       initPage();
    });
}

function loadPageComponents(pageData)
{
    page_title = pageData.page_title;
    css_layout = pageData.css_layout;
    css_style = pageData.css_style;
    for(var i = 0; i < pageData.components.length; i++)
    {
        
    }
    
}

function initPage()
{
    
}
