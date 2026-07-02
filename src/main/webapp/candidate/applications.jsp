<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<%
List<Map<String, String>> applications =
    (List<Map<String, String>>) request.getAttribute("applications");
%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
      href="<%=request.getContextPath()%>/assets/css/style.css">
      
<meta charset="UTF-8">
<title>My Applications</title>
</head>
<body>
      <jsp:include page="/common/navbar.jsp" />

<h2>My Applications</h2>

<%
if(applications != null && !applications.isEmpty()) {
    for(Map<String, String> app : applications) {
%>

<div style="border:1px solid black; padding:12px; margin:10px;">

    <p><b>Job Title:</b> <%= app.get("jobTitle") %></p>
    <p><b>Location:</b> <%= app.get("location") %></p>
    <p><b>Salary:</b> <%= app.get("salary") %></p>
    <p><b>Status:</b> <%= app.get("status") %></p>

    <p><b>Interview Date:</b> <%= app.get("interviewDate") %></p>
    <p><b>Interview Time:</b> <%= app.get("interviewTime") %></p>
    <p><b>Interview Mode:</b> <%= app.get("interviewMode") %></p>

</div>

<%
    }
} else {
%>

<h3>No Applications Found</h3>

<%
}
%>
<jsp:include page="/common/footer.jsp" />
</body>
</html>