package com.jobportal.controller.recruiter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.jobportal.dao.ApplicationDAO;
import com.jobportal.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/recruiter/applicants")
public class ViewApplicantsServlet extends HttpServlet
{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");

        int recruiterId = user.getUserId();

        ApplicationDAO dao = new ApplicationDAO();

        List<Map<String, String>> applicants = dao.getApplicantsByRecruiter(recruiterId);

        req.setAttribute("applicants", applicants);

        req.getRequestDispatcher("/recruiter/applicants.jsp").forward(req, resp);
	}
}
