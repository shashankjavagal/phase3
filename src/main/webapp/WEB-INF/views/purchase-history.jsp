<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">



<title>Order</title>
</head>
<body>
  <h1>Purchase Reports</h1>
  <form action="" >
    Filter: <input type="text" name="category" placeholder="category"  required />
    &nbsp;
    <input type="date" name="date"   required />
    &nbsp;
    <input type="submit" value="Search" />
   </form>
   <br>
   ${message}
  <hr>

    <table border="2" width="70%" cellpadding="2">
        <tr>
            <th>Order Id</th>
            <th>User Name</th>
            <th>Product Name</th>
            <th>Order Date</th>
            <th>Category</th>
        </tr>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td>${order.orderId}</td>
                <td>${order.user.name}</td>
                <td>${order.product.name}</td>
                <td>${order.date}</td>
                <td>${order.product.category}</td>
            </tr>
        </c:forEach>
    </table>

<br/>
<a href="/admin/">Back</a>
   

</body>
</html>