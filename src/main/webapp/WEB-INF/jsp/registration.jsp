<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head></head>
    <title>Admin Registration</title>
    <body>
        <form:form commandName="admin">
            <table>
                <tr>
                    <td>Username:</td>
                    <td><form:input path="username"/></td>
                </tr>
                <tr>
                    <td>password:</td>
                    <td><form:password path="password"/></td>
                </tr>
                    <td>Sectors:</td>
                    <td>
                        <%--<form:select path="adminSectors" multiple="true" items="${sectors}" itemValue="id" itemLabel="sectorName">--%>
                            <%----%>
                        <%--</form:select>--%>


                    </td>
                    <td>
                        <form:checkboxes path="adminSectors" items="${sectors}" itemLabel="sectorName" itemValue="id"/>
                    </td>
                    <td><input type="submit" value="Go"></td>
                </tr>

                </table>
        </form:form>
    </body>
</html>