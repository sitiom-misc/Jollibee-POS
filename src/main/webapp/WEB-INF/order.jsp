<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="menu" type="java.util.HashMap<java.lang.String, java.lang.Double>" scope="application"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@1/css/pico.min.css">
    <link rel="stylesheet" href="<c:url value="/css/footer.css"/>">
    <title>Order - Jollibee POS</title>
</head>
<body>
<main class="container">
    <h1>Order</h1>
    <form method="post" action="<c:url value="/success"/>">
        <label>
            Name
            <input type="text" name="name" placeholder="Name" required>
        </label>
        <label>
            Item
            <select name="item" required>
                <option value="" disabled selected>Select an item</option>
                <c:forEach items="${menu}" var="item">
                    <option value="${item.key}">${item.key} @ ${item.value}</option>
                </c:forEach>
            </select>
        </label>
        <label>
            Quantity
            <input type="number" min="1" name="qty" value="1" required>
        </label>
        <input type="submit" value="Submit" />
    </form>
    <a href="<c:url value="/"/>">Back to Home</a>
</main>
<%@include file="footer.jsp"%>
</body>
</html>
