<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
      href="<%=request.getContextPath()%>/assets/css/style.css">
<meta charset="UTF-8">
<title>Job Applicants</title>
</head>
<body>
<jsp:include page="/common/navbar.jsp" />
<%
List<Map<String, String>> applicants =
    (List<Map<String, String>>) request.getAttribute("applicants");
%>

<h2>Job Applicants</h2>

<%
if(applicants != null && !applicants.isEmpty()) {
    for(Map<String, String> a : applicants) {
%>

<div style="border:1px solid black; padding:12px; margin:10px;">

    <p><b>Name:</b> <%= a.get("name") %></p>
    <p><b>Email:</b> <%= a.get("email") %></p>
    <p><b>Job:</b> <%= a.get("jobTitle") %></p>
    <p><b>Status:</b> <%= a.get("status") %></p>

	<a href="<%=request.getContextPath()%>/recruiter/viewCandidateProfile?candidateId=<%= a.get("candidateId") %>">
    	<button>View Profile</button>
	</a>
    <!-- ACTION FORM -->
    <form action="<%=request.getContextPath()%>/recruiter/updateStatus" method="post">

        <input type="hidden" name="applicationId" value="<%= a.get("applicationId") %>"/>

        <button type="submit" name="status" value="SHORTLISTED">Shortlist</button>
        <button type="submit" name="status" value="REJECTED">Reject</button>
        <button type="submit" name="status" value="HIRED">Hire</button>

    </form>
<br>

<h4>Schedule Interview</h4>

<form action="<%=request.getContextPath()%>/recruiter/scheduleInterview" method="post">

    <input type="hidden" name="applicationId"
           value="<%= a.get("applicationId") %>"/>

    Date:
    <input type="date" name="interviewDate" required>

    Time:
    <input type="time" name="interviewTime" required>

    Mode:
    <input type="text" name="interviewMode"
           placeholder="Online / Office / Zoom Link">

    <button type="submit">Schedule</button>

</form>

</div>

<%
    }
} else {
%>

<h3>No applicants yet</h3>

<%
}
%>
<jsp:include page="/common/footer.jsp" />
</body>
</html>