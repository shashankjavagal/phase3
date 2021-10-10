<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">



<title>Products</title>
</head>
<body>
  <h1>Select the Product To Buy</h1>
  <hr>

    <table border="2" width="70%" cellpadding="2">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Brand</th>
            <th>Category</th>
            <th>Price</th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.brand}</td>
                <td>${product.category}</td>
                <td>${product.price}</td>
                <td><a href="/purchase-product/${product.id}">Purchase Now</a></td>
            </tr>
        </c:forEach>
    </table>
<br/>
<a href="/">Logout</a>
   

</body>
</html>