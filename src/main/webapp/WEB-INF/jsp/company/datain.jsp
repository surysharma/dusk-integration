<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Data In</title>
    <style type="text/css">
        .error {
            color: RED;
        }
    </style>
</head>
<%@include file="/WEB-INF/jsp/wrappers/header.jspf" %>
<body>
<c:if test="${ERROR_FLAG.name == 'ERROR_FLAG'}"><p class="error">Invalid file, Please upload again</p></c:if>
<form action="/admin/company/datain/upload" enctype="multipart/form-data" method="POST">
    <div class="data-in">

        <p> Please upload a csv file:
            <input type="file" id="upload" size="40" name="file"/>
        </p>
        <input type="submit" id="submit" value="Submit">
    </div>
</form>
</body>
</html>