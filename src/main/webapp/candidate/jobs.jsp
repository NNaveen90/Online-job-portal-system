<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.jobportal.model.Job" %>
<%@ page import="com.jobportal.model.User" %>
<%@ page import="com.jobportal.dao.SavedJobDAO" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
      href="<%=request.getContextPath()%>/assets/css/style.css">
<meta charset="UTF-8">
<title>Jobs</title>
</head>
<body>
<jsp:include page="/common/navbar.jsp" />

<%
List<Job> jobs = (List<Job>) request.getAttribute("jobs");
User user = (User) session.getAttribute("user");

SavedJobDAO savedDao = new SavedJobDAO();

String success = request.getParameter("success");
String error = request.getParameter("error");

if("applied".equals(success)) {
%>
<p style="color:green;">Applied Successfully!</p>
<%
}

if("already".equals(error)) {
%>
<p style="color:red;">Already Applied!</p>
<%
}
%>

<form action="<%=request.getContextPath()%>/candidate/searchJobs" method="get">

    <input type="text" name="keyword" placeholder="Search by Title">

    <input type="text" name="location" placeholder="Search by Location">

    <button type="submit">Search</button>

    <a href="<%=request.getContextPath()%>/candidate/jobs">
        <button type="button">Reset</button>
    </a>

</form>

<br><hr><br>

<h2>Available Jobs</h2>

<%
if(jobs != null && !jobs.isEmpty()) {
    for(Job job : jobs) {
%>

<div style="border:1px solid black; padding:10px; margin:10px;">

    <h3><%= job.getTitle() %></h3>
    <p><b>Description:</b> <%= job.getDescription() %></p>
    <p><b>Location:</b> <%= job.getLocation() %></p>
    <p><b>Salary:</b> <%= job.getSalary() %></p>
    <p><b>Experience:</b> <%= job.getExperienceRequired() %></p>

    <form action="<%=request.getContextPath()%>/candidate/applyJob" method="post">
        <input type="hidden" name="jobId" value="<%= job.getJobId() %>"/>
        <button type="submit">Apply</button>
    </form>
    
    <%
boolean saved = savedDao.isJobSaved(user.getUserId(), job.getJobId());
%>

<% if(saved) { %>

    <button disabled>Saved ✓</button>

<% } else { %>

    <form action="<%=request.getContextPath()%>/candidate/saveJob" method="post" style="display:inline;">
        <input type="hidden" name="jobId" value="<%= job.getJobId() %>"/>
        <button type="submit">Save Job</button>
    </form>

<% } %>

</div>

<%
    }
} else {
%>

<h3>No Jobs Available</h3>

<%
}
%>
<jsp:include page="/common/footer.jsp" />

</body>
</html>