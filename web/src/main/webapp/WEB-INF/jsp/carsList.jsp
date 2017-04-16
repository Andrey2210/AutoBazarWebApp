<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false"%>
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
<body class="m-listingsTwo" data-scrolling-animations="true">
<jsp:include page="header.jsp"></jsp:include>
<section class="b-pageHeader">
    <div class="container">
        <h1 class=" wow zoomInLeft" data-wow-delay="0.5s"><fmt:message key="list.autos"/></h1>
        <div class="b-pageHeader__search wow zoomInRight" data-wow-delay="0.5s">
            <h3><fmt:message key="list.header"/> ${sessionScope.pageDetails.amountOfItems} <fmt:message key="list.header.end"/></h3>
        </div>
    </div>
</section><!--b-pageHeader-->

<div class="b-infoBar">
    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-xs-12">
            </div>
            <div class="col-lg-8 col-xs-12">
                <div class="b-infoBar__select wow zoomInUp" data-wow-delay="0.5s">
                    <form id="form-page" method="post" action="">
                        <div class="b-infoBar__select-one">
                            <span class="b-infoBar__select-one-title"><fmt:message key="list.view"/></span>
                            <a href="#" onclick="changePageType(this)" class="m-list m-active"><span class="fa fa-list"></span></a>
                            <a href="#" onclick="changePageType(this)" class="m-table"><span class="fa fa-table"></span></a>
                        </div>
                        <div class="b-infoBar__select-one">
                            <span class="b-infoBar__select-one-title"><fmt:message key="list.onPage"/></span>
                            <select name="itemsOnPage" class="m-select" onchange="onChangeSort(this)">
                                <option value="10" selected="selected">10 items</option>
                                <option value="15">15 items</option>
                                <option value="30">30 items</option>
                            </select>
                            <span class="fa fa-caret-down"></span>
                        </div>
                        <div class="b-infoBar__select-one">
                            <span class="b-infoBar__select-one-title"><fmt:message key="list.sort"/></span>
                            <select name="sort" class="m-select" onchange="onChangeSort(this)">
                                <option value="id" selected="selected">By Date &uarr;</option>
                                <option value="id desc">By Date &darr;</option>
                                <option value="price">By Price &uarr;</option>
                                <option value="price desc">By Price &darr;</option>
                                <option value="year">By Year &uarr;</option>
                                <option value="year desc">By Year &darr;</option>
                            </select>
                            <span id="span-sort" class="fa fa-caret-down"></span>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div><!--b-infoBar-->

