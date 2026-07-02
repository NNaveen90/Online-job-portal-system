package com.jobportal.controller.candidate;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.jobportal.dao.ApplicationDAO;
import com.jobportal.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/candidate/myApplications")
public class MyApplicationsServlet extends HttpServlet 
{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException 
    {

        User user = (User) req.getSession().getAttribute("user");

        ApplicationDAO dao = new ApplicationDAO();

        List<Map<String, String>> applications =
                dao.getApplicationsByCandidate(user.getUserId());

        req.setAttribute("applications", applications);

        req.getRequestDispatcher("/candidate/my-applications.jsp")
           .forward(req, resp);
    }
}