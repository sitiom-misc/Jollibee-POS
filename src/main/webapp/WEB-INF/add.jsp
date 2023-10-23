<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@1/css/pico.min.css">
    <link rel="stylesheet" href="<c:url value="/css/footer.css"/>">
    <title>Add Student - iACADEMY Student System</title>
</head>
<body>
<main class="container">
    <h1>Add Student</h1>
    <form method="post" action="<c:url value="/success"/>">
        <label>
            Name
            <input type="text" name="name" placeholder="Name" required>
        </label>
        <label>
            Section
            <input type="text" name="section" placeholder="Section" required>
        </label>
        <label>
            Exam 1
            <input type="number" min="0" max="100" name="exam1" placeholder="100" required>
        </label>
        <label>
            Exam 2
            <input type="number" min="0" max="100" name="exam2" placeholder="100" required>
        </label>
        <input type="submit" value="Submit"/>
    </form>
    <a href="<c:url value="/"/>">Back to Home</a>
</main>
<%@include file="footer.jsp" %>
</body>
</html>
