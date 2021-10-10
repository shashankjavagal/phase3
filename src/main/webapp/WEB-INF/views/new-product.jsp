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

<title>Spring Boot</title>
</head>
<body>
  <h1>Add Products</h1>
  
  <form action="/admin/newproduct" method="post">
  
 <section class="container-fluid">
 <section class="row">
 <section class="col-12 col-sm-6 col-md-3">
  <div class="mb-3">
  <label  class="form-label">Product id</label>
      <input type="text" name="id" class="form-control">
  </div>
  
  
  <div class="mb-3">
  <label  class="form-label">Product Name</label>
      <input type="text" name="name" class="form-control">
  </div>
  
  
  <div class="mb-3">
  <label  class="form-label">Brand Name</label>
      <input type="text" name="brand" class="form-control">
  </div>
  
  
  <div class="mb-3">
  <label  class="form-label">Category</label>
      <input type="text" name="category" class="form-control">
  </div>
  
  
  <div class="mb-3">
  <label  class="form-label">Price</label>
      <input type="text" name="price" class="form-control">
    </div>
  </div>

<input type="submit" class="btn btn-primary">
 <span><a href="/admin/" class="btn btn-primary">Back</a></span>



</section>
</section>
</section>

</form>

  
 
        
</body>
</html>