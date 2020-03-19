
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
        <thead>Months</thead>
        <tr>
            <th>Jan</th>
            <th>Feb</th>
            <th>Mar</th>
            <th>April</th>
            <th>May</th>
            <th>June</th>
            <th>July</th>
            <th>August</th>
            <th>Sept</th>
            <th>Oct</th>
            <th>Nov</th>
            <th>Dec</th>
            <th>Total</th>
        </tr>
        <tr>
        <c:forEach items="${months}" var="month">

                <td>${month}</td>

        </c:forEach>
        </tr>
    </table>
        <table>
            <thread>CheckedOut</thread>
            <tr>
                <th>ASIN</th>
                <th>title</th>
                <th>userId</th>
                <th>checkOutDate</th>
                <th>expectedCheckInDate</th>
            </tr>
            <c:forEach items = "${books}" var = "books">
                <tr>
                    <td>${books.ASIN}</td>
                    <td>${books.title}</td>
                    <td>${books.userId}}</td>
                    <td>${books.checkOutDate}</td>
                    <td>${books.expectedCheckInDate}</td>

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