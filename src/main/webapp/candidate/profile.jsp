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
<title>My Profile</title>
</head>
<body>
<jsp:include page="/common/navbar.jsp" />

<h2>My Profile</h2>

<% if(request.getParameter("success") != null) { %>
    <p style="color:green;">Profile Updated Successfully!</p>
<% } %>

<p><b>Phone:</b> <%= profile.getPhone() %></p>
<p><b>Address:</b> <%= profile.getAddress() %></p>
<p><b>Skills:</b> <%= profile.getSkills() %></p>
<p><b>Experience:</b> <%= profile.getExperience() %></p>

<p><b>Resume:</b>
    <a href="<%=request.getContextPath()%>/uploads/<%= profile.getResumePath() %>" target="_blank">
        View Resume
    </a>
</p>
<br>

<a href="<%=request.getContextPath()%>/candidate/editProfile">
    <button>Edit Profile</button>
</a>
<jsp:include page="/common/footer.jsp" />
</body>
</html>