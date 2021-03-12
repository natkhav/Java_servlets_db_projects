<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Input</title>
</head>
<body>
	<h1>Add New Product</h1>
	<form action="ProductServlet" method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><input type="text" name="price" /></td>
			</tr>	
		</table>
		<br/>
		<h3>Select Category</h3>
		<select name="category" style="width: 155px"><br/>
		
			<option>Vegetables</option>
			<option>Fruits</option>
			<option>Dairy</option>
			<option>Seafood</option>
			<option>Other</option>
		</select> <br />
		<textarea name="description" cols="50" rows="5">
		Please add product description
		</textarea>
		<br/>
		<br/>
		<tr>
			<td colspan="2"><input type="submit" value="Add Product" /></td>
		</tr>
	</form>

</body>
</html>