<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="orders" type="java.util.List<com.example.entjava2me3.models.Order>"
             scope="request"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@1/css/pico.min.css">
    <link rel="stylesheet" href="<c:url value="/css/footer.css"/>">
    <title>Served orders - Jollibee POS</title>
</head>
<body>
<main class="container">
    <h1>Served orders</h1>
    <a href="<c:url value="/"/>">Back to Home</a>
    <table role="grid">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Order</th>
            <th scope="col">Qty</th>
            <th scope="col">Price</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${orders}" var="order">
            <tr>
                <th scope="row">${order.id}</th>
                <td>${order.name}</td>
                <td>${order.item}</td>
                <td>${order.quantity}</td>
                <td>${order.price}</td>
                <td><a href="<c:url value="/print/${order.id}"/>">Print receipt</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</main>
<%@include file="footer.jsp"%>
</body>
</html>
