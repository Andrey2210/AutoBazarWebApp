<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 28.03.2017
  Time: 0:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false"%>
<html>

<body>
<header class="b-topBar">
    <div class="container wow slideInDown" data-wow-delay="0.7s">
        <div class="row">
            <div class="col-md-6 col-xs-6">
                <div class="b-topBar__tel">
                    <span class="fa fa-phone"></span>
                    +375 (44) 557-52-21
                </div>
            </div>

            <c:choose>
                <c:when test="${empty sessionScope.user}">
                    <div class="col-md-3 col-xs-6">
                        <nav class="b-topBar__nav">
                            <ul>
                                <li><a class="main-item" href="/autobazar/registration"><fmt:message key="header.register"/></a></li>
                            </ul>
                        </nav>
                    </div>
                    <div class="col-md-1 col-xs-6">
                        <div class="b-topBar__lang">
                            <div class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle='dropdown'><fmt:message key="header.signIn"/></a>
                                <ul class="dropdown-menu dropdown-menu-log">
                                    <form id="login-form" method="post" action="/autobazar/controller" >
                                        <input  type="hidden" name="command" value="Login"/>
                                        <li><input  type="text" name="login" placeholder="LOGIN/EMAIL" required=""/></li>
                                        <li><input  type="password" name="password" placeholder="PASSWORD" required=""/></li>
                                    </form>
                                    <li><a href="#" onclick="userLogin()"><fmt:message key="header.signIn"/></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="col-md-3 col-xs-6">
                        <nav class="b-topBar__nav">
                            <ul>
                                <li><a class="fa fa-user main-item" aria-hidden="true" href="/autobazar/controller?command=Profile"> ${sessionScope.user.login}</a></li>
                            </ul>
                        </nav>
                    </div>
                    <div class="col-md-1 col-xs-6">
                        <nav class="b-topBar__lang">
                            <a class="main-item" href="#" onclick="userLogout()"><fmt:message key="header.signOut"/></a>
                                <form id="logout-form" method="post" action="/autobazar/controller" style="display: none" >
                                    <input  type="hidden" name="command" value="Logout"/>
                                </form>

                        </nav>
                    </div>
                </c:otherwise>
            </c:choose>


            <div class="col-md-2 col-xs-6">
                <div class="b-topBar__lang">
                    <div class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle='dropdown'><fmt:message key="header.language"/></a>
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
                    <h2><a href="/autobazar/controller"><fmt:message key="header.logo"/></a></h2>
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
                            <li><a href="/autobazar/controller"><fmt:message key="header.home"/></a></li>
                            <li><a href="/autobazar/controller?command=Search"><fmt:message key="header.catalog"/></a></li>
                            <c:if test="${sessionScope.user.role eq 'ADMIN'}">
                                <li><a href="/autobazar/dashboard"><fmt:message key="header.dashboard"/></a></li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</nav><!--b-nav-->


</body>
</html>
