<%@ page import="java.util.List" %>
<%@ page import="com.jobportal.model.Job" %>

<%
List<Job> jobs = (List<Job>) request.getAttribute("jobs");
%>
<link rel="stylesheet"
      href="<%=request.getContextPath()%>/assets/css/style.css">
<h2>My Posted Jobs</h2>

<%
if(jobs != null && !jobs.isEmpty()) {
    for(Job job : jobs) {
%>

<div style="border:1px solid black; padding:10px; margin:10px;">

    <h3><%= job.getTitle() %></h3>
    <p><%= job.getDescription() %></p>
    <p><b>Location:</b> <%= job.getLocation() %></p>
    <p><b>Salary:</b> <%= job.getSalary() %></p>

    <a href="<%=request.getContextPath()%>/recruiter/editJob?jobId=<%=job.getJobId()%>">
        Edit
    </a>

    |

    <a href="<%=request.getContextPath()%>/recruiter/deleteJob?jobId=<%=job.getJobId()%>"
       onclick="return confirm('Delete this job?')">
        Delete
    </a>

</div>

<%
    }
} else {
%>

<h3>No Jobs Posted Yet</h3>

<%
}
%>