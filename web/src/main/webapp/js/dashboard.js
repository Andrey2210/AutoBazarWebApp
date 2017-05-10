
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

