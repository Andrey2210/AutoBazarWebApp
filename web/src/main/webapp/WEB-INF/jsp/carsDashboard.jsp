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
<table class="bordered">
    <thead>
    <tr>
        <th>ID</th>
        <th>Mark</th>
        <th>Model</th>
        <th>User ID</th>
        <th>Verified</th>
        <th></th>
    </tr>
    </thead>
    <c:forEach var="car" items="${requestScope.cars}">
        <tr>
            <td><a href="/autobazar/controller?command=Detail&id=${car.id}">${car.id}</a></td>
            <td>${car.mark}</td>
            <td>${car.model}</td>
            <td>${car.user.id}</td>
            <c:choose>
                <c:when test="${car.verified eq 'true'}">
                    <td><input onclick="checkVerified(this)" data-id="${car.id}" type="checkbox" name="verified" checked/></td>
                </c:when>
                <c:otherwise>
                    <td><input onclick="checkVerified(this)" data-id="${car.id}" type="checkbox" name="verified" /></td>
                </c:otherwise>
            </c:choose>
            <td><a href="/autobazar/controller?command=DeleteCar&id=${car.id}" class="fa fa-times" aria-hidden="true" style="color: darkred"></a></td>
        </tr>
    </c:forEach>
</table>
<script type="text/javascript">
     function checkVerified(element) {
        if (element.checked) {
            addCarToList($(element).data("id"));
        } else {
            removeCarFromList($(element).data("id"));
        }
    };

    function addCarToList(id) {
        $.ajax({
            method: "POST",
            url: "/autobazar/controller",
            data: {"command": "VerifiedCar", "verified": "true" , "id": id},
            success: function (result) {
                $(".b-submit__main").html(result);
            }
        });
    }
    function removeCarFromList(id) {
        $.ajax({
            method: "POST",
            url: "/autobazar/controller",
            data: {"command": "VerifiedCar", "verified": "false" , "id": id},
            success: function (result) {
                $(".b-submit__main").html(result);
            }
        });
    }
</script>

</body>

</html>
