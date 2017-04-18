<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 28.03.2017
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false"%><html>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="translater"/>
<body>
<div class="b-items__cars">
    <c:forEach var="car" items="${requestScope.list}">
        <div class="b-items__cars-one wow zoomInUp" data-wow-delay="0.5s">
            <div class="b-items__cars-one-img">
                <img src="${car.imageList.get(0).imagePath}" class="img-responsive"/>
            </div>
            <div class="b-items__cars-one-info">
                <form class="b-items__cars-one-info-header s-lineDownLeft">
                    <h2>${car.mark} ${car.model} ${car.engineCapacity}L</h2>
                    <a class="btn btn-success" href="/autobazar/controller?command=Edit&id=${car.id}">
                        <i class="fa fa-pencil-square-o" aria-hidden="true"> Edit</i></a>
                    <a class="btn btn-danger" href="/autobazar/controller?command=DeleteCar&id=${car.id}&type=profile" aria-label="Delete">
                        <i class="fa fa-times" aria-hidden="true"></i>
                    </a> <br/>
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
                                        <span class="b-items__cars-one-info-value">${car.milleage} KM</span>
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
                                        <span class="b-items__cars-one-info-value">${car.fuelType}</span>
                                        <span class="b-items__cars-one-info-value">${car.carColor}</span>
                                        <span class="b-items__cars-one-info-value">${car.doorsNumber}-Doors</span>
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
</body>
</html>
