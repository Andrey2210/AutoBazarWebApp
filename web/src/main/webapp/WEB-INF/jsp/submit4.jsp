<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 25.02.2017
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>AUTO BAZAR</title>

    <link rel="shortcut icon" type="image/x-icon" href="../../images/favicon.png" />
    <link href="../../css/master.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="//oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="//oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body class="m-submit4" data-scrolling-animations="true" >

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
                        <a class="m-langLink dropdown-toggle" data-toggle='dropdown' href="#"><span class="b-topBar__lang-flag m-en"></span>EN<span class="fa fa-caret-down"></span></a>
                        <ul class="dropdown-menu h-lang">
                            <li><a class="m-langLink dropdown-toggle" data-toggle='dropdown' href="#"><span class="b-topBar__lang-flag m-en"></span>EN</a></li>
                            <li><a class="m-langLink dropdown-toggle" data-toggle='dropdown' href="#"><span class="b-topBar__lang-flag m-es"></span>RU</a></li>
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
                    <h3><a href="home.html">Auto<span>BAZAR</span></a></h3>
                    <h2><a href="home.html">sell your car with us</a></h2>
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
                            <li><li><a href="home.html">Home</a></li>
                            <li><a href="about.html">About</a></li>
                            <li><a href="submit1.html">Shop</a></li>
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
        <h1 class="wow zoomInLeft" data-wow-delay="0.5s">Submit Your Vehicle</h1>
        <div class="b-pageHeader__search wow zoomInRight" data-wow-delay="0.5s">
            <h3>Add Your Vehicle In Our Listings</h3>
        </div>
    </div>
</section><!--b-pageHeader-->

<div class="b-submit">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-4 col-sm-5 col-xs-6">
                <aside class="b-submit__aside">
                    <div class="b-submit__aside-step m-active wow zoomInUp" data-wow-delay="0.3s">
                        <h3>Step 1</h3>
                        <div class="b-submit__aside-step-inner m-active clearfix">
                            <div class="b-submit__aside-step-inner-icon">
                                <span class="fa fa-car"></span>
                            </div>
                            <div class="b-submit__aside-step-inner-info">
                                <h4>Add YOUR Vehicle</h4>
                                <p>Select your vehicle &amp; add info</p>
                                <div class="b-submit__aside-step-inner-info-triangle"></div>
                            </div>
                        </div>
                    </div>
                    <div class="b-submit__aside-step m-active wow zoomInUp" data-wow-delay="0.3s">
                        <h3>Step 2</h3>
                        <div class="b-submit__aside-step-inner m-active clearfix">
                            <div class="b-submit__aside-step-inner-icon">
                                <span class="fa fa-list-ul"></span>
                            </div>
                            <div class="b-submit__aside-step-inner-info">
                                <h4>select details</h4>
                                <p>Choose vehicle specifications</p>
                                <div class="b-submit__aside-step-inner-info-triangle"></div>
                            </div>
                        </div>
                    </div>
                    <div class="b-submit__aside-step m-active wow zoomInUp" data-wow-delay="0.3s">
                        <h3>Step 3</h3>
                        <div class="b-submit__aside-step-inner m-active clearfix">
                            <div class="b-submit__aside-step-inner-icon">
                                <span class="fa fa-photo"></span>
                            </div>
                            <div class="b-submit__aside-step-inner-info">
                                <h4>Photos &amp; videos</h4>
                                <p>Add images / videos of vehicle</p>
                                <div class="b-submit__aside-step-inner-info-triangle"></div>
                            </div>
                        </div>
                    </div>
                    <div class="b-submit__aside-step m-active wow zoomInUp" data-wow-delay="0.3s">
                        <h3>Step 4</h3>
                        <div class="b-submit__aside-step-inner m-active clearfix">
                            <div class="b-submit__aside-step-inner-icon">
                                <span class="fa fa-user"></span>
                            </div>
                            <div class="b-submit__aside-step-inner-info">
                                <h4>Contact details</h4>
                                <p>Choose vehicle specifications</p>
                            </div>
                        </div>
                    </div>
                    <div class="b-submit__aside-step wow zoomInUp" data-wow-delay="0.3s">
                        <h3>Step 5</h3>
                        <div class="b-submit__aside-step-inner clearfix">
                            <div class="b-submit__aside-step-inner-icon">
                                <span class="fa fa-globe"></span>
                            </div>
                            <div class="b-submit__aside-step-inner-info">
                                <h4>SUBMIT &amp; PUBLISH</h4>
                                <p>Add images / videos of vehicle</p>
                            </div>
                        </div>
                    </div>
                </aside>
            </div>
            <div class="col-lg-9 col-md-8 col-sm-7 col-xs-6">
                <div class="b-submit__main">
                    <form action="/autobazar/submit" method="post" class='s-submit'>
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
                                            <input type='text' name="price"/>
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
                                            <input type="text" name="text1"/>
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
                                            <select class="m-select" name="select1">
                                                <option>Select</option>
                                            </select>
                                            <span class="fa fa-caret-down"></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6 col-xs-12">
                                    <div class="b-submit__main-element">
                                        <label>Select Interior Material <span>*</span></label>
                                        <div class="s-relative">
                                            <select class="m-select" name="select2">
                                                <option>Select</option>
                                            </select>
                                            <span class="fa fa-caret-down"></span>
                                        </div>
                                    </div>

                                    <div class="b-submit__main-element">
                                        <label>Select Interior Color <span>*</span></label>
                                        <div class="s-relative">
                                            <select class="m-select" name="select1">
                                                <option>Select</option>
                                            </select>
                                            <span class="fa fa-caret-down"></span>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>

                        <div class="b-submit__main-contacts wow zoomInUp" data-wow-delay="0.3s">
                            <header class="s-headerSubmit s-lineDownLeft">
                                <h2>Tell Us How Buyers Contact You</h2>
                            </header>
                            <div class="b-submit__main-element">
                                <label>Your Name <span>*</span></label>
                                <input type="text" name="addr" />
                            </div>
                            <div class="row">
                                <div class="col-md-6 col-xs-12">
                                    <div class="b-submit__main-element">
                                        <label>Region  <span>*</span></label>
                                        <input type="text" name="city" />
                                    </div>
                                </div>
                                <div class="col-md-6 col-xs-12">
                                    <div class="b-submit__main-element">
                                        <label>City <span>*</span></label>
                                        <input type="text" name="code" />
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-6 col-xs-12">
                                    <div class="b-submit__main-element">
                                        <label>Enter Your Phone Number  <span>*</span></label>
                                        <input type="text" name="phone" />
                                    </div>
                                </div>

                            </div>
                        </div>
                        <button type="submit" class="btn m-btn pull-right wow zoomInUp" data-wow-delay="0.3s">Save &amp; PROCEED to next step<span class="fa fa-angle-right"></span></button>
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
                        <h3><a href="home.html">Auto<span>BAZAR</span></a></h3>
                    </div>
                    <p>&copy; 2017 Designed by Andrey Berezovskiy</p>
                </div>
            </div>
            <div class="col-xs-8">
                <div class="b-footer__content wow slideInRight" data-wow-delay="0.3s">
                    <div class="b-footer__content-social">
                        <a href="#"><span class="fa fa-facebook-square"></span></a>
                        <a href="#"><span class="fa fa-twitter-square"></span></a>
                        <a href="#"><span class="fa fa-google-plus-square"></span></a>
                        <a href="#"><span class="fa fa-instagram"></span></a>
                        <a href="#"><span class="fa fa-youtube-square"></span></a>
                        <a href="#"><span class="fa fa-skype"></span></a>
                    </div>
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
</div>
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