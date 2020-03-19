
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/bootstrap.min.js"></script>

    <title>Customers</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }
        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
<div class="card">

    <div class="card-body">
    <table>
        <thead>Currently Checked Out Books</thead>
        <tr>
            <th>title</th>
            <th>author</th>
            <th>asin</th>
        </tr>

        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.asin}</td>
            </tr>
        </c:forEach>
    </table>
    </div>
    <div class="card-footer">
        <p><a href="./search.jsp"  class="btn btn-primary">Search Page</a></p>
        <p><a href="./" class="btn btn-primary"><- back</a></p>
    </div>
</div>
</body>
</html>