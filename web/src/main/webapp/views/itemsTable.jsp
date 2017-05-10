<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="translater"/>
<div class="col-lg-9 col-sm-8 col-xs-12">
    <div class="row m-border m-listTableTwo">
            <div ng-repeat="car in cars" class="col-lg-4 col-md-6 col-xs-12 wow zoomInUp" data-wow-delay="0.5s">
                <div class="b-items__cell">
                    <div class="b-items__cars-one-img">
                        <img class='img-responsive'  ng-src="{{car.imageList[0].imagePath}}"/>
                    </div>
                    <div class="b-items__cell-info">
                        <div class="s-lineDownLeft b-items__cell-info-title">
                            <h2 class=""><a
                                    href="/autobazar/controller?command=Detailid={{car.id}}">{{car.mark}} {{car.model}}</a>
                            </h2>
                        </div>
                        <p>{{car.description}</p>
                        <div>
                            <div class="row m-smallPadding">
                                <div class="col-xs-5">
                                    <span class="b-items__cars-one-info-title">Body Style:</span>
                                    <span class="b-items__cars-one-info-title">Mileage:</span>
                                    <span class="b-items__cars-one-info-title">Transmission:</span>
                                    <span class="b-items__cars-one-info-title">Specs:</span>
                                </div>
                                <div class="col-xs-7">
                                    <span class="b-items__cars-one-info-value">{{car.bodyType}}</span>
                                    <span class="b-items__cars-one-info-value">{{car.milleage}} KM</span>
                                    <span class="b-items__cars-one-info-value">{{car.transmission}}</span>
                                    <span class="b-items__cars-one-info-value">{{car.fuelType}}, {{car.doorsNumber}}-Doors</span>
                                </div>
                            </div>
                        </div>
                        <h5 class="b-items__cell-info-price"><span>Price:</span>$ {{car.price}}</h5>
                    </div>
                </div>
            </div>
    </div>
    <div class="b-items__pagination wow zoomInUp" data-wow-delay="0.5s">
        <div class="b-items__pagination-main">
            <c:choose>
                <c:when test="${sessionScope.pageDetails.pageNumber > 1}">
                    <a href="#${sessionScope.pageDetails.pageNumber - 1}"
                       class="m-left" ng-click="loadPage(${sessionScope.pageDetails.pageNumber - 1})"><span class="fa fa-angle-left"></span></a>
                </c:when>
                <c:otherwise>
                    <a href="#" class="m-left" ><span class="fa fa-angle-left"></span></a>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${sessionScope.pageDetails.pageNumber < sessionScope.pageDetails.amountOfPage}">
                    <a href="#${sessionScope.pageDetails.pageNumber + 1}"
                       class="m-right" ng-click="loadPage(${sessionScope.pageDetails.pageNumber + 1})"><span class="fa fa-angle-right"></span></a>
                </c:when>
                <c:otherwise>
                    <a href="#" class="m-left" ><span class="fa fa-angle-left"></span></a>
                </c:otherwise>
            </c:choose>

        </div>
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
                a.setAttribute("ng-click", "loadPage(" + i + ")");
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
                    a.setAttribute("ng-click", "loadPage(" + i + ")");
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
                    a.setAttribute("ng-click", "loadPage(" + i + ")");
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
                    a.setAttribute("ng-click", "loadPage(" + i + ")");
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

</script>
