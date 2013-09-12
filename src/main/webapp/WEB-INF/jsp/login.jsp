<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <style>
        .error {
            color: #ff0000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>
</head>
<body>
<form action="<c:url value="j_spring_security_check"/>" method="POST">
    <table>
        <c:if test="${authFailed == true}">
            <td class="error">Invalid Username/Password</td>
        </c:if>
    </table>
    <table>
        <tr>
            <td>Enter Username:</td>
            <td><input type="text" name="j_username" value=""></td>
        </tr>
        <tr>
            <td>Enter password:</td>
            <td><input type="password" name="j_password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Go"></td>
        </tr>
    </table>
</form>
</body>
</html>