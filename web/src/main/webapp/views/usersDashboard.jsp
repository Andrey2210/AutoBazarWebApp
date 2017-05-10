
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false"%>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="translater"/>
<p style="color: red">${errorMessage}</p>
<table class="bordered">
    <thead>
    <tr>
        <th>ID</th>
        <th>Login</th>
        <th>Email</th>
        <th>Name</th>
        <th>Phone</th>
        <th>Role</th>
        <th></th>
    </tr>
    </thead>
        <tr ng-repeat="user in users">
            <td>{{user.id}}</td>
            <td>{{user.login}}</td>
            <td>{{user.email}}</td>
            <td>{{user.name}}</td>
            <td>{{user.phone}}</td>
            <td>{{user.role}}</td>
            <td><a href="${pageContext.request.contextPath}/admin/users/{{user.id}}" class="fa fa-times" aria-hidden="true" style="color: darkred"></a></td>
        </tr>
</table>

