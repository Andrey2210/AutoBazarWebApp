<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 18.03.2017
  Time: 17:34
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
    <title>AUTO BAZAR</title>

    <link rel="shortcut icon" type="image/x-icon" href="../../images/favicon.png"/>
    <link href="../../css/master.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="//oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="//oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body class=m-contacts" data-scrolling-animations="true">


<header class="b-topBar">
    <div class="container wow slideInDown" data-wow-delay="0.7s">
        <div class="row">
            <div class="col-md-6 col-xs-6">
                <div class="b-topBar__tel">
                    <span class="fa fa-phone"></span>
                    +375 (44) 557-52-21
                </div>
            </div>
            <div class="col-md-4 col-xs-6">
                <nav class="b-topBar__nav">
                    <ul>
                        <li><a href="#">Register</a></li>
                        <li><a href="#">Sign in</a></li>
                    </ul>
                </nav>
            </div>
            <div class="col-md-2 col-xs-6">
                <div class="b-topBar__lang">
                    <div class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle='dropdown'>Language</a>
                        <a class="m-langLink dropdown-toggle" data-toggle='dropdown' href="#"><span
                                class="b-topBar__lang-flag m-en"></span>EN<span class="fa fa-caret-down"></span></a>
                        <ul class="dropdown-menu h-lang">
                            <li><a class="m-langLink dropdown-toggle" data-toggle='dropdown' href="#"><span
                                    class="b-topBar__lang-flag m-en"></span>EN</a></li>
                            <li><a class="m-langLink dropdown-toggle" data-toggle='dropdown' href="#"><span
                                    class="b-topBar__lang-flag m-es"></span>RU</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header><!--b-topBar-->

<nav class="b-nav">
    <div class="container">
        <div class="row">
            <div class="col-sm-3 col-xs-4">
                <div class="b-nav__logo wow slideInLeft" data-wow-delay="0.3s">
                    <h3><a href="/autobazar">Auto<span>BAZAR</span></a></h3>
                    <h2><a href="/autobazar">sell your car with us</a></h2>
                </div>
            </div>
            <div class="col-sm-9 col-xs-8">
                <div class="b-nav__list wow slideInRight" data-wow-delay="0.3s">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#nav">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>
                    <div class="collapse navbar-collapse navbar-main-slide" id="nav">
                        <ul class="navbar-nav-menu">
                            <li>
                            <li><a href="/autobazar">Home</a></li>
                            <li><a href="about.html">About</a></li>
                            <li><a href="/autobazar/carsList">Shop</a></li>
                            <li><a href="contacts.html">Contact</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</nav><!--b-nav-->

<section class="b-pageHeader">
    <div class="container">
        <h1 class=" wow zoomInLeft" data-wow-delay="0.5s">Auto Listings</h1>
        <div class="b-pageHeader__search wow zoomInRight" data-wow-delay="0.5s">
            <h3>Your search returned ${sessionScope.pageDetails.amountOfItems} results</h3>
        </div>
    </div>
</section><!--b-pageHeader-->


<section class="b-contacts s-shadow">
    <div class="container">
        <div class="row">

            <div class="col-xs-7">
                <div class="b-contacts__form">
                    <header class="b-contacts__form-header s-lineDownLeft wow zoomInUp" data-wow-delay="0.5s">
                        <h2 class="s-titleDet">Registering</h2>
                    </header>
                    <div></div>
                    <form action="/registration" method="post" class="s-form wow zoomInUp" data-wow-delay="0.5s">
                        <label>Enter login <span>*</span></label>
                        <input type="text" placeholder="YOUR LOGIN" value="" name="login" id="login" />
                        <label>Enter email <span>*</span></label>
                        <input type="text" placeholder="EMAIL ADDRESS" value="" name="email" id="email" />
                        <label>Enter password <span>*</span></label>
                        <input type="password" placeholder="PASSWORD" value="" name="password" id="password" />
                        <label>Confirm password <span>*</span></label>
                        <input type="password" placeholder="PASSWORD" value="" name="confirm-password" id="confirm-password" />
                        <label>Enter your name <span>*</span></label>
                        <input type="text" placeholder="YOUR NAME." value="" name="name" id="name" />
                        <label>Enter phone <span>*</span></label>
                        <input type="text" placeholder="YOUR PHONE." value="" name="phone" id="phone" />
                        <button type="submit" class="btn m-btn">SUBMIT NOW<span class="fa fa-angle-right"></span></button>
                    </form>
                </div>
            </div>

        </div>
    </div>
</section>


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
            <div class="col-xs-8">
                <div class="b-footer__content wow zoomInRight" data-wow-delay="0.5s">
                    <nav class="b-footer__content-nav">
                        <ul>
                            <li><a href="home.html">Home</a></li>
                            <li><a href="about.html">About</a></li>
                            <li><a href="listTable.html">Shop</a></li>
                            <li><a href="contacts.html">Contact</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</footer><!--b-footer-->
<!--Main-->
<script src="../../js/jquery-1.11.3.min.js"></script>
<script src="../../js/jquery-ui.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<script src="../../js/modernizr.custom.js"></script>

<script src="../../assets/rendro-easy-pie-chart/dist/jquery.easypiechart.min.js"></script>
<script src="../../js/waypoints.min.js"></script>
<script src="../../js/jquery.easypiechart.min.js"></script>
<script src="../../js/classie.js"></script>

<!--Switcher-->
<script src="../../assets/switcher/js/switcher.js"></script>
<!--Owl Carousel-->
<script src="../../assets/owl-carousel/owl.carousel.min.js"></script>
<!--bxSlider-->
<script src="../../assets/bxslider/jquery.bxslider.js"></script>
<!-- jQuery UI Slider -->
<script src="../../assets/slider/jquery.ui-slider.js"></script>

<!--Theme-->
<script src="../../js/jquery.smooth-scroll.js"></script>
<script src="../../js/wow.min.js"></script>
<script src="../../js/jquery.placeholder.min.js"></script>
<script src="../../js/theme.js"></script>
</body>
</html>
