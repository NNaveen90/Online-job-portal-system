<%@ page import="com.jobportal.model.User" %>
<%
User user = (User) session.getAttribute("user");

if(user == null){
    response.sendRedirect(request.getContextPath() + "/auth/login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
      href="<%=request.getContextPath()%>/assets/css/style.css">
<meta charset="UTF-8">
<title>Recruiter Dashboard</title>
<style>
    body{
        font-family: Arial;
        margin:40px;
    }
    .card{
        border:1px solid #ccc;
        padding:20px;
        margin:15px 0;
        border-radius:8px;
    }
    a.button{
        display:inline-block;
        padding:10px 18px;
        background:#007bff;
        color:white;
        text-decoration:none;
        border-radius:5px;
        margin-right:10px;
    }
</style>
</head>
<body>
<jsp:include page="/common/navbar.jsp" />
<h1>Welcome Recruiter: <%= user.getFullName() %></h1>

<div class="card">
    <h3>Post New Job</h3>
    <p>Create and publish job openings.</p>
    <a class="button" href="<%=request.getContextPath()%>/recruiter/post-job.jsp">Post Job</a>
</div>

<div class="card">
    <h3>Manage Posted Jobs</h3>
    <p>View and manage all your jobs.</p>
    <a class="button" href="<%=request.getContextPath()%>/recruiter/manageJobs">Manage Jobs</a>
</div>

<div class="card">
    <h3>View Applicants</h3>
    <p>Check candidates who applied.</p>
    <a class="button" href="<%=request.getContextPath()%>/recruiter/applicants">Applicants</a>
</div>

<br>

<a class="button" href="<%=request.getContextPath()%>/recruiter/companyProfile">
    Company Profile
</a>
<a class="button" href="<%=request.getContextPath()%>/logout">Logout</a>
<jsp:include page="/common/footer.jsp" />

</body>
</html>