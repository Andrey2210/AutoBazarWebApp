/**
 * Created by Andrey on 23.02.2017.
 */
function onChange(_this){
    var url = "/models?make="+_this.value;
    load("GET",url);
}

// Функция, осуществляющая AJAX запрос.
function load(method,url){
    var xmlHttp = null;
    if (window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
    }
    else if (window.ActiveXObject) {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlHttp.onreadystatechange = function () {
        if(xmlHttp.readyState == 4){
            if(xmlHttp.status == 200){
                getModels(xmlHttp.responseXML.documentElement);
            }else{
                location.reload();
            }
        }
    };
    xmlHttp.open(method, url, true);
    xmlHttp.send(null);
}


function getModels(xml){
    var models = xml.getElementsByTagName("model");
    var _select = document.getElementById("models");
    _select.innerHTML = "";
    var option = document.createElement("option");
    var optionText = document.createTextNode("Model");
    option.appendChild(optionText);
    option.setAttribute("value", "");
    _select.appendChild(option);
    for(var i = 0; i < models.length; i++){
        option = document.createElement("option");
        optionText = document.createTextNode(models[i].firstChild.data);
        option.appendChild(optionText);
        option.setAttribute("value",models[i].firstChild.data);
        _select.appendChild(option);
    }
}