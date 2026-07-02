package com.jobportal.controller.recruiter;

import java.io.IOException;

import com.jobportal.dao.RecruiterProfileDAO;
import com.jobportal.model.RecruiterProfile;
import com.jobportal.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/recruiter/companyProfile")
public class RecruiterProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");

        RecruiterProfileDAO dao = new RecruiterProfileDAO();
        RecruiterProfile profile = dao.getProfile(user.getUserId());

        req.setAttribute("profile", profile);

        req.getRequestDispatcher("/recruiter/company-profile.jsp")
           .forward(req, resp);
    }
}