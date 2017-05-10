
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false"%>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="translater"/>
<div class="comments">
<c:forEach var="comment" items="${requestScope.commentsList}">
    <div class="b-detail__main-aside-about-form-links">
        <a href="#" data-carId="${comment.car.getId()}" data-id="${comment.id}" onclick="onClickComment(this)" class="fa fa-times" aria-hidden="true" style="color: darkred"></a>
        <a href="#" class="j-tab m-active s-lineDownCenter" data-to="#info1">${comment.user.login}</a>
    </div>
    <div>
        <p>${comment.comment}</p>
    </div>
</c:forEach>
</div>
<script type="text/javascript">
    function onClickComment(_this) {
        var value = $(_this).data("id");
        var carId = $(_this).data("carId");
        $.ajax({
            method: "POST",
            url: "/autobazar/controller",
            data: {'id': value, "carId": carId, "command": "DeleteComment"},
            success: function (result) {
                $(".comments").html(result);
            }
        });
    }
</script>
