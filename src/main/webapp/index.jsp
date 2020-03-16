<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/bootstrap.min.js"></script>
</head>

<body>

<div class="row">
    <div class="col-2"></div>

    <div class="col">
        <div class="card">
            <div class="card-header">
                <h1>Welcome to our library management system</h1>

            </div>
            <div class="card-body">
                <center>
                <br/>

                 <div class="col-3">
                 <form method="post" action="login">
                     <p><label for="name">User Name</label><br/><input type="text" class="form-control" name="name" id="name" value="" placeholder="username" size="20"></p>
                     <!--<p><label for="pass">Password</label><input type="password" class="form-control" name="pass" id="pass" value="" placeholder="password" size="20"></p>-->
                     <p><input class="btn btn-primary" type="submit"></p>
                 </form>
                </div>

                <p><a href="./users">hard link to users</a></p>
                </center>
            </div>
        </div>
    </div>

    <div class="col-2"></div>
</div>

</body>
</html>
