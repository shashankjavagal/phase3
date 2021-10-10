<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<style> 

h1{
  margin-left:100px;
  padding:30px;
}

form{
   margin-left:80px;
}

</style>

<title>Login </title>
</head>
<body>
  <h1> Login</h1>
  ${SPRING_SECURITY_LAST_EXCEPTION.message}
  <form action="login" method="post">
  <section class="container-fluid">
 <section class="row">
 <section class="col-12 col-sm-6 col-md-3">
  <div class="mb-3">
  <label  class="form-label">Username :-</label>
      <input type="text" name="username" class="form-control">
  </div>
  
  
  <div class="mb-3">
  <label  class="form-label">Password :-</label>
      <input type="password" name="password" class="form-control">
  </div>
  
<input type="submit" class="btn btn-primary">
</section>
</section>
</section>

</form>

</body>
</html>