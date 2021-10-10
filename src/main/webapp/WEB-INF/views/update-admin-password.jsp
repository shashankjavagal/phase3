<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">


<title>Change Password </title>
</head>
<body>
  <h1>Update your admin password</h1>
  

  <form action="/admin/updatepassword" method="post">
  <section class="container-fluid">
 <section class="row">
 <section class="col-12 col-sm-6 col-md-3"> 
  <div class="mb-3">
  <label  class="form-label">New Password :-</label>
      <input type="password" name="password" class="form-control">
  </div>
  
<input type="submit" class="btn btn-primary">
</section>
</section>
</section>

</form>

</body>
</html>