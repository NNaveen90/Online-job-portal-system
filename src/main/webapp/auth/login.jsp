<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
      href="<%=request.getContextPath()%>/assets/css/style.css">
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<h2>User Login</h2>

<% if(request.getParameter("error") != null) { %>
    <p style="color:red;">Invalid Email or Password</p>
<% } %>

<form action="<%=request.getContextPath()%>/login" method="post">

    Email:
    <input type="email" name="email" required><br><br>

    Password:
    <input type="password" name="password" required><br><br>

    <button type="submit">Login</button>

</form>

<br>

<a href="<%=request.getContextPath()%>/auth/register.jsp">
    New user? Register
</a>
</body>
</html>