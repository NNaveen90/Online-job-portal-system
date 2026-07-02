<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    // If user already logged in → redirect to dashboard
    com.jobportal.model.User user =
        (com.jobportal.model.User) session.getAttribute("user");

    if (user != null) {

        String role = user.getRole();

        if ("RECRUITER".equals(role)) 
        {
            response.sendRedirect(request.getContextPath() + "/recruiter/dashboard");
        }
        else if ("CANDIDATE".equals(role)) 
        {
            response.sendRedirect(request.getContextPath() + "/candidate/jobs");
        }

        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
      href="<%=request.getContextPath()%>/assets/css/style.css">
<meta charset="UTF-8">
<title>Job Portal</title>

<!-- 
 <style>
    body {
        font-family: Arial;
        text-align: center;
        margin-top: 100px;
    }

    .btn {
        padding: 10px 20px;
        margin: 10px;
        text-decoration: none;
        background: #007bff;
        color: white;
        border-radius: 5px;
        display: inline-block;
    }

    .btn:hover {
        background: #0056b3;
    }
</style>

 -->
</head>
<body>
<jsp:include page="/common/navbar.jsp" />
<h1>Welcome to Online Job Portal</h1>

<p>Find Jobs | Post Jobs | Build Your Career</p>

<br>

<a class="btn" href="<%=request.getContextPath()%>/auth/login.jsp">Login</a>
<a class="btn" href="<%=request.getContextPath()%>/auth/register.jsp">Register</a>
<jsp:include page="/common/footer.jsp" />
</body>
</html>