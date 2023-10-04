<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@1/css/pico.min.css">
    <link rel="stylesheet" href="<c:url value="/css/footer.css"/>">
    <title>Jollibee POS</title>
</head>
<body>
<main class="container">
    <h1>Jollibee POS</h1>
    <a href="order" role="button">Order now!</a>
    <a href="pending" role="button" class="outline">Pending orders</a>
    <a href="served" role="button" class="outline">Served orders</a>
</main>
<%@include file="footer.jsp"%>
</body>
</html>
