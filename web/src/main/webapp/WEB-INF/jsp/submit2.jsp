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
<body class="m-submit2" data-scrolling-animations="true" >



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
                    <div class="b-submit__aside-step wow zoomInUp" data-wow-delay="0.3s">
                        <h3>Step 3</h3>
                        <div class="b-submit__aside-step-inner clearfix">
                            <div class="b-submit__aside-step-inner-icon">
                                <span class="fa fa-photo"></span>
                            </div>
                            <div class="b-submit__aside-step-inner-info">
                                <h4>Photos &amp; videos</h4>
                                <p>Add images / videos of vehicle</p>
                            </div>
                        </div>
                    </div>
                    <div class="b-submit__aside-step wow zoomInUp" data-wow-delay="0.3s">
                        <h3>Step 4</h3>
                        <div class="b-submit__aside-step-inner clearfix">
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
                    <header class="s-headerSubmit s-lineDownLeft wow zoomInUp" data-wow-delay="0.3s">
                        <h2 class="">Select Additional Features Of  Your Vehicle</h2>
                    </header>
                    <p class=" wow zoomInUp" data-wow-delay="0.3s">Curabitur libero. Donec facilisis velit eu est. Phasellus cons quat. Aenean vitae quam. Vivamus et nunc. Nunc consequsem velde metus imperdiet lacinia. Lorem ipsum dolor sit amet consectetur adipisicing elit.</p>
                    <form class="s-submit clearfix" action="/autobazar/submit" method="POST">
                        <div class="row">
                            <div class="col-md-6 col-xs-12">
                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.3s">
                                    <input type="checkbox" name="check1" id="check1" />
                                    <label class="s-submitCheckLabel" for="check1"><span class="fa fa-check"></span></label>
                                    <label class="s-submitCheck" for="check1">ABS</label>
                                </div>
                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.3s">
                                    <input type="checkbox" name="check2" id="check2" />
                                    <label class="s-submitCheckLabel" for="check2"><span class="fa fa-check"></span></label>
                                    <label class="s-submitCheck" for="check2">Alloy Wheels</label>
                                </div>
                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.3s">
                                    <input type="checkbox" name="check3" id="check3" />
                                    <label class="s-submitCheckLabel" for="check3"><span class="fa fa-check"></span></label>
                                    <label class="s-submitCheck" for="check3">Passenger Airbag</label>
                                </div>
                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.3s">
                                    <input type="checkbox" name="check4" id="check4" />
                                    <label class="s-submitCheckLabel" for="check4"><span class="fa fa-check"></span></label>
                                    <label class="s-submitCheck" for="check4">Heated Door Mirrors</label>
                                </div>
                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.3s">
                                    <input type="checkbox" name="check5" id="check5" />
                                    <label class="s-submitCheckLabel" for="check5"><span class="fa fa-check"></span></label>
                                    <label class="s-submitCheck" for="check5">Air Conditioning</label>
                                </div>
                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.3s">
                                    <input type="checkbox" name="check6" id="check6" />
                                    <label class="s-submitCheckLabel" for="check6"><span class="fa fa-check"></span></label>
                                    <label class="s-submitCheck" for="check6">Trip Computer</label>
                                </div>
                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.3s">
                                    <input type="checkbox" name="check7" id="check7" />
                                    <label class="s-submitCheckLabel" for="check7"><span class="fa fa-check"></span></label>
                                    <label class="s-submitCheck" for="check7">Side Airbags</label>
                                </div>
                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.3s">
                                    <input type="checkbox" name="check8" id="check8" />
                                    <label class="s-submitCheckLabel" for="check8"><span class="fa fa-check"></span></label>
                                    <label class="s-submitCheck" for="check8">Audio Remote Control</label>
                                </div>
                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.3s">
                                    <input type="checkbox" name="check9" id="check9" />
                                    <label class="s-submitCheckLabel" for="check9"><span class="fa fa-check"></span></label>
                                    <label class="s-submitCheck" for="check9">Folding Rear Seats</label>
                                </div>
                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.3s">
                                    <input type="checkbox" name="check10" id="check10" />
                                    <label class="s-submitCheckLabel" for="check10"><span class="fa fa-check"></span></label>
                                    <label class="s-submitCheck" for="check10">Central Locking - Keyless</label>
                                </div>
                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.3s">
                                    <input type="checkbox" name="check11" id="check11" />
                                    <label class="s-submitCheckLabel" for="check11"><span class="fa fa-check"></span></label>
                                    <label class="s-submitCheck" for="check11">Weather Shields</label>
                                </div>
                                <div class="b-submit__main-element m-border wow zoomInUp" data-wow-delay="0.3s">
                                    <input type="checkbox" name="check12" id="check12" />
                                    <label class="s-submitCheckLabel" for="check12"><span class="fa fa-check"></span></label>
                                    <label class="s-submitCheck" for="check12">Electric Front Seats</label>
                                </div>
                            </div>
                            <div class="col-md-6 col-xs-12">
                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.3s">
                                    <input type="checkbox" name="check13" id="check13" />
                                    <label class="s-submitCheckLabel" for="check13"><span class="fa fa-check"></span></label>
                                    <label class="s-submitCheck" for="check13">Engine Immobiliser</label>
                                </div>
                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.3s">
                                    <input type="checkbox" name="check14" id="check14" />
                                    <label class="s-submitCheckLabel" for="check14"><span class="fa fa-check"></span></label>
                                    <label class="s-submitCheck" for="check14">Fog Lamps</label>
                                </div>
                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.3s">
                                    <input type="checkbox" name="check15" id="check15" />
                                    <label class="s-submitCheckLabel" for="check15"><span class="fa fa-check"></span></label>
                                    <label class="s-submitCheck" for="check15">GPS Satellite Navigation </label>
                                </div>
                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.3s">
                                    <input type="checkbox" name="check16" id="check16" />
                                    <label class="s-submitCheckLabel" for="check16"><span class="fa fa-check"></span></label>
                                    <label class="s-submitCheck" for="check16">Headlight Covers</label>
                                </div>
                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.3s">
                                    <input type="checkbox" name="check17" id="check17" />
                                    <label class="s-submitCheckLabel" for="check17"><span class="fa fa-check"></span></label>
                                    <label class="s-submitCheck" for="check17">Leather Seats</label>
                                </div>
                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.3s">
                                    <input type="checkbox" name="check18" id="check18" />
                                    <label class="s-submitCheckLabel" for="check18"><span class="fa fa-check"></span></label>
                                    <label class="s-submitCheck" for="check18">Leather Trim</label>
                                </div>
                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.3s">
                                    <input type="checkbox" name="check19" id="check19" />
                                    <label class="s-submitCheckLabel" for="check19"><span class="fa fa-check"></span></label>
                                    <label class="s-submitCheck" for="check19">LPG (Dual Fuel)</label>
                                </div>
                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.3s">
                                    <input type="checkbox" name="check20" id="check20" />
                                    <label class="s-submitCheckLabel" for="check20"><span class="fa fa-check"></span></label>
                                    <label class="s-submitCheck" for="check20">Roof Deflector</label>
                                </div>
                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.3s">
                                    <input type="checkbox" name="check21" id="check21" />
                                    <label class="s-submitCheckLabel" for="check21"><span class="fa fa-check"></span></label>
                                    <label class="s-submitCheck" for="check21">Rear Spoiler</label>
                                </div>
                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.3s">
                                    <input type="checkbox" name="check22" id="check22" />
                                    <label class="s-submitCheckLabel" for="check22"><span class="fa fa-check"></span></label>
                                    <label class="s-submitCheck" for="check22">Tinted Windows</label>
                                </div>
                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.3s">
                                    <input type="checkbox" name="check23" id="check23" />
                                    <label class="s-submitCheckLabel" for="check23"><span class="fa fa-check"></span></label>
                                    <label class="s-submitCheck" for="check23">Tow Bar</label>
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