<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 01.03.2017
  Time: 2:21
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
    <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png"/>
    <link href="css/master.css" rel="stylesheet">
</head>
<body>
<div class="b-items__cars">
    <c:forEach var="car" items="${requestScope.list}">
        <div class="b-items__cars-one wow zoomInUp" data-wow-delay="0.5s">
            <div class="b-items__cars-one-img">
                <img src="${car.image}" class="img-responsive"/>
            </div>
            <div class="b-items__cars-one-info">
                <form class="b-items__cars-one-info-header s-lineDownLeft">
                    <h2>${car.mark} ${car.model} ${car.characteristics.engineCapacity}L</h2>
                </form>
                <div class="row s-noRightMargin">
                    <div class="col-md-9 col-xs-12">
                        <p>${car.description}</p>
                        <div class="m-width row m-smallPadding">
                            <div class="col-xs-6">
                                <div class="row m-smallPadding">
                                    <div class="col-xs-6">
                                        <span class="b-items__cars-one-info-title">Year:</span>
                                        <span class="b-items__cars-one-info-title">Mileage:</span>
                                        <span class="b-items__cars-one-info-title">Transmission:</span>
                                    </div>
                                    <div class="col-xs-6">
                                        <span class="b-items__cars-one-info-value">${car.year.getYear()}</span>
                                        <span class="b-items__cars-one-info-value">${car.conditions.milleage} KM</span>
                                        <span class="b-items__cars-one-info-value">${car.transmission}</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xs-6">
                                <div class="row m-smallPadding">
                                    <div class="col-xs-4">
                                        <span class="b-items__cars-one-info-title">Fuel Type:</span>
                                        <span class="b-items__cars-one-info-title">Color:</span>
                                        <span class="b-items__cars-one-info-title">Doors:</span>
                                    </div>
                                    <div class="col-xs-8">
                                        <span class="b-items__cars-one-info-value">${car.characteristics.fuelType}</span>
                                        <span class="b-items__cars-one-info-value">${car.additions.carColor}</span>
                                        <span class="b-items__cars-one-info-value">${car.characteristics.doorsNumber}-Door</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-xs-12">
                        <div class="b-items__cars-one-info-price">
                            <div class="pull-right">
                                <h3>Price:</h3>
                                <h4>$${car.price}</h4>
                            </div>
                            <a href="/autobazar/controller?command=Detail&id=${car.id}" class="btn m-btn">VIEW DETAILS<span
                                    class="fa fa-angle-right"></span></a>
                        </div>
                    </div>
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



        function onClickPage(_this) {
            var value = _this.innerHTML;
            $.ajax({
                method: "POST",
                url: "/autobazar/controller",
                data: {'pageNumber': value, 'pageType': "items", "command": "PageDetails"},
                success: function (result) {
                    $(".b-items-cars").html(result);
                }
            });
        }
    </script>
</body>
</html>
