<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 28.03.2017
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="translater"/>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>AUTO BAZAR</title>

    <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png"/>
    <link href="css/master.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="//oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="//oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body class="m-submit1" data-scrolling-animations="true">

<jsp:include page="header.jsp"></jsp:include>


<section class="b-pageHeader">
    <div class="container">
        <h1 class="wow zoomInLeft" data-wow-delay="0.5s">Edit Your Vehicle</h1>
    </div>
</section><!--b-pageHeader-->


<div id="b-submit" class="b-submit">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-4 col-sm-5 col-xs-6">

            </div>


            <div class="col-lg-9 col-md-8 col-sm-7 col-xs-6">
                <div class="b-submit__main">
                    <header class="s-headerSubmit s-lineDownLeft wow zoomInUp" data-wow-delay="0.5s">
                        <h2 class="">Add Your Vehicle Details</h2>
                    </header>
                    <form class="s-submit clearfix" action="/autobazar/controller" name="submit1" method="POST">
                        <div id="step1" class="row">
                            <p style="color: red">${errorMessage}</p>
                            <div class="col-md-6 col-xs-12">
                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.5s">
                                    <label>Enter Make <span id="markError">*</span></label>
                                    <div class='s-relative'>
                                        <select class="m-select" name="mark" disabled>
                                            <option value="${requestScope.car.mark}"
                                                    selected="selected">${requestScope.car.mark}</option>
                                        </select>
                                        <span class="fa fa-caret-down"></span>
                                    </div>
                                </div>

                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.5s">
                                    <label>Select Body Type <span id="bodyTypeError">*</span></label>
                                    <div class='s-relative'>
                                        <select class="m-select" id="bodyType" name="bodyType">
                                            <option value="${requestScope.car.bodyType}"
                                                    selected="selected">${requestScope.car.bodyType}</option>
                                            <option>PICKUP</option>
                                            <option>SUV</option>
                                            <option>COUPE</option>
                                            <option>CONVERTIBLE</option>
                                            <option>SEDAN</option>
                                            <option>HATCHBACK</option>
                                        </select>
                                        <span class="fa fa-caret-down"></span>
                                    </div>
                                </div>

                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.5s">
                                    <label>Select Fuel Type <span id="fuelTypeError">*</span></label>
                                    <div class='s-relative'>
                                        <select class="m-select" id="fuelType" name="fuelType">
                                            <option value="${requestScope.car.fuelType}"
                                                    selected="selected">${requestScope.car.fuelType}</option>
                                            <option>PETROL</option>
                                            <option>DIESEL</option>
                                            <option>ELECTRO</option>
                                        </select>
                                        <span class="fa fa-caret-down"></span>
                                    </div>
                                </div>


                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.5s">
                                    <label>No. of Doors <span id="doorsNumberError">*</span></label>
                                    <input placeholder="Enter No. of Doors" value="${requestScope.car.doorsNumber}"
                                           id="doorsNumber" type="text" name="doorsNumber"/>
                                </div>

                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.5s">
                                    <label>Vehicle Manufacturer Year<span id="yearError">*</span></label>
                                    <div class="b-submit__main-element">
                                        <input id="year" type="text" name="year" value="${requestScope.car.year.getYear()}"/>
                                    </div>
                                </div>
                            </div>

                            <div class="col-md-6 col-xs-12">
                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.5s">
                                    <label>Enter Vehicle Model <span id="modelError">*</span></label>
                                    <div class='s-relative'>
                                        <select id="model" class="m-select" name="model">
                                            <option value="${requestScope.car.model}"
                                                    selected="selected">${requestScope.car.model}</option>
                                        </select>
                                        <span class="fa fa-caret-down"></span>
                                    </div>
                                </div>

                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.5s">
                                    <label>Select Drive Type <span id="drivingError">*</span></label>
                                    <div class='s-relative'>
                                        <select id="driving" class="m-select" name="driving">
                                            <option value="${requestScope.car.driving}"
                                                    selected="selected">${requestScope.car.driving}</option>
                                            <option>AWD</option>
                                            <option>FWD</option>
                                            <option>RWD</option>
                                        </select>
                                        <span class="fa fa-caret-down"></span>
                                    </div>
                                </div>

                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.5s">
                                    <label>Vehicle Transmission Type <span id="transmissionError">*</span></label>
                                    <div class='s-relative'>
                                        <select id="transmission" class="m-select" name="transmission">
                                            <option value="${requestScope.car.transmission}"
                                                    selected="selected">${requestScope.car.transmission}</option>
                                            <option>MANUAL</option>
                                            <option>AUTOMATIC</option>
                                            <option>CVT</option>
                                        </select>
                                        <span class="fa fa-caret-down"></span>
                                    </div>
                                </div>

                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.5s">
                                    <label>Select Car Condition <span id="carConditionError">*</span></label>
                                    <div class='s-relative'>
                                        <select id="carCondition" class="m-select" name="carCondition">
                                            <option value="${requestScope.car.carCondition}"
                                                    selected="selected">${requestScope.car.carCondition}</option>
                                            <option>USED</option>
                                            <option>NEW</option>
                                            <option>CRASH</option>
                                        </select>
                                        <span class="fa fa-caret-down"></span>
                                    </div>
                                </div>

                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.5s">
                                    <label>Enter Engine Capacity <span id="engineCapacityError">*</span></label>
                                    <input id="engineCapacity" placeholder="Enter Capacity" value="${requestScope.car.engineCapacity}"
                                           type="text" name="engineCapacity"/>
                                </div>
                            </div>
                        </div>

                        <div id="step2">
                            <div class="b-submit__main-contacts wow zoomInUp" data-wow-delay="0.3s">
                                <header class="s-headerSubmit s-lineDownLeft">
                                    <h2>SELECT PRICE</h2>
                                </header>
                                <div class="b-submit__main-contacts-price">
                                    <div class="row m-smallPadding">
                                        <div class="col-lg-4 col-xs-12">
                                            <h6>Enter Your Expected Price</h6>
                                        </div>
                                        <div class="col-lg-8 col-xs-12">
                                            <div class="b-submit__main-contacts-price-input">
                                                <input id="price" type='number' value="${requestScope.car.price}" name="price"/>
                                                <span class="b-submit__main-contacts-price-input-usd">
														IN USD $
													</span>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="b-submit__main-contacts wow zoomInUp" data-wow-delay="0.3s">
                                <div class="row">
                                    <div class="col-md-6 col-xs-12">
                                        <div class="b-submit__main-element">
                                            <label>Enter Mileage <span id="milleageError">*</span></label>
                                            <div class="b-submit__main-contacts-inputSelect">
                                                <input id="milleage" type="number" value="${requestScope.car.milleage}"
                                                       name="milleage"/>
                                                <div class="b-submit__main-contacts-select">
                                                    <select name="km" class="m-select">
                                                        <option>IN KMS</option>
                                                    </select>
                                                    <span class="fa fa-caret-down"></span>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="b-submit__main-element">
                                            <label>Select Exterior Color <span id="carColorError">*</span></label>
                                            <div class="s-relative">
                                                <select id="carColor" class="m-select" name="carColor">
                                                    <option value="${requestScope.car.carColor}"
                                                            selected="selected">${requestScope.car.carColor}</option>
                                                    <option>BLACK</option>
                                                    <option>BLUE</option>
                                                    <option>WHITE</option>
                                                    <option>GREEN</option>
                                                    <option>GRAY</option>
                                                    <option>ORANGE</option>
                                                    <option>YELLOW</option>
                                                    <option>BROWN</option>
                                                    <option>RED</option>
                                                    <option>SILVER</option>
                                                    <option>PURPLE</option>
                                                    <option>BURGUNDY</option>
                                                </select>
                                                <span class="fa fa-caret-down"></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-xs-12">
                                        <div class="b-submit__main-element">
                                            <label>Select Interior Material <span id="interiorMaterialError">*</span></label>
                                            <div class="s-relative">
                                                <select id="interiorMaterial" class="m-select" name="interiorMaterial">
                                                    <option value="${requestScope.car.interiorMaterial}"
                                                            selected="selected">${requestScope.car.interiorMaterial}</option>
                                                    <option>LEATHER</option>
                                                    <option>TISSUE</option>
                                                    <option>VELOURS</option>
                                                    <option>ALCANTARA</option>
                                                </select>
                                                <span class="fa fa-caret-down"></span>
                                            </div>
                                        </div>

                                        <div class="b-submit__main-element">
                                            <label>Select Interior Color <span id="interiorColorError">*</span></label>
                                            <div class="s-relative">
                                                <select id="interiorColor" class="m-select" name="interiorColor">
                                                    <option value="${requestScope.car.interiorColor}"
                                                            selected="selected">${requestScope.car.interiorColor}</option>
                                                    <option>BLACK</option>
                                                    <option>WHITE</option>
                                                    <option>GRAY</option>
                                                    <option>ORANGE</option>
                                                    <option>BROWN</option>
                                                    <option>RED</option>
                                                </select>
                                                <span class="fa fa-caret-down"></span>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>

                        <div id="step3" class="b-submit__main-contacts wow zoomInUp" data-wow-delay="0.3s">
                            <header class="s-headerSubmit s-lineDownLeft">
                                <h2>Tell Us How Buyers Contact You</h2>
                            </header>
                            <div class="row">
                                <div class="col-md-6 col-xs-12">
                                    <div class="b-submit__main-element">
                                        <label>Region <span id="regionError">*</span></label>
                                        <input id="region"  type="text" name="region" value="${requestScope.car.region}"/>
                                    </div>
                                </div>
                                <div class="col-md-6 col-xs-12">
                                    <div class="b-submit__main-element">
                                        <label>City <span id="cityError">*</span></label>
                                        <input id="city" type="text" name="city" value="${requestScope.car.city}"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div id="step4" class="s-form">
                            <div class="b-submit__main-file">
                                <header class="s-headerSubmit s-lineDownLeft wow zoomInUp" data-wow-delay="0.3s">
                                    <h2>Your Vehicle Photos</h2>
                                </header>
                                <ul class="b-detail__main-info-images-big bxslider enable-bx-slider"
                                    data-pager-custom="#bx-pager" data-mode="horizontal" data-pager-slide="true"
                                    data-mode-pager="vertical" data-pager-qty="5">
                                    <li class="s-relative">
                                        <img class="img-responsive center-block"
                                             src="${requestScope.car.imageList.get(0).imagePath}"
                                             alt="nissan"/>
                                    </li>

                                </ul>
                            </div>
                            <div class="b-submit__main-file wow zoomInUp" data-wow-delay="0.3s">
                                <header class="s-headerSubmit s-lineDownLeft">
                                    <h2>Write Some Additional Comments About Your Vehicle</h2>
                                </header>
                                <p></p>
                                <textarea id="description" name="description"
                                          placeholder="write additional comments">${requestScope.car.description}</textarea>
                            </div>
                            <input type="hidden" name="command" value="Update"/>
                            <input type="hidden" name="carId" value="${requestScope.car.id}"/>
                            <button type="submit" onclick="return validate(this.form)" class="btn m-btn pull-right wow zoomInUp"
                                    data-wow-delay="0.3s">Save changes<span class="fa fa-angle-right"></span>
                            </button>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div><!--b-submit-->


