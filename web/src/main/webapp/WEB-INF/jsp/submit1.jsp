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

    <link rel="shortcut icon" type="image/x-icon" href="../../images/favicon.png"/>
    <link href="../../css/master.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="//oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="//oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body class="m-submit1" data-scrolling-animations="true">

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


<div id="b-submit" class="b-submit">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-4 col-sm-5 col-xs-6" >
                <aside class="b-submit__aside">
                    <div id="menu-step1" class="b-submit__aside-step m-active wow zoomInUp" data-wow-delay="0.5s">
                        <h3>Step 1</h3>
                        <div class="b-submit__aside-step-inner m-active clearfix">
                            <div class="b-submit__aside-step-inner-icon">
                                <span class="fa fa-car"></span>
                            </div>
                            <div class="b-submit__aside-step-inner-info">
                                <h4>Add YOUR Vehicle</h4>
                                <p>Select your vehicle &amp; add info</p>
                            </div>
                        </div>
                    </div>
                    <div id="menu-step2" class="b-submit__aside-step wow zoomInUp" data-wow-delay="0.5s">
                        <h3>Step 2</h3>
                        <div class="b-submit__aside-step-inner clearfix">
                            <div class="b-submit__aside-step-inner-icon">
                                <span class="fa fa-list-ul"></span>
                            </div>
                            <div class="b-submit__aside-step-inner-info">
                                <h4>select details</h4>
                                <p>Choose vehicle specifications</p>
                            </div>
                        </div>
                    </div>
                    <div id="menu-step3" class="b-submit__aside-step wow zoomInUp" data-wow-delay="0.5s">
                        <h3>Step 3</h3>
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
                    <div id="menu-step4" class="b-submit__aside-step wow zoomInUp" data-wow-delay="0.5s">
                        <h3>Step 4</h3>
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
                    <div id="menu-step5" class="b-submit__aside-step wow zoomInUp" data-wow-delay="0.5s">
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
                    <header class="s-headerSubmit s-lineDownLeft wow zoomInUp" data-wow-delay="0.5s">
                        <h2 class="">Add Your Vehicle Details</h2>
                    </header>
                    <form class="s-submit clearfix" action="/autobazar/submit" name="submit1" method="POST"
                          enctype="multipart/form-data">
                        <div id="step1" class="row">
                            <div class="col-md-6 col-xs-12">
                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.5s">
                                    <label>Enter Make <span>*</span></label>
                                    <div class='s-relative'>
                                        <select class="m-select" name="mark">
                                            <option>Any Make</option>
                                        </select>
                                        <span class="fa fa-caret-down"></span>
                                    </div>
                                </div>

                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.5s">
                                    <label>Vehicle Manufacturer Year<span>*</span></label>
                                    <div class='s-relative'>
                                        <select class="m-select" name="year">
                                            <option>Select</option>
                                        </select>
                                        <span class="fa fa-caret-down"></span>
                                    </div>
                                </div>

                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.5s">
                                    <label>Select Fuel Type <span>*</span></label>
                                    <div class='s-relative'>
                                        <select class="m-select" name="fuel_type">
                                            <option>Select</option>
                                        </select>
                                        <span class="fa fa-caret-down"></span>
                                    </div>
                                </div>


                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.5s">
                                    <label>No. of Doors <span>*</span></label>
                                    <div class='s-relative'>
                                        <select class="m-select" name="doors_number">
                                            <option>Select</option>
                                        </select>
                                        <span class="fa fa-caret-down"></span>
                                    </div>
                                </div>
                            </div>

                            <div class="col-md-6 col-xs-12">

                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.5s">
                                    <label>Enter Vehicle Model <span>*</span></label>
                                    <div class='s-relative'>
                                        <select class="m-select" name="model">
                                            <option>Select a Model</option>
                                        </select>
                                        <span class="fa fa-caret-down"></span>
                                    </div>
                                </div>

                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.5s">
                                    <label>Select Drive Type <span>*</span></label>
                                    <div class='s-relative'>
                                        <select class="m-select" name="driving">
                                            <option>Select</option>
                                        </select>
                                        <span class="fa fa-caret-down"></span>
                                    </div>
                                </div>

                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.5s">
                                    <label>Vehicle Transmission Type <span>*</span></label>
                                    <div class='s-relative'>
                                        <select class="m-select" name="transmission">
                                            <option>Select</option>
                                        </select>
                                        <span class="fa fa-caret-down"></span>
                                    </div>
                                </div>

                                <div class="b-submit__main-element wow zoomInUp" data-wow-delay="0.5s">
                                    <label>Enter Engine Capacity <span>*</span></label>
                                    <input placeholder="Enter Capacity" type="text" name="engine_capacity"/>
                                </div>

                            </div>
                            <button onclick="nextStep(this)" type="button" class="btn m-btn pull-right wow zoomInUp"
                                    data-wow-delay="0.5s">Save &amp; PROCEED
                                to next step<span class="fa fa-angle-right"></span></button>
                        </div>


                        <div id="step2" style="display: none;">
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
                                                <input type="text" name="mileage"/>
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
                                                <select class="m-select" name="car_color">
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
                                                <select class="m-select" name="interior_material">
                                                    <option>Select</option>
                                                </select>
                                                <span class="fa fa-caret-down"></span>
                                            </div>
                                        </div>

                                        <div class="b-submit__main-element">
                                            <label>Select Interior Color <span>*</span></label>
                                            <div class="s-relative">
                                                <select class="m-select" name="interior_color">
                                                    <option>Select</option>
                                                </select>
                                                <span class="fa fa-caret-down"></span>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <button onclick="nextStep(this)" type="button" class="btn m-btn pull-right wow zoomInUp"
                                    data-wow-delay="0.5s">Save &amp; PROCEED
                                to next step<span class="fa fa-angle-right"></span></button>
                        </div>

                        <div id="step3" class="b-submit__main-contacts wow zoomInUp" data-wow-delay="0.3s"
                             style="display: none;">
                            <header class="s-headerSubmit s-lineDownLeft">
                                <h2>Tell Us How Buyers Contact You</h2>
                            </header>
                            <div class="b-submit__main-element">
                                <label>Your Name <span>*</span></label>
                                <input type="text" name="name"/>
                            </div>
                            <div class="row">
                                <div class="col-md-6 col-xs-12">
                                    <div class="b-submit__main-element">
                                        <label>Region <span>*</span></label>
                                        <input type="text" name="region"/>
                                    </div>
                                </div>
                                <div class="col-md-6 col-xs-12">
                                    <div class="b-submit__main-element">
                                        <label>City <span>*</span></label>
                                        <input type="text" name="city"/>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-6 col-xs-12">
                                    <div class="b-submit__main-element">
                                        <label>Enter Your Phone Number <span>*</span></label>
                                        <input type="text" name="phone"/>
                                    </div>
                                </div>

                            </div>
                            <button onclick="nextStep(this)" type="button" class="btn m-btn pull-right wow zoomInUp"
                                    data-wow-delay="0.5s">Save &amp; PROCEED
                                to next step<span class="fa fa-angle-right"></span></button>
                        </div>


                        <div id="step4" class="s-form" style="display: none;">
                            <div class="b-submit__main-file">
                                <header class="s-headerSubmit s-lineDownLeft wow zoomInUp" data-wow-delay="0.3s">
                                    <h2>Upload Your Vehicle Photos</h2>
                                </header>
                                <p class=" wow zoomInUp" data-wow-delay="0.3s">You can upload upto 10 photos of your
                                    vehicle here.</p>
                                <label class="b-submit__main-file-label btn m-btn wow zoomInUp" data-wow-delay="0.3s">
                                    <input type="file" multiple class="" name="img" accept="image/*,image/jpeg"/>
                                    <span>CHOOSE A  PHOTO</span>
                                    <span class="fa fa-angle-right"></span>
                                </label>
                                <label>Max. file size: 3.5 MB. Allowed images: jpg, gif, png.</label>
                            </div>
                            <div class="b-submit__main-file wow zoomInUp" data-wow-delay="0.3s">
                                <header class="s-headerSubmit s-lineDownLeft">
                                    <h2>Write Some Additional Comments About Your Vehicle</h2>
                                </header>
                                <p></p>
                                <textarea name="text" placeholder="write additional comments"></textarea>
                            </div>
                            <button onclick="nextStep(this)" type="button" class="btn m-btn pull-right wow zoomInUp"
                                    data-wow-delay="0.5s">Save &amp; PROCEED
                                to next step<span class="fa fa-angle-right"></span></button>
                        </div>


                        <div id="step5" class="b-submit__main-plan wow zoomInUp" data-wow-delay="0.3s"
                             style="display: none;">
                            <header class="s-headerSubmit s-lineDownLeft">
                                <h2>Free Listings</h2>
                            </header>
                            <p>Your ad will be placed after moderator's check</p>
                            <button  type="submit" class="btn m-btn pull-right wow zoomInUp"
                                    data-wow-delay="0.3s">PUBLISH MY LISTING NOW<span class="fa fa-angle-right"></span>
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
                        <h3><a href="/autobazar">Auto<span>BAZAR</span></a></h3>
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

<script type="text/javascript">



    function nextStep(_this) {
        _this.style.display = 'none';
        var nextItem = _this.parentNode.nextElementSibling;
        nextItem.style.display = 'block';
        document.getElementById('menu-' + nextItem.id).classList.add("m-active");

        document.getElementById('menu-' + nextItem.id).getElementsByTagName('div')[0].classList.add("m-active");
    }


</script>
</body>
</html>