<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page isELIgnored="false"%>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="translater"/>

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
        <tr ng-repeat="car in cars">
            <td><a href="${pageContext.request.contextPath}/cars/{{car.id}}">{{car.id}}</a></td>
            <td>{{car.mark}}</td>
            <td>{{car.model}}</td>
            <td>{{car.user.id}}</td>
            <td><input type="checkbox" data-id="{{car.id}}" ng-model="car.verified" onclick="checkVerified(this)" name="verified"></td>
            <%--<c:choose>--%>
                <%--<c:when test="{{car.verified}} eq 'true'}">--%>
                    <%--<td><input onclick="checkVerified(this)" data-id="${car.id}" type="checkbox" name="verified" checked/></td>--%>
                <%--</c:when>--%>
                <%--<c:otherwise>--%>
                    <%--<td><input onclick="checkVerified(this)" data-id="${car.id}" type="checkbox" name="verified" /></td>--%>
                <%--</c:otherwise>--%>
            <%--</c:choose>--%>
            <td><a href="${pageContext.request.contextPath}/admin/cars/{{car.id}}" class="fa fa-times" aria-hidden="true" style="color: darkred"></a></td>
        </tr>
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
            method: "GET",
            url: "/autobazar/admin/checkCar/" + id,
            success: function (result) {
            }
        });
    }
    function removeCarFromList(id) {
        $.ajax({
            method: "GET",
            url: "/autobazar/admin/uncheckCar/" + id,
            success: function (result) {
            }
        });
    }
</script>