<footer class="b-footer">
    <a id="to-top" href="#this-is-top"><i class="fa fa-chevron-up"></i></a>
    <div class="container">
        <div class="row">
            <div class="col-xs-4">
                <div class="b-footer__company wow slideInLeft" data-wow-delay="0.3s">
                    <div class="b-nav__logo">
                        <h3><a href="/autobazar/controller">Auto<span>BAZAR</span></a></h3>
                    </div>
                    <p>&copy; 2017 Designed by Andrey Berezovskiy</p>
                </div>
            </div>

        </div>
    </div>
</footer><!--b-footer-->
</div>
<!--Main-->
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/modernizr.custom.js"></script>

<script src="assets/rendro-easy-pie-chart/dist/jquery.easypiechart.min.js"></script>
<script src="js/waypoints.min.js"></script>
<script src="js/jquery.easypiechart.min.js"></script>
<script src="js/classie.js"></script>

<!--Switcher-->
<script src="assets/switcher/js/switcher.js"></script>
<!--Owl Carousel-->
<script src="assets/owl-carousel/owl.carousel.min.js"></script>
<!--bxSlider-->
<script src="assets/bxslider/jquery.bxslider.js"></script>
<!-- jQuery UI Slider -->
<script src="assets/slider/jquery.ui-slider.js"></script>

