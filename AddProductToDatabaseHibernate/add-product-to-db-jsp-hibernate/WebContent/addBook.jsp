<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" 
	  rel="stylesheet" 
      integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" 
      crossorigin="anonymous">
</head>
<body>
 <div class="container">
 <div class="row text-center" style="color: tomato;">
  <h2>Adding New Product to Database</h2>
 </div>
 <hr>
  <div class="row col-md-10 col-md-offset-3"> 
   
   <div class="card card-body">
    <br>
    <h2>Add Book to Your Collection </h2>
    <div class="col-md-8 col-md-offset-3">

     <form action="<%=request.getContextPath()%>/register" method="post">

      <div class="form-group">
       <label for="uname">Book Title:</label> <input type="text"
        class="form-control" id="title" placeholder="Title"
        name="title" required>
      </div><br>

      <div class="form-group">
       <label for="uname">Book Author:</label> <input type="text"
        class="form-control" id="author" placeholder="Author"
        name="author" required>
      </div><br>

      <div class="form-group">
       <label for="uname">Book Genre:</label> <input type="text"
        class="form-control" id="genre" placeholder="Genre"
        name="genre" required>
      </div><br>
      
      <button type="submit" class="btn btn-primary">Submit</button>

     </form>
    </div>
   </div>
  </div>
 </div>
</body>
</html>