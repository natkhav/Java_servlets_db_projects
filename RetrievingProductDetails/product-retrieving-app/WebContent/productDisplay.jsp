<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Display</title>
</head>

<body>
        <table width="700px" align="center"
               style="border:1px solid #000000;">
            <tr>
                <td colspan=4 align="center"
                    style="background-color:lightgrey">
                    <b>Product Record</b></td>
            </tr>
            <tr style="background-color:lightgrey;">
                <td><b>Product ID</b></td>
                <td><b>Product Name</b></td>
                <td><b>Product Category</b></td>
            </tr>
            
            <%
                int count = 0;
                String color = "#F9EBB3";
                if (request.getAttribute("piList") != null) {
                    ArrayList al = (ArrayList) request.getAttribute("piList");
                    System.out.println(al);
                    Iterator itr = al.iterator();
                    while (itr.hasNext()) {
 
                        if ((count % 2) == 0) {
                            color = "#eeffee";
                        }
                        count++;
                        ArrayList pList = (ArrayList) itr.next();
            %>
            
            <tr style="background-color:<%=color%>;">
                <td><%=pList.get(0)%></td>
                <td><%=pList.get(1)%></td>
                <td><%=pList.get(2)%></td>
            </tr>
            
            <%}
                }
                if (count == 0) {
            %>
            <tr>
                <td colspan=4 align="center" style="background-color:#eeffee"><b>No Record Found..</b></td>
            </tr>
            <%            }
            %>
        </table>

		<div align="center">  
		<a href="index.html">Back to Product Search</a>
        </div>

</body>
</html>