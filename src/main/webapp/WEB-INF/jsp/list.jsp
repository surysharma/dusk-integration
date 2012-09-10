<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head></head>
<title>Admin List</title>

<body>
<table>

    <tr>
        The list is :
        <td>
        <c:forEach var="admin" items="${admins}">
            Admin is ${admin.username},
            <c:forEach var="sector" items="${admin.sectors}">
                sector is ${sector.name}
            </c:forEach>
        </c:forEach>
        </td>
    </tr>
</table>
</body>
</html>