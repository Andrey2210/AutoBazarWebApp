/**
 * Created by Andrey on 09.04.2017.
 */
$(function($){
    $("#phone").mask("+375(99)999-99-99");
});
document.getElementById("login").addEventListener("change", function () {
    resetError(this.parentNode);
    if (!this.value) {
        showError(this.parentNode, ' Enter login.');
    }
});

document.getElementById("email").addEventListener("change", function () {
    resetError(this.parentNode);
    if (!this.value) {
        showError(this.parentNode, ' Enter email.');
    }
});

document.getElementById("password").addEventListener("change", function () {
    resetError(this.parentNode);
    if (!this.value) {
        showError(this.parentNode, ' Enter password.');
    }
});

document.getElementById("confirm-password").addEventListener("change", function () {
    resetError(this.parentNode);
    if (!this.value) {
        showError(this.parentNode, 'Passwords must match');
    } else if (this.value != document.getElementById("password").value) {
        showError(this.parentNode, 'Passwords must match');
    }
});

function showError(container, errorMessage) {
    container.classList.add("error");
    var msgElem = document.createElement('span');
    msgElem.classList.add("error-message");
    msgElem.innerHTML = errorMessage;
    container.insertBefore(msgElem, container.firstChild);
}

function resetError(container) {

    if (container.classList.contains("error")) {
        container.removeChild(container.firstChild);
        container.classList.remove('error');
    }
}

function validate(form) {
    var elems = form.elements;

    resetError(elems.login.parentNode);
    if (!elems.login.value) {
        showError(elems.login.parentNode, ' Enter login.');
        return false;
    }

    resetError(elems.email.parentNode);
    if (!elems.email.value) {
        showError(elems.email.parentNode, ' Enter email.');
        return false;
    }

    resetError(elems.password.parentNode);
    if (!elems.password.value) {
        showError(elems.password.parentNode, ' Enter password.');
        return false;
    } else if (elems.password.value != elems.confirmPassword.value) {
        showError(elems.password.parentNode, ' Passwords must match.');
        return false;
    }
    form.submit();
}