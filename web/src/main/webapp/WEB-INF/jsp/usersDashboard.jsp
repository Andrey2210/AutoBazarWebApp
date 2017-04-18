<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 28.03.2017
  Time: 0:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false"%>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="translater"/>
<html>
<body>
<p style="color: red">${errorMessage}</p>
<table class="bordered">
    <thead>
    <tr>
        <th>ID</th>
        <th>Login</th>
        <th>Email</th>
        <th>Password</th>
        <th>Name</th>
        <th>Phone</th>
        <th>Role</th>
        <th></th>
    </tr>
    </thead>
    <c:forEach var="user" items="${requestScope.users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.login}</td>
            <td>${user.email}</td>
            <td>${user.password}</td>
            <td>${user.name}</td>
            <td>${user.phone}</td>
            <td>${user.role}</td>
            <td><a href="/autobazar/controller?command=DeleteUser&id=${user.id}" class="fa fa-times" aria-hidden="true" style="color: darkred"></a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
