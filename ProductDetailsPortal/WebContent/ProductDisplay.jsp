<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.model.Product"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Display</title> 
</head>
<body>

<%

Product p = (Product) session.getAttribute("product");
out.print("<h2> Here is your entry:  <h2>");
out.println("Product name: " + p.getName());
out.println("<br/>Price: " + p.getPrice());
out.println("<br/>Description: <br/>" + p.getDescription());
%>

</body>
</html>