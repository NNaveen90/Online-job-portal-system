package com.jobportal.controller.candidate;

import java.io.IOException;
import java.util.List;

import com.jobportal.dao.JobDAO;
import com.jobportal.model.Job;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/candidate/searchJobs")
public class SearchJobServlet extends HttpServlet 
{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException 
    {

        String keyword = req.getParameter("keyword");
        String location = req.getParameter("location");

        JobDAO dao = new JobDAO();

        List<Job> jobs = dao.searchJobs(
            keyword == null ? "" : keyword,
            location == null ? "" : location
        );

        req.setAttribute("jobs", jobs);

        req.getRequestDispatcher("/candidate/jobs.jsp")
           .forward(req, resp);
    }
}