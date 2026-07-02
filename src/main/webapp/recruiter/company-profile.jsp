<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.jobportal.model.RecruiterProfile" %>

<%
RecruiterProfile profile =
    (RecruiterProfile) request.getAttribute("profile");
%>

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
<h2>Company Profile</h2>

<form action="<%=request.getContextPath()%>/recruiter/updateCompanyProfile" method="post">

    Company Name:
    <input type="text" name="companyName"
           value="<%= profile != null ? profile.getCompanyName() : "" %>"><br><br>

    Website:
    <input type="text" name="website"
           value="<%= profile != null ? profile.getCompanyWebsite() : "" %>"><br><br>

    Description:
    <textarea name="description"><%= profile != null ? profile.getCompanyDescription() : "" %></textarea><br><br>

    <button type="submit">Save Company Profile</button>

</form>
<jsp:include page="/common/footer.jsp" />

</body>
</html>