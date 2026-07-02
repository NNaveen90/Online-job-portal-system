package com.jobportal.controller.recruiter;

import java.io.IOException;
import java.util.List;

import com.jobportal.dao.JobDAO;
import com.jobportal.model.Job;
import com.jobportal.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/recruiter/manageJobs")
public class ManageJobsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");

        int recruiterId = user.getUserId();

        JobDAO dao = new JobDAO();

        // CHANGED HERE
        List<Job> jobs = dao.getJobsByRecruiter(recruiterId);

        request.setAttribute("jobs", jobs);

        request.getRequestDispatcher("/recruiter/manage-jobs.jsp")
               .forward(request, response);
    }
}