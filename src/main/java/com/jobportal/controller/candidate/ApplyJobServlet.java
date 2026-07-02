package com.jobportal.controller.candidate;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.jobportal.dao.ApplicationDAO;
import com.jobportal.model.User;

@WebServlet("/candidate/applyJob")
public class ApplyJobServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int jobId = Integer.parseInt(request.getParameter("jobId"));

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        ApplicationDAO dao = new ApplicationDAO();

        boolean applied = dao.applyJob(jobId, user.getUserId());

        if (applied) {
            response.sendRedirect(request.getContextPath() + "/candidate/jobs?success=applied");
        } else {
            response.sendRedirect(request.getContextPath() + "/candidate/jobs?error=already");
        }
    }
}