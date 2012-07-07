<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head></head>
    <title>Admin Registration</title>
    <body>
        <form:form commandName="admin">
            <table>
                <tr>
                    <td>Username:</td>
                    <td><form:input path="username"/></td>
                    <td><form:errors path="username" cssStyle="color: red;"/></td>
                </tr>
                <tr>
                    <td>password:</td>
                    <td><form:password path="password"/></td>
                    <td><form:errors path="password" cssStyle="color: red;"/></td>
                </tr>
                    <td></td>
                    <td><input type="submit" value="Go"></td>
                </tr>

                </table>
        </form:form>
    </body>
</html>