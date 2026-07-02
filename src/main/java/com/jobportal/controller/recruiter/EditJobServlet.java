package com.jobportal.controller.recruiter;

import java.io.IOException;

import com.jobportal.dao.JobDAO;
import com.jobportal.model.Job;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/recruiter/editJob")
public class EditJobServlet extends HttpServlet 
{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException 
    {

        int jobId = Integer.parseInt(req.getParameter("jobId"));

        JobDAO dao = new JobDAO();
        Job job = dao.getJobById(jobId);

        req.setAttribute("job", job);

        req.getRequestDispatcher("/recruiter/edit-job.jsp")
           .forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException 
    {

        Job job = new Job();

        job.setJobId(Integer.parseInt(req.getParameter("jobId")));
        job.setTitle(req.getParameter("title"));
        job.setDescription(req.getParameter("description"));
        job.setLocation(req.getParameter("location"));
        job.setSalary(req.getParameter("salary"));
        job.setExperienceRequired(req.getParameter("experience"));

        JobDAO dao = new JobDAO();
        dao.updateJob(job);

        resp.sendRedirect(req.getContextPath() + "/recruiter/manageJobs");
    }
}