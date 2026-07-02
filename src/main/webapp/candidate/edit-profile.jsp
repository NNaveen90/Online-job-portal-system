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
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/common/navbar.jsp" />
<h2>Edit Profile</h2>

<form action="<%=request.getContextPath()%>/candidate/updateProfile" method="post"enctype="multipart/form-data">

    Phone:
    <input type="text" name="phone" value="<%= profile.getPhone() %>"><br><br>

    Address:
    <input type="text" name="address" value="<%= profile.getAddress() %>"><br><br>

    Skills:
    <input type="text" name="skills" value="<%= profile.getSkills() %>"><br><br>

    Experience:
    <input type="text" name="experience" value="<%= profile.getExperience() %>"><br><br>
	
	Resume:
	<input type="file" name="resume"><br><br>
    <button type="submit">Save Changes</button>
    
</form>
<jsp:include page="/common/footer.jsp" />

</body>
</html>