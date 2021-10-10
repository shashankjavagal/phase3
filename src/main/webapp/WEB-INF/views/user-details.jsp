<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">



<title>Products</title>
</head>
<body>
  <h1>User Details</h1>
   <form action="" >
    Filter: <input type="text" name="username" placeholder="username"  required />
    &nbsp;
    <input type="submit" value="Search" />
   </form>
   ${message}
  <hr>
    <table border="2" width="70%" cellpadding="2">
        <tr>
            <th>Id</th>
            <th>UserName</th>
            <th>Name</th>
            <th>City</th>
            <th>PhoneNumber</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.name}</td>
                <td>${user.city}</td>
                <td>${user.phoneNumber}</td>
            </tr>
        </c:forEach>
    </table>
<br/>
<a href="/admin/">Go to Dashboard</a><br>

   

</body>
</html>