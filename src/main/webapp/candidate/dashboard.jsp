<%@ page import="com.jobportal.model.User" %>
<%
User user = (User) session.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Candidate Dashboard</title>

<link rel="stylesheet"
      href="<%=request.getContextPath()%>/assets/css/style.css">
</head>
<body>
<jsp:include page="/common/navbar.jsp" />
<!-- 
 <div class="navbar">
    <h2>Job Portal</h2>
    <a href="<%=request.getContextPath()%>/logout">Logout</a>
</div>
 -->

<div class="dashboard-grid">

    <a class="dashboard-card" href="<%=request.getContextPath()%>/candidate/jobs">
        <h3> View Jobs</h3>
        <p>Browse latest opportunities</p>
    </a>

    <a class="dashboard-card" href="<%=request.getContextPath()%>/candidate/profile">
        <h3> My Profile</h3>
        <p>Manage personal details</p>
    </a>

    <a class="dashboard-card" href="<%=request.getContextPath()%>/candidate/myApplications">
        <h3> My Applications</h3>
        <p>Track applied jobs</p>
    </a>

    <a class="dashboard-card" href="<%=request.getContextPath()%>/candidate/savedJobs">
        <h3> Saved Jobs</h3>
        <p>View bookmarked jobs</p>
    </a>

</div>
<jsp:include page="/common/footer.jsp" />
</body>
</html>