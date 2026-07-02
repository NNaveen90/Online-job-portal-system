package com.jobportal.controller.recruiter;

import java.io.IOException;

import com.jobportal.dao.RecruiterProfileDAO;
import com.jobportal.model.RecruiterProfile;
import com.jobportal.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/recruiter/updateCompanyProfile")
public class UpdateRecruiterProfileServlet extends HttpServlet 
{

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException 
    {

        User user = (User) req.getSession().getAttribute("user");

        RecruiterProfile profile = new RecruiterProfile();
        profile.setUserId(user.getUserId());
        profile.setCompanyName(req.getParameter("companyName"));
        profile.setCompanyWebsite(req.getParameter("website"));
        profile.setCompanyDescription(req.getParameter("description"));

        RecruiterProfileDAO dao = new RecruiterProfileDAO();
        dao.updateProfile(profile);

        resp.sendRedirect(req.getContextPath() + "/recruiter/companyProfile");
    }
}