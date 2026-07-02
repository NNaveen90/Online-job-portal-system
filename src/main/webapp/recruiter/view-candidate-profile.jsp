<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jobportal.model.Profile" %>

<%
Profile profile = (Profile) request.getAttribute("profile");
%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
      href="<%=request.getContextPath()%>/assets/css/style.css">
<meta charset="UTF-8">
<title>Candidate Profile</title>
</head>
<body>
<jsp:include page="/common/navbar.jsp" />
<h2>Candidate Profile</h2>

<% if(profile != null) { %>

    <p><b>Phone:</b> <%= profile.getPhone() %></p>
    <p><b>Address:</b> <%= profile.getAddress() %></p>
    <p><b>Skills:</b> <%= profile.getSkills() %></p>
    <p><b>Experience:</b> <%= profile.getExperience() %></p>

<% } else { %>

    <h3>No Profile Found</h3>

<% } %>

<br><br>

<a href="<%=request.getContextPath()%>/recruiter/applicants">
    <button>Back to Applicants</button>
</a>
<jsp:include page="/common/footer.jsp" />
</body>
</html>