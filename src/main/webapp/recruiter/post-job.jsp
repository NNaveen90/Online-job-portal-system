<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
      href="<%=request.getContextPath()%>/assets/css/style.css">
<meta charset="UTF-8">
<title>Post Job</title>
</head>
<body>
<jsp:include page="/common/navbar.jsp" />
<h2>Post New Job</h2>

<form action="<%=request.getContextPath()%>/recruiter/postJob" method="post">

    Title: <input type="text" name="title" required><br><br>

    Description:<br>
    <textarea name="description" required></textarea><br><br>

    Location: <input type="text" name="location"><br><br>

    Salary: <input type="text" name="salary"><br><br>

    Experience Required: <input type="text" name="experience"><br><br>

    <button type="submit">Post Job</button>

</form>
<jsp:include page="/common/footer.jsp" />
</body>
</html>