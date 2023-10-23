<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="students" type="org.jooq.Result<com.example.entjavame2.model.tables.records.StudentRecord>"
             scope="request"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@1/css/pico.min.css">
    <link rel="stylesheet" href="<c:url value="/css/footer.css"/>">
    <title>Deleted students - iACADEMY Student System</title>
</head>
<body>
<main class="container">
    <h1>Pending orders</h1>
    <a href="<c:url value="/"/>">Back to Home</a>
    <table role="grid">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Section</th>
            <th scope="col">Exam 1</th>
            <th scope="col">Exam 2</th>
            <th scope="col">Average</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${students}" var="student">
            <tr>
                <th scope="row">${student.id}</th>
                <td>${student.name}</td>
                <td>${student.section}</td>
                <td>${student.exam1}</td>
                <td>${student.exam2}</td>
                <td>${student.average}</td>
                <td>
                    <a href="<c:url value="/student/perma-delete/${student.id}"/>">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</main>
<%@include file="footer.jsp"%>
</body>
</html>
