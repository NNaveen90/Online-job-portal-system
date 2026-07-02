package com.jobportal.controller.candidate;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.jobportal.dao.JobDAO;
import com.jobportal.model.Job;

@WebServlet("/candidate/jobs")
public class ViewJobsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        JobDAO dao = new JobDAO();
        List<Job> jobs = dao.getAllJobs();

        request.setAttribute("jobs", jobs);

        request.getRequestDispatcher("/candidate/jobs.jsp").forward(request, response);
    }
}