package com.jobportal.controller.candidate;

import java.io.IOException;
import java.util.List;

import com.jobportal.dao.SavedJobDAO;
import com.jobportal.model.Job;
import com.jobportal.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/candidate/savedJobs")
public class SavedJobsServlet extends HttpServlet 
{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException 
    {

        User user = (User) req.getSession().getAttribute("user");

        SavedJobDAO dao = new SavedJobDAO();

        List<Job> savedJobs = dao.getSavedJobsByCandidate(user.getUserId());

        req.setAttribute("savedJobs", savedJobs);

        req.getRequestDispatcher("/candidate/saved-jobs.jsp")
           .forward(req, resp);
    }
}