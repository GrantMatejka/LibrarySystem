<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/bootstrap.min.js"></script>
</head>

<body>

<div class="card-header">
    ${message}
</div>

<div class="row">
    <div class="col-2"></div>

    <div class="col">
        <div class="card">
            <div class="card-header">
                <h1>Checkout</h1>
                Confirm Reservation of <b><%=request.getParameter("bookTitle")%></b> by <b><%=request.getParameter("bookAuthor")%></b>
                <form method="post" action="checkOut.jsp">
                    <input type="hidden" name="bookId" value = <%=request.getParameter("bookAsin")%> >
                    <input type="hidden" name="userId" value = <%=request.getParameter("id")%> >
                    <button class="btn btn-primary">Confirm</button>
                </form>
                <p><a href="./search.jsp">back</a></p>
            </div>
            </div>
        </div>
    </div>

    <div class="col-2"></div>
</div>

</body>
</html>
