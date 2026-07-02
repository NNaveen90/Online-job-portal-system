package com.jobportal.controller.candidate;

import java.io.IOException;

import com.jobportal.dao.SavedJobDAO;
import com.jobportal.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/candidate/saveJob")
public class SaveJobServlet extends HttpServlet
{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int jobId = Integer.parseInt(req.getParameter("jobId"));
		
		User user = (User) req.getSession().getAttribute("user");
		
		SavedJobDAO dao = new SavedJobDAO();
		
		if(!dao.isJobSaved(user.getUserId(), jobId))
		{
			dao.saveJob(user.getUserId(), jobId);
		}
		
		 resp.sendRedirect(req.getContextPath() + "/candidate/jobs");
	}
}
