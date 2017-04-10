/**
 * Created by Andrey on 10.04.2017.
 */
function changeTable(_this) {
    var value = _this.value;
    if (_this.name == "users") {
        $.ajax({
            method: "POST",
            url: "/autobazar/controller",
            data: {"command": "UsersDashboard"},
            success: function (result) {
                $(".b-submit__main").html(result);
            }
        });
    } else {
        $.ajax({
            method: "POST",
            url: "/autobazar/controller",
            data: {"command": "CarsDashboard"},
            success: function (result) {
                $(".b-submit__main").html(result);
            }
        });
    }
}

