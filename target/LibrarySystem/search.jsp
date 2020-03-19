<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/bootstrap.min.js"></script>
        <title>Search</title>
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

<div class="card-header">
    ${message}
</div>

<div class="row">
    <div class="col-1"></div>

    <div class="col">
        <div class="card">
            <div class="card-body">
                <center>
                <br/>

                 <div class="col-3">
                 <form method="post" action="search">
                     <p><label for="entry">Search Term</label><br/><input type="text" class="form-control" name="entry" id="entry" value="" placeholder="entry" size="20"></p>
                     <p><input class="btn btn-primary" type="submit"></p>
                 </form>
                 </div>
                 <table>
                 <thead>Books</thead>
                    <tr>
                        <th>title</th>
                        <th>author</th>
                        <th>category</th>
                        <th>stockCnt</th>
                        <th>Checkout</th>
                        <th>Reserve</th>
                    </tr>
                 <c:forEach items="${books}" var="book">
                    <tr>
                        <td>${book.title}</td>
                        <td>${book.author}</td>
                        <td>${book.category}</td>
                        <td>${book.stockCnt}</td>
                        <td><a href="./checkOut?bookId=${book.asin}&copyNum=${book.copyNum}&bookTitle=${book.title}&bookAuthor=${book.author}">Check Out</a></td>
                        <td><a href="./reserve?bookId=${book.asin}&$userId=${id}&bookTitle=${book.title}&bookAuthor=${book.author}">Reserve</a></td>
                    </tr>
                 </c:forEach>
                 </table>
                 <p><a href="./index.jsp">back</a></p>
                 </center>
            </div>
        </div>
    </div>

    <div class="col-1"></div>
</div>

</body>
</html>