<div class="b-items">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-sm-4 col-xs-12">
                <aside class="b-items__aside">
                    <h2 class="s-title wow zoomInUp" data-wow-delay="0.5s"><fmt:message key="list.refineSearch"/></h2>
                    <div class="b-items__aside-main wow zoomInUp" data-wow-delay="0.5s">
                        <form action="/autobazar/controller" method="POST">
                            <div class="b-items__aside-main-body">
                                <div class="b-items__aside-main-body-item">
                                    <label>SELECT A MAKE</label>
                                    <div>
                                        <select name="mark" class="m-select" onchange="onChange(this)">
                                            <option value="" selected="selected">All Makes</option>
                                            <c:forEach var="make" items="${requestScope.allMakes}">
                                                <option value="${make}">${make}</option>
                                            </c:forEach>
                                        </select>
                                        <span class="fa fa-caret-down"></span>
                                    </div>
                                </div>
                                <div class="b-items__aside-main-body-item">
                                    <label>SELECT A MODEL</label>
                                    <div>
                                        <select id="model" class="m-select" name="model">
                                            <option value="" selected="selected">Model</option>
                                        </select>
                                        <span class="fa fa-caret-down"></span>
                                    </div>
                                </div>

                                <div class="b-items__aside-main-body-item">
                                    <label>YEAR</label>
                                    <div class="dropdown dropdown-select dropdown-search">
                                        <button class="btn dropdown-toggle" type="button" data-toggle="dropdown">Year
                                            Range
                                            <span class="caret"></span></button>
                                        <ul class="dropdown-menu dropdown-select-menu dropdown-menu-search">
                                            <li>
                                                <div class="b-search__main-form-range">
                                                    <input type="hidden" name="minYear" class="j-min" value="1960"/>
                                                    <input type="hidden" name="maxYear" class="j-max" value="2017"/>
                                                    <div data-min="1960" data-max="2017" class="slider slider-search">
                                                    </div>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                </div>

                                <div class="b-items__aside-main-body-item">
                                    <label>PRICE</label>
                                    <input type="number" min="0"  max="10000000" name="minPrice" class="j-min" value="0"
                                           placeholder="FROM"/> -
                                    <input type="number" min="0"  max="10000000" name="maxPrice" class="j-max" value="10000000"
                                           placeholder="TO"/>
                                </div>

                                <div class="b-items__aside-main-body-item">
                                    <label>ENGINE CAPACITY</label>
                                    <div class="dropdown dropdown-select dropdown-search">
                                        <button class="btn dropdown-toggle" type="button" data-toggle="dropdown">Engine
                                            Capacity
                                            <span class="caret"></span></button>
                                        <ul class="dropdown-menu dropdown-select-menu dropdown-menu-search">
                                            <li>
                                                <div class="b-search__main-form-range">
                                                    <input type="hidden" name="minEngineCapacity" class="j-min"
                                                           value="0"/>
                                                    <input type="hidden" name="maxEngineCapacity" class="j-max"
                                                           value="10"/>
                                                    <div data-min="0" data-max="10" class="slider slider-search">
                                                    </div>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                </div>

                                <div class="b-items__aside-main-body-item">
                                    <label>TRANSMISSION</label>
                                    <div>
                                        <select name="transmission" class="m-select">
                                            <option value="" selected="selected">Transmission</option>
                                            <option value="AUTOMATIC">AUTOMATIC</option>
                                            <option value="MANUAL">MANUAL</option>
                                            <option value="CVT">CVT</option>
                                        </select>
                                        <span class="fa fa-caret-down"></span>
                                    </div>
                                </div>
                                <div class="b-items__aside-main-body-item">
                                    <label>FUEL TYPE</label>
                                    <div>
                                        <select name="fuelType" class="m-select">
                                            <option value="" selected="selected">Fuel Type</option>
                                            <option value="PETROL">Petrol</option>
                                            <option value="DIESEL">Diesel</option>
                                            <option value="ELECTRO">Electro</option>
                                        </select>
                                        <span class="fa fa-caret-down"></span>
                                    </div>
                                </div>
                                <div class="b-items__aside-main-body-item">
                                    <label>BODY TYPE</label>
                                    <div>
                                        <select name="bodyType" class="m-select">
                                            <option value="" selected="selected">Body Types</option>
                                            <option value="PICKUP">Pickup</option>
                                            <option value="SUV">Suv</option>
                                            <option value="COUPE">Coupe</option>
                                            <option value="CONVERTIBLE">Convertible</option>
                                            <option value="HATCHBACK">Hatchback</option>
                                        </select>
                                        <span class="fa fa-caret-down"></span>
                                    </div>
                                </div>
                            </div>
                            <footer class="b-items__aside-main-footer">
                                <input type="hidden" name="command" value="Search" />
                                <button type="submit" class="btn m-btn">FILTER VEHICLES<span
                                        class="fa fa-angle-right"></span></button>
                                <br/>
                                <a href="">RESET ALL FILTERS</a>
                            </footer>
                        </form>
                    </div>

                </aside>
            </div>
            <div class="col-lg-9 col-sm-8 col-xs-12 b-items-cars">

                    <jsp:include page="items.jsp"></jsp:include>

            </div>
        </div>
    </div>
</div><!--b-items-->


<footer class="b-footer">
    <a id="to-top" href="#this-is-top"><i class="fa fa-chevron-up"></i></a>
    <div class="container">
        <div class="row">
            <div class="col-xs-4">
                <div class="b-footer__company wow zoomInLeft" data-wow-delay="0.5s">
                    <div class="b-nav__logo">
                        <h3><a href="home.html">Auto<span>Club</span></a></h3>
                    </div>
                    <p>&copy; 2017 Designed by Andrei Berezovski</p>
                </div>
            </div>

        </div>
    </div>
</footer><!--b-footer-->
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
<script src="js/listingsPage.js"></script>

<script type="text/javascript" >
    function onChangeSort(_this) {
        var value = _this.value;
        if (_this.name == "itemsOnPage") {
            $.ajax({
                method: "POST",
                url: "/autobazar/controller",
                data: {'itemsOnPage': value, 'pageType': "items", "command": "PageDetails"},
                success: function (result) {
                    $(".b-items-cars").html(result);
                }
            });
        } else {
            $.ajax({
                method: "POST",
                url: "/autobazar/controller",
                data: {'sort': value, 'pageType': "items", "command": "PageDetails"},
                success: function (result) {
                    $(".b-items-cars").html(result);
                }
            });
        }
    }
    function changePageType(_this) {
        if(_this.classList.contains("m-list") ) {
            $.ajax({
                method: "POST",
                url: "/autobazar/controller",
                data: {'pageType': "items", "command": "PageDetails"},
                success: function (result) {
                    $(".b-items-cars").html(result);
                }
            });
        } else {
            $.ajax({
                method: "POST",
                url: "/autobazar/controller",
                data: {'pageType': "itemsTable", "command": "PageDetails"},
                success: function (result) {
                    $(".b-items-cars").html(result);
                }
            });
        }


    }
</script>
</body>
</html>