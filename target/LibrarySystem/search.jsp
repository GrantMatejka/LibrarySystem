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

<div class="row">
    <div class="col-2"></div>

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
                    <thead>Book Results</thead>
                    <tr>
                        <th>id</th>
                        <th>username</th>
                        <th>name</th>
                        <th>permissionLevel</th>
                    </tr>

                    <c:forEach items="${books}" var="book">
                        <tr>
                            <td>${user.asin}</td>
                            <td>${user.copyNum}</td>
                            <td>${user.title}</td>
                            <td>${user.category}</td>
                        </tr>
                    </c:forEach>
                </table>
                <p><a href="./student">back</a></p>
                </center>
            </div>
        </div>
    </div>

    <div class="col-2"></div>
</div>

</body>
</html>
