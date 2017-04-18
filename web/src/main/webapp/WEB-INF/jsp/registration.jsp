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
<body class=m-contacts" data-scrolling-animations="true">


<jsp:include page="header.jsp"></jsp:include>


<section class="b-pageHeader">
    <div class="container">
        <h1 class=" wow zoomInLeft" data-wow-delay="0.5s">Registration page</h1>

    </div>
</section><!--b-pageHeader-->


<section class="b-contacts s-shadow">
    <div class="container">
        <div class="row">

            <div class="col-xs-7 col-md-6">
                <div class="b-contacts__form">
                    <header class="b-contacts__form-header s-lineDownLeft wow zoomInUp" data-wow-delay="0.5s">
                        <h2 class="s-titleDet">Registering</h2>
                    </header>
                    <div></div>
                    <form action="/autobazar/controller" method="post" class="s-form wow zoomInUp"
                          data-wow-delay="0.5s">
                        <input type="hidden" value="Registration" name="command"/>
                        <label>Enter login <span>*</span></label>
                        <input type="text" placeholder="YOUR LOGIN" value="" name="login" id="login" required/>
                        <label>Enter email <span>*</span></label>
                        <input type="text" placeholder="EMAIL ADDRESS" value="" name="email" id="email" required/>
                        <label>Enter password <span>*</span></label>
                        <input type="password" placeholder="PASSWORD" value="" name="password" id="password" required/>
                        <label>Confirm password <span>*</span></label>
                        <input type="password" placeholder="PASSWORD" value="" name="confirmPassword"
                               id="confirm-password" required/>
                        <label>Enter your name <span>*</span></label>
                        <input type="text" placeholder="YOUR NAME." value="" name="name" id="name" required/>
                        <label>Enter phone <span>*</span></label>
                        <input type="text" pattern="\+375\([0-9]{2}\)[0-9]{3}-[0-9]{2}-[0-9]{2}"
                               placeholder="+375(**)***-**-**" value="" name="phone" id="phone" required/>

                        <p style="color: red">${errorEmptyMessage}</p>
                        <p style="color: red">${errorRegistrationMessage}</p>

                        <button type="button" onclick="validate(this.form)" class="btn m-btn">SUBMIT NOW<span
                                class="fa fa-angle-right"></span></button>
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
<script src="js/jquery.maskedinput.min.js"></script>
<script src="js/wow.min.js"></script>
<script src="js/jquery.placeholder.min.js"></script>
<script src="js/theme.js"></script>
<script src="js/search.js"></script>
<script src="js/registration.js"></script>

</body>
</html>
