package com.jobportal.controller.candidate;

import java.io.IOException;

import com.jobportal.dao.SavedJobDAO;
import com.jobportal.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/candidate/removeSavedJob")
public class RemoveSavedJobServlet extends HttpServlet 
{

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException 
    {

        int jobId = Integer.parseInt(req.getParameter("jobId"));

        User user = (User) req.getSession().getAttribute("user");

        SavedJobDAO dao = new SavedJobDAO();
        dao.removeSavedJob(user.getUserId(), jobId);

        resp.sendRedirect(req.getContextPath() + "/candidate/savedJobs");
    }
}