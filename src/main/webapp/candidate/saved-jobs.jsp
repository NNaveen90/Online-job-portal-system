<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
      href="<%=request.getContextPath()%>/assets/css/style.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/common/navbar.jsp" />

<%@ page import="java.util.List" %>
<%@ page import="com.jobportal.model.Job" %>

<%
List<Job> savedJobs = (List<Job>) request.getAttribute("savedJobs");
%>

<h2>Saved Jobs</h2>

<%
if(savedJobs != null && !savedJobs.isEmpty()) {
    for(Job job : savedJobs) {
%>

<div style="border:1px solid #ccc; padding:15px; margin:10px;">
    <h3><%= job.getTitle() %></h3>
    <p><%= job.getDescription() %></p>
    <p>Location: <%= job.getLocation() %></p>
    <p>Salary: <%= job.getSalary() %></p>

    <form action="<%=request.getContextPath()%>/candidate/removeSavedJob" method="post">
        <input type="hidden" name="jobId" value="<%= job.getJobId() %>">
        <button type="submit">Remove</button>
    </form>
</div>

<%
    }
} else {
%>

<p>No saved jobs found.</p>

<%
}
%>
<jsp:include page="/common/footer.jsp" />
</body>
</html>