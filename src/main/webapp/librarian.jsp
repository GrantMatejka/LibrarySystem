
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
    <div class="card-header">
    Message: ${message}
    </div>
    <div class="card-body">
    <table>
        <thead>Users</thead>
        <tr>
            <th>id</th>
            <th>username</th>
            <th>name</th>
            <th>permissionLevel</th>
        </tr>

        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.name}</td>
                <td>${user.permissionLevel}</td>
            </tr>
        </c:forEach>
    </table>
        <table>
            <thread>CheckedOut</thread>
            <tr>
                <th>asin</th>
                <th>title</th>
                <th>totalQuantity</th>
                <th>checkedOut</th>
            </tr>
            <c:forEach items = "${checkedOut}" var = "books">
                <tr>
                    <td>${books.asin}</td>
                    <td>${books.title}</td>
                    <td>${books.totalQuantity}</td>
                    <td>${books.checkedOut}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="card-footer">
        <p><a href="./" class="btn btn-primary"><- back</a></p>
    </div>
</div>
</body>
</html>