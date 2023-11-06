<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
 
<%@ page isELIgnored= "false" %>

    <!-- jstl uri -->
   <%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>


 <!--responsive purpose  -->
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
</head>
<body>

<br>
<div style="text-align: center">

<h1> Signup</h1>

<form:form action="doSignup" method="POST">
<%String msg = request.getParameter("msg"); 
if(msg != null)
{%>
<p style="color: green"><%=msg %></p>
<% }%>
	<center>
	<table   border ="0" cellpadding="10" style="text-align: left;">
		<tr>
			<td><b>User Name:</b></td>
			<td><input type = "text" name="username" /></td>
		</tr>
		<tr>
			<td><b>User Password:</b></td>	<td>
		<input type= "password" name="password"/></td>
		</tr>
		<tr>
			<td><b>User Role:</b></td>
			<td>
			<b>
				<input type="radio" name="role1"  value ="ADMIN" >ADMIN  <br><br>
				<input type="radio" name="role2"  value ="NORMAL" >NORMAL  <br><br>
			</b>
				<span style="color:green">You can also select multiple Roles if you want </span><br><br>
			</td>
		</tr>
		<tr>
			<td></td>
			<td colspan = "2"><button type = "submit">Signup</button></td>
	
		
		</table>
		</center>
		
</form:form>


<br><br>
<div style="margin-right: 112px">
<form:form action="myLogin" method="GET">
			<b><input type="submit" value="Login"></b>
			</form:form>
</div>	  

</div>

</body>
</html>