<!--Theme-->
<script src="js/jquery.smooth-scroll.js"></script>
<script src="js/jquery.maskedinput.min.js"></script>
<script src="js/wow.min.js"></script>
<script src="js/jquery.placeholder.min.js"></script>
<script src="js/theme.js"></script>
<script src="js/search.js"></script>
<script type="text/javascript">

    $(function($){
        $("#doorsNumber").mask("9");
    });
    $(function($){
        $("#year").mask("9999");
    });
    $(function($){
        $("#engineCapacity").mask("9.9");
    });


    document.getElementById("doorsNumber").addEventListener("change", function () {
        if ( this.value == "" ) {
            this.style.borderColor = 'red';
            document.getElementById("doorsNumberError").innerHTML = "* Enter a doors number";
        } else {
            this.style.borderColor = '#eee';
            document.getElementById("doorsNumberError").innerHTML = "*";

        }
    });

    document.getElementById("year").addEventListener("change", function () {
        if ( this.value == "" ) {
            this.style.borderColor = 'red';
            document.getElementById("yearError").innerHTML = "* Enter a year";
        } else {
            this.style.borderColor = '#eee';
            document.getElementById("yearError").innerHTML = "*";

        }
    });

    document.getElementById("engineCapacity").addEventListener("change", function () {
        if ( this.value == "" ) {
            this.style.borderColor = 'red';
            document.getElementById("engineCapacityError").innerHTML = "* Enter a engine capacity";
        } else {
            this.style.borderColor = '#eee';
            document.getElementById("engineCapacityError").innerHTML = "*";

        }
    });

    document.getElementById("price").addEventListener("change", function () {
        if ( this.value == "" ) {
            this.style.borderColor = 'red';
            document.getElementById("priceError").innerHTML = "* Enter a price";
        } else {
            this.style.borderColor = '#eee';
            document.getElementById("priceError").innerHTML = "*";

        }
    });

    document.getElementById("milleage").addEventListener("change", function () {
        if ( this.value == "" ) {
            this.style.borderColor = 'red';
            document.getElementById("milleageError").innerHTML = "* Enter a milleage";
        } else {
            this.style.borderColor = '#eee';
            document.getElementById("milleageError").innerHTML = "*";

        }
    });

    document.getElementById("region").addEventListener("change", function () {
        if ( this.value == "" ) {
            this.style.borderColor = 'red';
            document.getElementById("regionError").innerHTML = "* Enter a region";
        } else {
            this.style.borderColor = '#eee';
            document.getElementById("regionError").innerHTML = "*";

        }
    });

    document.getElementById("city").addEventListener("change", function () {
        if ( this.value == "" ) {
            this.style.borderColor = 'red';
            document.getElementById("cityError").innerHTML = "* Enter a city";
        } else {
            this.style.borderColor = '#eee';
            document.getElementById("cityError").innerHTML = "*";

        }
    });


    function validate(form) {
        var elems = form.elements;
        var valid = true;

        if ( elems.doorsNumber.value == "" ) {
            elems.doorsNumber.style.borderColor = 'red';
            document.getElementById("doorsNumberError").innerHTML = "* Enter a doors number";
            valid = false;
        } else {
            elems.doorsNumber.style.borderColor = '#eee';
            document.getElementById("doorsNumberError").innerHTML = "*";
        }

        if ( elems.year.value == "" ) {
            elems.year.style.borderColor = 'red';
            document.getElementById("yearError").innerHTML = "* Enter a year";
            valid = false;
        } else {
            elems.year.style.borderColor = '#eee';
            document.getElementById("yearError").innerHTML = "*";
        }

        if ( elems.engineCapacity.value == "" ) {
            elems.engineCapacity.style.borderColor = 'red';
            document.getElementById("engineCapacityError").innerHTML = "* Enter a engine capacity";
            valid = false;
        } else {
            elems.engineCapacity.style.borderColor = '#eee';
            document.getElementById("engineCapacityError").innerHTML = "*";
        }

        if ( elems.price.value == "" ) {
            elems.price.style.borderColor = 'red';
            valid = false;
        } else {
            elems.price.style.borderColor = '#eee';
        }

        if ( elems.milleage.value == "" ) {
            elems.milleage.style.borderColor = 'red';
            document.getElementById("milleageError").innerHTML = "* Enter a milleage";
            valid = false;
        } else {
            elems.milleage.style.borderColor = '#eee';
            document.getElementById("milleageError").innerHTML = "*";
        }

        if ( elems.region.value == "" ) {
            elems.region.style.borderColor = 'red';
            document.getElementById("regionError").innerHTML = "* Enter a region";
            valid = false;
        } else {
            elems.region.style.borderColor = '#eee';
            document.getElementById("regionError").innerHTML = "*";
        }

        if ( elems.city.value == "" ) {
            elems.city.style.borderColor = 'red';
            document.getElementById("cityError").innerHTML = "* Enter a city";
            valid = false;
        } else {
            elems.city.style.borderColor = '#eee';
            document.getElementById("cityError").innerHTML = "*";
        }

        return valid;
    }
</script>

</body>
</html>
