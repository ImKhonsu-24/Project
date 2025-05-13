<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Thời gian online</title>
</head>
<body>
    <h2>Bạn đã online: <c:out value="${sessionScope.onlineTime}"/> giây</h2>

    <c:if test="${sessionScope.onlineTime > 60}">
        <p style="color: red;">Bạn đã ở lại hơn 1 phút!</p>
    </c:if>
</body>
</html>
