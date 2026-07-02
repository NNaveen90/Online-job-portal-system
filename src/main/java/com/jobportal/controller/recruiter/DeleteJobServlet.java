package com.jobportal.controller.recruiter;

import java.io.IOException;

import com.jobportal.dao.JobDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/recruiter/deleteJob")
public class DeleteJobServlet extends HttpServlet 
{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException 
    {

        int jobId = Integer.parseInt(req.getParameter("jobId"));

        JobDAO dao = new JobDAO();
        dao.deleteJob(jobId);

        resp.sendRedirect(req.getContextPath() + "/recruiter/manageJobs");
    }
}