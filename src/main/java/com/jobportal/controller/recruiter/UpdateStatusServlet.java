package com.jobportal.controller.recruiter;

import java.io.IOException;

import com.jobportal.dao.ApplicationDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/recruiter/updateStatus")
public class UpdateStatusServlet extends HttpServlet
{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int applicationId = Integer.parseInt(req.getParameter("applicationId"));
        String statusValue = req.getParameter("status");

        ApplicationDAO dao = new ApplicationDAO();

        boolean updated = dao.updateStatus(applicationId, statusValue);

        if(updated) 
        {
            resp.sendRedirect(req.getContextPath() + "/recruiter/applicants?success=updated");
        }
        else 
        {
            resp.sendRedirect(req.getContextPath() + "/recruiter/applicants?error=failed");
        }
    }
}
