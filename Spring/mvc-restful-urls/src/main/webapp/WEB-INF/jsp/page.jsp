<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Spring MVC Restful Url Example Application - Page</title>
    <link rel="stylesheet" type="text/css" href="/static/css/styles.css"/>
</head>
<body>
    <h1>Page</h1>
    <!-- When the page is rendered to browser, this links points to '/home' -->
    <spring:url value="/app/home" var="homeUrl"/>
    <p><a href="${homeUrl}">Return to the home page</a>.</p>
</body>
</html>