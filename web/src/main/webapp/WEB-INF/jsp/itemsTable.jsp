<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 02.03.2017
  Time: 2:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="shortcut icon" type="image/x-icon" href="../../images/favicon.png"/>
    <link href="../../css/master.css" rel="stylesheet">
</head>
<body>
<div class="row m-border">
    <c:forEach var="car" items="${requestScope.list}">
        <div class="col-lg-4 col-md-6 col-xs-12 wow zoomInUp" data-wow-delay="0.5s">
            <div class="b-items__cell">
                <div class="b-items__cars-one-img">
                    <img class='img-responsive' src="../../${car.image}"/>
                </div>
                <div class="b-items__cell-info">
                    <div class="s-lineDownLeft b-items__cell-info-title">
                        <h2 class=""><a href="detail.html">${car.mark} ${car.model}</a></h2>
                    </div>
                    <p>${car.description}</p>
                    <div>
                        <div class="row m-smallPadding">
                            <div class="col-xs-5">
                                <span class="b-items__cars-one-info-title">Body Style:</span>
                                <span class="b-items__cars-one-info-title">Mileage:</span>
                                <span class="b-items__cars-one-info-title">Transmission:</span>
                                <span class="b-items__cars-one-info-title">Specs:</span>
                            </div>
                            <div class="col-xs-7">
                                <span class="b-items__cars-one-info-value">Sedan</span>
                                <span class="b-items__cars-one-info-value">35,000 KM</span>
                                <span class="b-items__cars-one-info-value">6-Speed Auto</span>
                                <span class="b-items__cars-one-info-value">2-Passenger, 2-Door</span>
                            </div>
                        </div>
                    </div>
                    <h5 class="b-items__cell-info-price"><span>Price:</span>$${car.price}</h5>
                </div>
            </div>
        </div>
    </c:forEach>

</div>
<div class="b-items__pagination wow zoomInUp" data-wow-delay="0.5s">
    <div class="b-items__pagination-main">
        <c:choose>
            <c:when test="${sessionScope.pageDetails.pageNumber > 1}">
                <a href="#${sessionScope.pageDetails.pageNumber - 1}"
                   class="m-left" onclick="onClickPage(this)"><span class="fa fa-angle-left"></span></a>
            </c:when>
            <c:otherwise>
                <a href="#" class="m-left" onclick="onClickPage(this)"><span class="fa fa-angle-left"></span></a>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${sessionScope.pageDetails.pageNumber < sessionScope.pageDetails.amountOfPage}">
                <a href="#${sessionScope.pageDetails.pageNumber + 1}"
                   class="m-right" onclick="onClickPage(this)"><span class="fa fa-angle-right"></span></a>
            </c:when>
            <c:otherwise>
                <a href="#" class="m-left" onclick="onClickPage(this)"><span class="fa fa-angle-left"></span></a>
            </c:otherwise>
        </c:choose>

    </div>
</div>
<script type="text/javascript">
    function showPagination() {
        var paginat = document.getElementsByClassName("b-items__pagination-main")[0];
        if (${sessionScope.pageDetails.amountOfPage <= 9}) {
            for (var i = 1; i <=${sessionScope.pageDetails.amountOfPage}; i++) {
                var span = document.createElement("span");
                var a = document.createElement("a");
                a.setAttribute("href", "#" + i);
                a.setAttribute("onclick", "onClickPage(this)");
                a.innerHTML = i;
                span.appendChild(a);
                if (Number(${sessionScope.pageDetails.pageNumber}) == i) {
                    span.setAttribute("class", "m-active");
                }
                paginat.insertBefore(span, paginat.children[i]);
            }
        } else {
            var pageNumber = Number(${sessionScope.pageDetails.pageNumber});
            var amountOfPage = Number(${sessionScope.pageDetails.amountOfPage});
            if (pageNumber <= 4) {
                var numb = 1;
                var i = 1;
                while (i <= amountOfPage) {
                    if (i == 8) {
                        var span = document.createElement("span");
                        span.innerHTML = "...";
                        paginat.insertBefore(span, paginat.children[i]);
                        i = amountOfPage;
                        numb++;
                    }
                    var span = document.createElement("span");
                    var a = document.createElement("a");
                    a.setAttribute("href", "#" + i);
                    a.setAttribute("onclick", "onClickPage(this)");
                    a.innerHTML = i;
                    span.appendChild(a);
                    if (Number(${sessionScope.pageDetails.pageNumber}) == i) {
                        span.setAttribute("class", "m-active");
                    }
                    paginat.insertBefore(span, paginat.children[numb]);

                    i++;
                    numb++;
                }
            } else if (amountOfPage - 4 <= pageNumber) {
                var numb = 1;
                var i = 1;
                while (i <= amountOfPage) {
                    if (i == 2) {
                        var span = document.createElement("span");
                        span.innerHTML = "...";
                        paginat.insertBefore(span, paginat.children[i]);
                        i = pageNumber - 2;
                        numb++;
                    }
                    var span = document.createElement("span");
                    var a = document.createElement("a");
                    a.setAttribute("href", "#" + i);
                    a.setAttribute("onclick", "onClickPage(this)");
                    a.innerHTML = i;
                    span.appendChild(a);
                    if (Number(${sessionScope.pageDetails.pageNumber}) == i) {
                        span.setAttribute("class", "m-active");
                    }
                    paginat.insertBefore(span, paginat.children[numb]);

                    i++;
                    numb++;
                }
            } else {
                var numb = 1;
                var i = 1;
                while (i <= amountOfPage) {
                    if (i == 2) {
                        var span = document.createElement("span");
                        span.innerHTML = "...";
                        paginat.insertBefore(span, paginat.children[i]);
                        i = pageNumber - 2;
                        numb++;
                    }
                    if (i == 8) {
                        var span = document.createElement("span");
                        span.innerHTML = "...";
                        paginat.insertBefore(span, paginat.children[i]);
                        i = amountOfPage;
                        numb++;
                    }
                    var span = document.createElement("span");
                    var a = document.createElement("a");
                    a.setAttribute("href", "#" + i);
                    a.setAttribute("onclick", "onClickPage(this)");
                    a.innerHTML = i;
                    span.appendChild(a);
                    if (Number(${sessionScope.pageDetails.pageNumber}) == i) {
                        span.setAttribute("class", "m-active");
                    }
                    paginat.insertBefore(span, paginat.children[numb]);

                    i++;
                    numb++;
                }
            }
        }
    }
    showPagination();

    function onChangeSort(_this) {
        var value = _this.value;
        if (_this.name == "itemsOnPage") {
            $.ajax({
                method: "POST",
                url: "/autobazar",
                data: {'page': value},
                success: function (result) {
                    $(".m-border").html(result);
                }
            });
        } else {
            $.ajax({
                method: "POST",
                url: "/autobazar",
                data: {'sort': value},
                success: function (result) {
                    $(".m-border").html(result);
                }
            });
        }
    }

    function onClickPage(_this) {
        var value = _this.innerHTML;
        $.ajax({
            method: "POST",
            url: "/autobazar",
            data: {'pageNumber': value},
            success: function (result) {
                $(".m-border").html(result);
            }
        });
    }
</script>
</body>
</html>
