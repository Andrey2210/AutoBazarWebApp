<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page isELIgnored="false" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="translater"/>

<div class="col-lg-9 col-sm-8 col-xs-12 b-items-cars">
    <div class="b-items__cars">
        <div ng-repeat="car in cars" class="b-items__cars-one wow zoomInUp" data-wow-delay="0.5s">
            <div class="b-items__cars-one-img">
                <img ng-src="${pageContext.request.contextPath}/{{car.imageList[0].imagePath}}" class="img-responsive"/>
            </div>
            <div class="b-items__cars-one-info">
                <form class="b-items__cars-one-info-header s-lineDownLeft">
                    <h2>{{car.mark}} {{car.model}} {{car.engineCapacity}}L</h2>
                </form>
                <div class="row s-noRightMargin">
                    <div class="col-md-9 col-xs-12">
                        <p>{{car.description}}</p>
                        <div class="m-width row m-smallPadding">
                            <div class="col-xs-6">
                                <div class="row m-smallPadding">
                                    <div class="col-xs-6">
                                        <span class="b-items__cars-one-info-title">Year:</span>
                                        <span class="b-items__cars-one-info-title">Mileage:</span>
                                        <span class="b-items__cars-one-info-title">Transmission:</span>
                                    </div>
                                    <div class="col-xs-6">
                                        <span class="b-items__cars-one-info-value">{{car.year.getYear()}}</span>
                                        <span class="b-items__cars-one-info-value">{{car.milleage}} KM</span>
                                        <span class="b-items__cars-one-info-value">{{car.transmission}}</span>
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
                                        <span class="b-items__cars-one-info-value">{{car.fuelType}}</span>
                                        <span class="b-items__cars-one-info-value">{{car.carColor}}</span>
                                        <span class="b-items__cars-one-info-value">{{car.doorsNumber}}-Doors</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-xs-12">
                        <div class="b-items__cars-one-info-price">
                            <div class="pull-right">
                                <h3>Price:</h3>
                                <h4>$ {{car.price}}</h4>
                            </div>
                            <a href="${pageContext.request.contextPath}/cars/{{car.id}}" class="btn m-btn">VIEW
                                DETAILS<span
                                        class="fa fa-angle-right"></span></a>
                        </div>
                    </div>
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
