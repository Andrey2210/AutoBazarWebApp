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
                            <div class="col-md-6 col-xs-12">
                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.5s">
                                    <label>Enter Make <span>*</span></label>
                                    <div class='s-relative'>
                                        <select class="m-select" name="mark" disabled>
                                            <option value="${requestScope.car.mark}"
                                                    selected="selected">${requestScope.car.mark}</option>
                                        </select>
                                        <span class="fa fa-caret-down"></span>
                                    </div>
                                </div>

                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.5s">
                                    <label>Select Body Type <span>*</span></label>
                                    <div class='s-relative'>
                                        <select class="m-select" name="bodyType">
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
                                    <label>Select Fuel Type <span>*</span></label>
                                    <div class='s-relative'>
                                        <select class="m-select" name="fuelType">
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
                                    <label>No. of Doors <span>*</span></label>
                                    <input placeholder="Enter No. of Doors" value="${requestScope.car.doorsNumber}"
                                           type="text" name="doorsNumber"/>
                                </div>

                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.5s">
                                    <label>Vehicle Manufacturer Year<span>*</span></label>
                                    <div class="b-submit__main-element">
                                        <input type="text" value="${requestScope.car.year.getYear()}" name="year"/>
                                    </div>
                                </div>

                            </div>

                            <div class="col-md-6 col-xs-12">

                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.5s">
                                    <label>Enter Vehicle Model <span>*</span></label>
                                    <div class='s-relative'>
                                        <select id="model" class="m-select" name="model" disabled>
                                            <option value="${requestScope.car.model}"
                                                    selected="selected">${requestScope.car.model}</option>
                                        </select>
                                        <span class="fa fa-caret-down"></span>
                                    </div>
                                </div>

                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.5s">
                                    <label>Select Drive Type <span>*</span></label>
                                    <div class='s-relative'>
                                        <select class="m-select" name="driving">
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
                                    <label>Vehicle Transmission Type <span>*</span></label>
                                    <div class='s-relative'>
                                        <select class="m-select" name="transmission">
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
                                    <label>Select Car Condition <span>*</span></label>
                                    <div class='s-relative'>
                                        <select class="m-select" name="carCondition">
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
                                    <label>Enter Engine Capacity <span>*</span></label>
                                    <input placeholder="Enter Capacity" value="${requestScope.car.engineCapacity}"
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
                                                <span class="fa fa-car"></span>
                                                <input type='text' value="${requestScope.car.price}" name="price"/>
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
                                            <label>Enter Mileage <span>*</span></label>
                                            <div class="b-submit__main-contacts-inputSelect">
                                                <input type="text" value="${requestScope.car.milleage}"
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
                                            <label>Select Exterior Color <span>*</span></label>
                                            <div class="s-relative">
                                                <select class="m-select" name="carColor">
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
                                            <label>Select Interior Material <span>*</span></label>
                                            <div class="s-relative">
                                                <select class="m-select" name="interiorMaterial">
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
                                            <label>Select Interior Color <span>*</span></label>
                                            <div class="s-relative">
                                                <select class="m-select" name="interiorColor">
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
                                        <label>Region <span>*</span></label>
                                        <input type="text" name="region" value="${requestScope.car.region}"/>
                                    </div>
                                </div>
                                <div class="col-md-6 col-xs-12">
                                    <div class="b-submit__main-element">
                                        <label>City <span>*</span></label>
                                        <input type="text" name="city" value="${requestScope.car.city}"/>
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
                                <textarea name="description"
                                          placeholder="write additional comments">${requestScope.car.description}</textarea>
                            </div>
                            <input type="hidden" name="command" value="Update"/>
                            <input type="hidden" name="carId" value="${requestScope.car.id}"/>
                            <button type="submit" class="btn m-btn pull-right wow zoomInUp"
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
<script src="js/wow.min.js"></script>
<script src="js/jquery.placeholder.min.js"></script>
<script src="js/theme.js"></script>
<script src="js/search.js"></script>

</body>
</html>
