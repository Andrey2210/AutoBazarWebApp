<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 21.03.2017
  Time: 23:03
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
<body class=m-contacts" data-scrolling-animations="true">


<header class="b-topBar">
    <div class="container wow slideInDown" data-wow-delay="0.7s">
        <div class="row">
            <div class="col-md-7 col-xs-6">
                <div class="b-topBar__tel">
                    <span class="fa fa-phone"></span>
                    +375 (44) 557-52-21
                </div>
            </div>

            <c:choose>
                <c:when test="${empty sessionScope.user}">
                    <div class="col-md-2 col-xs-6">
                        <nav class="b-topBar__nav">
                            <ul>
                                <li><a class="main-item" href="/autobazar/registration">Register</a></li>
                            </ul>
                        </nav>
                    </div>
                    <div class="col-md-1 col-xs-6">
                        <div class="b-topBar__lang">
                            <div class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle='dropdown'>SIGN IN</a>
                                <ul class="dropdown-menu dropdown-menu-log">
                                    <form id="login-form" method="post" action="/autobazar/controller">
                                        <input type="hidden" name="command" value="Login"/>
                                        <li><input type="text" name="login" placeholder="LOGIN/EMAIL" required=""/></li>
                                        <li><input type="password" name="password" placeholder="PASSWORD" required=""/>
                                        </li>
                                    </form>
                                    <li><a href="#" onclick="userLogin()">SIGN IN</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="col-md-3 col-xs-6">
                        <nav class="b-topBar__nav">
                            <ul>
                                <form id="logout-form" method="post" action="/autobazar/controller" style="display: none">
                                    <input type="hidden" name="command" value="Logout"/>
                                </form>
                                <li><a class="main-item" href="#" onclick="userLogout()">Sign Out</a></li>
                            </ul>
                        </nav>
                    </div>
                </c:otherwise>
            </c:choose>


            <div class="col-md-2 col-xs-6">
                <div class="b-topBar__lang">
                    <div class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle='dropdown'>Language</a>
                        <a class="m-langLink dropdown-toggle" data-toggle='dropdown' href="#"><span
                                class="b-topBar__lang-flag m-en"></span><span class="fa fa-caret-down"></span></a>
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
                    <h3><a href="/autobazar/controller">Auto<span>BAZAR</span></a></h3>
                    <h2><a href="/autobazar/controller">sell your car with us</a></h2>
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
                            <li><a href="/autobazar/controller">Home</a></li>
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
        <h1 class=" wow zoomInLeft" data-wow-delay="0.5s">Car Details </h1>
    </div>
</section><!--b-pageHeader-->


