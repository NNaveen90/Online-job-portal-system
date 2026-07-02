<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.jobportal.model.Job" %>

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
<%
Job job = (Job) request.getAttribute("job");
%>

<h2>Edit Job</h2>

<form action="<%=request.getContextPath()%>/recruiter/editJob" method="post">

    <input type="hidden" name="jobId" value="<%=job.getJobId()%>">

    Title:
    <input type="text" name="title" value="<%=job.getTitle()%>"><br><br>

    Description:
    <textarea name="description"><%=job.getDescription()%></textarea><br><br>

    Location:
    <input type="text" name="location" value="<%=job.getLocation()%>"><br><br>

    Salary:
    <input type="text" name="salary" value="<%=job.getSalary()%>"><br><br>

    Experience:
    <input type="text" name="experience" value="<%=job.getExperienceRequired()%>"><br><br>

    <button type="submit">Update Job</button>

</form>
<jsp:include page="/common/footer.jsp" />

</body>
</html>