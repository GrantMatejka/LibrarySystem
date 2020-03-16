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
                 <label for="inputUsername" class="sr-only ">Username</label>
                 <input type="password" class="form-control mb-2" id="inputUsername" placeholder="Username">
                 <button type="submit" class="btn btn-primary mb-3">login</button>
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
