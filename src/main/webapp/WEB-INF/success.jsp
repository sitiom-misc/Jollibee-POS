<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="message" scope="request" type="java.lang.String"/>
<jsp:useBean id="order" type="com.example.entjavamp1.model.tables.records.OrdersRecord"
             scope="request"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@1/css/pico.min.css">
    <link rel="stylesheet" href="css/footer.css">
    <title>Success! - Jollibee POS</title>
</head>
<body>
<main class="container">
    <h1>${message}</h1>
    <a href="<c:url value="/"/>">Back to Home</a>
    <table role="grid">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Order</th>
            <th scope="col">Qty</th>
            <th scope="col">Price</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <th scope="row">${order.id}</th>
                <td>${order.name}</td>
                <td>${order.order}</td>
                <td>${order.quantity}</td>
                <td>${order.price}</td>
            </tr>
        </tbody>
    </table>
</main>
<footer class="container">
    <ul>
        <li>
            <small>Ryan Caezar Itang</small>
        </li>
        <li>
            <small>ENTJAVA2</small>
        </li>
        <li>
            <small>Major Exam 1</small>
        </li>
    </ul>
</footer>
</body>
</html>
