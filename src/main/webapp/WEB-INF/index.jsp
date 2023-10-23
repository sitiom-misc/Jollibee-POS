<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@1/css/pico.min.css">
    <link rel="stylesheet" href="<c:url value="/css/footer.css"/>">
    <title>iACADEMY Student System</title>
</head>
<body>
<main class="container">
    <h1>iACADEMY Student System</h1>
    <a href="student/add" role="button">Add Student</a>
    <a href="students" role="button" class="outline">View Students</a>
    <a href="students/deleted" role="button" class="outline">Deleted Students</a>
</main>
<%@include file="footer.jsp"%>
</body>
</html>
