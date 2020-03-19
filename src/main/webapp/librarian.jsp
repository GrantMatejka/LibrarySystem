
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
        <div class="col-3">
            <form method="post" action="librarian">
                <p><label for="check_in_user">Check In USER ID</label><br/><input type="text" class="form-control" name="check_in_user" id="check_in_user" value="" placeholder="user_id" size="20"></p>
                <p><label for="check_in_book">Check In BOOK ID</label><br/><input type="text" class="form-control" name="check_in_book" id="check_in _book" value="" placeholder="book_id" size="20"></p>
                <p><label for="check_out_user">Check Out USER ID</label><br/><input type="text" class="form-control" name="check_out_user" id="check_out_user" value="" placeholder="user_id" size="20"></p>
                <p><label for="check_out_book">Check Out BOOK ID</label><br/><input type="text" class="form-control" name="check_out_book" id="check_out _book" value="" placeholder="book_id" size="20"></p>


                <p><input class="btn btn-primary" type="submit" ></p>
            </form>
        </div>

    </div>
    <div class="card-footer">
        <p><a href="./" class="btn btn-primary"><- back</a></p>
    </div>
</div>
</body>
</html>