<section class="b-detail s-shadow">
    <div class="container">
        <header class="b-detail__head s-lineDownLeft wow zoomInUp" data-wow-delay="0.5s"
                style="visibility: visible; animation-delay: 0.5s; animation-name: zoomInUp;">
            <div class="row">
                <div class="col-sm-9 col-xs-12">
                    <div class="b-detail__head-title">
                        <h1>${requestScope.car.mark} ${requestScope.car.model} ${requestScope.car.year.getYear()}</h1>
                    </div>
                </div>
                <div class="col-sm-3 col-xs-12">
                    <div class="b-detail__head-price">
                        <div class="b-detail__head-price-num">$${requestScope.car.price}</div>
                    </div>
                </div>
            </div>
        </header>
        <div class="b-detail__main">
            <div class="row">
                <div class="col-md-8 col-xs-12">
                    <div class="b-detail__main-info">
                        <div class="b-detail__main-info-images wow zoomInUp" data-wow-delay="0.5s"
                             style="visibility: visible; animation-delay: 0.5s; animation-name: zoomInUp;">
                            <div class="b-detail__main-info-images wow zoomInUp" data-wow-delay="0.5s">
                                <div class="row m-smallPadding">
                                    <div class="col-xs-10">
                                        <ul class="b-detail__main-info-images-big bxslider enable-bx-slider"
                                            data-pager-custom="#bx-pager" data-mode="horizontal" data-pager-slide="true"
                                            data-mode-pager="vertical" data-pager-qty="5">
                                            <li class="s-relative">
                                                <img class="img-responsive center-block" src="${requestScope.car.image}"
                                                     alt="nissan"/>
                                            </li>

                                        </ul>
                                    </div>

                                </div>
                            </div>
                        </div>

                        <div class="b-detail__main-info-text wow zoomInUp" data-wow-delay="0.5s"
                             style="visibility: visible; animation-delay: 0.5s; animation-name: zoomInUp;">
                            <div class="b-detail__main-aside-about-form-links">
                                <a href="#" class="j-tab m-active s-lineDownCenter" data-to="#info1">FROM THE OWNER</a>
                            </div>
                            <div id="info1">
                                <p>${requestScope.car.description}</p>
                            </div>
                        </div>
                        <c:if test="${not empty sessionScope.user}">
                            <div class="b-detail__main-info-extra wow zoomInUp" data-wow-delay="0.5s"
                                 style="visibility: visible; animation-delay: 0.5s; animation-name: zoomInUp;">
                                <h2 class="s-titleDet">Questions and discussion</h2>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="b-detail__main-aside wow zoomInUp" data-wow-delay="0.5s">
                                            <div class="b-detail__main-aside-about-form">
                                                <form id="form1" action="javascript:void(null);" onsubmit="sendMessage()" method="post">
                                                   <input type="hidden" name="carId" value="${requestScope.car.id}"/>
                                                   <input type="hidden" name="userId" value="${sessionScope.user.id}"/>
                                                    <textarea name="comment" placeholder="message"></textarea>
                                                    <button type="submit" class="btn m-btn">SEND MESSAGE<span
                                                            class="fa fa-angle-right"></span></button>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                        <div id="results" class="b-detail__main-info-text wow zoomInUp" data-wow-delay="0.5s"
                             style="visibility: visible; animation-delay: 0.5s; animation-name: zoomInUp;">
                            <jsp:include page="comments.jsp"></jsp:include>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-xs-12">
                    <aside class="b-detail__main-aside">
                        <div class="b-detail__main-aside-desc wow zoomInUp" data-wow-delay="0.5s"
                             style="visibility: visible; animation-delay: 0.5s; animation-name: zoomInUp;">
                            <h2 class="s-titleDet">Description</h2>
                            <div class="row">
                                <div class="col-xs-6">
                                    <h4 class="b-detail__main-aside-desc-title">Make</h4>
                                </div>
                                <div class="col-xs-6">
                                    <p class="b-detail__main-aside-desc-value">${requestScope.car.mark}</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-6">
                                    <h4 class="b-detail__main-aside-desc-title">Model</h4>
                                </div>
                                <div class="col-xs-6">
                                    <p class="b-detail__main-aside-desc-value">${requestScope.car.model}</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-6">
                                    <h4 class="b-detail__main-aside-desc-title">Kilometres</h4>
                                </div>
                                <div class="col-xs-6">
                                    <p class="b-detail__main-aside-desc-value">${requestScope.car.conditions.milleage}
                                        km</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-6">
                                    <h4 class="b-detail__main-aside-desc-title">Body Type</h4>
                                </div>
                                <div class="col-xs-6">
                                    <p class="b-detail__main-aside-desc-value">${requestScope.car.bodyType}</p>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-xs-6">
                                    <h4 class="b-detail__main-aside-desc-title">Engine</h4>
                                </div>
                                <div class="col-xs-6">
                                    <p class="b-detail__main-aside-desc-value">${requestScope.car.characteristics.engineCapacity} </p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-6">
                                    <h4 class="b-detail__main-aside-desc-title">Drivetrain</h4>
                                </div>
                                <div class="col-xs-6">
                                    <p class="b-detail__main-aside-desc-value">${requestScope.car.characteristics.driving}</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-6">
                                    <h4 class="b-detail__main-aside-desc-title">Transmission</h4>
                                </div>
                                <div class="col-xs-6">
                                    <p class="b-detail__main-aside-desc-value">${requestScope.car.transmission}</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-6">
                                    <h4 class="b-detail__main-aside-desc-title">Exterior Color</h4>
                                </div>
                                <div class="col-xs-6">
                                    <p class="b-detail__main-aside-desc-value">${requestScope.car.additions.carColor}</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-6">
                                    <h4 class="b-detail__main-aside-desc-title">Interior color</h4>
                                </div>
                                <div class="col-xs-6">
                                    <p class="b-detail__main-aside-desc-value">${requestScope.car.additions.interiorColor}</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-6">
                                    <h4 class="b-detail__main-aside-desc-title">Interior material</h4>
                                </div>
                                <div class="col-xs-6">
                                    <p class="b-detail__main-aside-desc-value">${requestScope.car.additions.interiorMaterial}</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-6">
                                    <h4 class="b-detail__main-aside-desc-title">Doors</h4>
                                </div>
                                <div class="col-xs-6">
                                    <p class="b-detail__main-aside-desc-value">${requestScope.car.characteristics.doorsNumber}
                                        Doors</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-6">
                                    <h4 class="b-detail__main-aside-desc-title">Fuel Type</h4>
                                </div>
                                <div class="col-xs-6">
                                    <p class="b-detail__main-aside-desc-value">${requestScope.car.characteristics.fuelType}</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-6">
                                    <h4 class="b-detail__main-aside-desc-title">Condition </h4>
                                </div>
                                <div class="col-xs-6">
                                    <p class="b-detail__main-aside-desc-value">${requestScope.car.conditions.carCondition}</p>
                                </div>
                            </div>
                        </div>
                        <div class="b-detail__main-aside-about wow zoomInUp" data-wow-delay="0.5s"
                             style="visibility: visible; animation-delay: 0.5s; animation-name: zoomInUp;">
                            <h2 class="s-titleDet">CONTACTS</h2>
                            <div class="b-detail__main-aside-about-call">
                                <span class="fa fa-phone"></span>
                                <div>${requestScope.car.user.phone}</div>
                            </div>
                            <div class="b-detail__main-aside-about-seller">
                                <p>Seller Info:
                                    <span>${requestScope.car.user.name}, ${requestScope.car.locations.city}</span></p>
                            </div>
                        </div>

                    </aside>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="b-related m-home">
    <div class="container">
        <h5 class="s-titleBg wow zoomInUp" data-wow-delay="0.5s"
            style="visibility: visible; animation-delay: 0.5s; animation-name: zoomInUp;">FIND OUT MORE</h5><br>
        <h2 class="s-title wow zoomInUp" data-wow-delay="0.5s"
            style="visibility: visible; animation-delay: 0.5s; animation-name: zoomInUp;">LATEST VEHICLES ON SALE</h2>
        <div class="row">
            <c:forEach var="car" items="${requestScope.list}">
                <div class="col-md-3 col-sm-12">
                    <div class="b-auto__main-item wow zoomInUp" data-wow-delay="0.3s">
                        <img class="img-responsive center-block" src="${car.image}"/>
                        <div class="b-world__item-val">
                            <span class="b-world__item-val-title">REGISTERED <span>${car.year.getYear()}</span></span>
                        </div>
                        <h2><a href="/autobazar/controller?command=Detail&id=${car.id}">${car.mark} ${car.model}</a></h2>
                        <div class="b-auto__main-item-info">
												<span class="m-price">
													$${car.price}
												</span>
                            <span class="m-number">
													<span class="fa fa-tachometer"></span>35,000 KM
												</span>
                        </div>
                        <div class="b-featured__item-links m-auto">
                            <a href="#">Used</a>
                            <a href="#">${car.year.getYear()}</a>
                            <a href="#">${car.transmission}</a>
                            <a href="#">Black</a>
                            <a href="#">Petrol</a>
                        </div>
                    </div>
                </div>
            </c:forEach>

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

<script type="text/javascript" language="javascript">
    function sendMessage() {
        var msg   = $('#form1').serialize();
        $.ajax({
            type: 'POST',
            url: '/autobazar/controller?command=Comment',
            data: msg,
            success: function(data) {
                $('#results').html(data);
            },
            error:  function(xhr, str){
                alert('Возникла ошибка: ' + xhr.responseCode);
            }
        });

    }
</script>
</body>
</html>
