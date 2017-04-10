<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 28.03.2017
  Time: 16:09
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
    <title>Auto Club</title>

    <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png"/>

    <link href="css/master.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="//oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="//oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <style type="text/css">

    </style>
</head>
<body class="m-listingsTwo" data-scrolling-animations="true">

<jsp:include page="header.jsp"></jsp:include>


<section class="b-pageHeader">
    <div class="container">
        <h1 class="wow zoomInLeft" data-wow-delay="0.5s">DAHSBOARD</h1>

    </div>
</section><!--b-pageHeader-->


<div class="b-submit">
    <div class="container">
        <div class="row">
            <div class="col-lg-2 col-md-3 col-sm-4 col-xs-5">
                <div class="b-more__info wow zoomInRight" data-wow-delay="0.5s">
                    <h2 class="s-title"><a name="My ad" href="#" onclick="changeTable(this)">My ads</a></h2>
                    <h2 class="s-title"><a name="Profile settings" href="#" onclick="changeTable(this)">Settings</a>
                    </h2>
                </div>
            </div>


            <div class="col-lg-10 col-md-9 col-sm-8 col-xs-7">
                <div class="b-items">
                    <div class="b-submit__main b-items-cars">
                        <jsp:include page="myAd.jsp"></jsp:include>
                    </div>
                </div>

            </div>
        </div>
    </div>

</div>


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
<script type="text/javascript">
    function changeTable(_this) {
        var value = _this.value;
        if (_this.name == "Profile settings") {
            $.ajax({
                method: "POST",
                url: "/autobazar/controller",
                data: {"command": "ProfileSettings"},
                success: function (result) {
                    $(".b-submit__main").html(result);
                }
            });
        } else {
            $.ajax({
                method: "POST",
                url: "/autobazar/controller",
                data: {"command": "MyAd"},
                success: function (result) {
                    $(".b-submit__main").html(result);
                }
            });
        }
    }
</script>
</body>
</html>
