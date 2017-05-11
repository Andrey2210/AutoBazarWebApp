
function onChange(_this){
    var url = "/autobazar/cars/search/"+_this.value;
    load("GET",url);
}

function onChangeMakes(_this){
    var url = "/autobazar/cars/submit/"+_this.value;
    load("GET",url);
}

function load(method,url){
    $.ajax({
        url: url,
        headers: "accept: application/json",
        method: method,
        success: function (result) {
            getModels(result);
        }
    });

}


function getModels(modelsNames){
    var _select = document.getElementById("model");
    _select.innerHTML = "";
    var option = document.createElement("option");
    var optionText = document.createTextNode("Model");
    option.appendChild(optionText);
    option.setAttribute("value", "");
    _select.appendChild(option);
    for(var i = 0; i < modelsNames.length; i++){
        option = document.createElement("option");
        optionText = document.createTextNode(modelsNames[i]);
        option.appendChild(optionText);
        option.setAttribute("value", modelsNames[i]);
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
