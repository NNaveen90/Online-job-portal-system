package com.jobportal.controller.recruiter;

import java.io.IOException;

import com.jobportal.dao.JobDAO;
import com.jobportal.model.Job;
import com.jobportal.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/recruiter/postJob")
public class PostJobServlet extends HttpServlet
{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		 HttpSession session = req.getSession(false);
	        User user = (User) session.getAttribute("user");
	        
	        int recruiterId = user.getUserId();

	        String title = req.getParameter("title");
	        String description = req.getParameter("description");
	        String location = req.getParameter("location");
	        String salary = req.getParameter("salary");
	        String experience = req.getParameter("experience");
	        
	        Job job = new Job();
	        job.setRecruiterId(recruiterId);
	        job.setTitle(title);
	        job.setDescription(description);
	        job.setLocation(location);
	        job.setSalary(salary);
	        job.setExperienceRequired(experience);

	        JobDAO dao = new JobDAO();
	        boolean status = dao.postJob(job);
	        
	        if(status)
	        {
	        	resp.sendRedirect(req.getContextPath() + "/recruiter/dashboard.jsp?success=1");
	        }
	        else
	        {
	        	 resp.sendRedirect(req.getContextPath() + "/recruiter/post-job.jsp?error=1");
	        }

	}
}
