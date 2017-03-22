/**
 * Created by Andrey on 23.02.2017.
 */
function onChange(_this){
    var url = "/autobazar/controller?command=Model&make="+_this.value;
    load("GET",url);
}

function onChangeMakes(_this){
    var url = "/autobazar/controller?command=Model&allMake="+_this.value;
    load("GET",url);
}

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
    var _select = document.getElementById("model");
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

function userLogin() {
    document.getElementById('login-form').submit();
    return false;
}

function userLogout() {
    document.getElementById('logout-form').submit();
    return false;
}

function nextStep(_this) {
    _this.style.display = 'none';
    var nextItem = _this.parentNode.nextElementSibling;
    nextItem.style.display = 'block';
    document.getElementById('menu-' + nextItem.id).classList.add("m-active");

    document.getElementById('menu-' + nextItem.id).getElementsByTagName('div')[0].classList.add("m-active");
}
