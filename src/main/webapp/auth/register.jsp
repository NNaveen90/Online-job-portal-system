<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
      href="<%=request.getContextPath()%>/assets/css/style.css">
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
<h2>User Registration</h2>

<% if(request.getParameter("error") != null) { %>
    <p style="color:red;">Registration Failed</p>
<% } %>

<form action="<%=request.getContextPath()%>/register" method="post">

    Full Name:
    <input type="text" name="fullName" required><br><br>

    Email:
    <input type="email" name="email" required><br><br>

    Password:
    <input type="password" name="password" required><br><br>

    Role:
    <select name="role">
        <option value="CANDIDATE">Candidate</option>
        <option value="RECRUITER">Recruiter</option>
    </select><br><br>

    <button type="submit">Register</button>

</form>

<br>

<a href="<%=request.getContextPath()%>/auth/login.jsp">
    Already have account? Login
</a>
</body>
</html>