function checkVerified(element) {
    if (element.checked) {
        addCarToList($(element).data("id"));
    } else {
        removeCarFromList($(element).data("id"));
    }
};

function addCarToList(id) {
    $.ajax({
        method: "GET",
        url: "/autobazar/admin/checkCar/" + id,
        success: function (result) {
        }
    });
}
function removeCarFromList(id) {
    $.ajax({
        method: "GET",
        url: "/autobazar/admin/uncheckCar/" + id,
        success: function (result) {
        }
    });
}

function changeTable(_this) {
    var value = _this.value;
    if (_this.name == "users") {
        $.ajax({
            method: "GET",
            url: "/autobazar/dashboard/users",
            success: function (result) {
                $(".b-submit__main").html(result);
            }
        });
    } else {
        $.ajax({
            method: "GET",
            url: "/autobazar/dashboard/cars",
            success: function (result) {
                $(".b-submit__main").html(result);
            }
        });
    }
}

