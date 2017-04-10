<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 28.03.2017
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false"%><html>
<head>
    <title>Title</title>
</head>
<body>
<div class="b-contacts__form">
    <header class="b-contacts__form-header s-lineDownLeft wow zoomInUp" data-wow-delay="0.5s">
        <h2 class="s-titleDet">Profile Settings</h2>
    </header>
    <div></div>
    <form action="/autobazar/controller" method="post" class="s-form wow zoomInUp" data-wow-delay="0.5s">
        <input type="hidden" value="ProfileSettings" name="command" />
        <label>Login <span>*</span></label>
        <input type="text"  value="${requestScope.user.login}" disabled name="login" id="login" /> <br/>
        <label>Email <span>*</span></label>
        <input type="text" value="${requestScope.user.email}" disabled name="email" id="email" /><br/>
        <label>Password <span>*</span></label>
        <input type="password" placeholder="PASSWORD" value="${requestScope.user.password}" disabled name="password1" id="password1" /> <br/>
        <label>Enter New Password <span>*</span></label>
        <input type="password" placeholder="PASSWORD" value="" name="password" id="password" /> <br/>
        <label>Confirm new password <span>*</span></label>
        <input type="password" placeholder="PASSWORD" value="" name="confirm-password" id="confirm-password" /> <br/>
        <label>Your name <span>*</span></label>
        <input type="text" placeholder="YOUR NAME." value="${requestScope.user.name}" name="name" id="name" /> <br/>
        <label>Enter phone <span>*</span></label>
        <input type="text" placeholder="YOUR PHONE." value="${requestScope.user.phone}" name="phone" id="phone" /> <br/>
        <button type="submit" class="btn m-btn">SAVE<span class="fa fa-angle-right"></span></button>
    </form>
</div>
</body>
</html>
