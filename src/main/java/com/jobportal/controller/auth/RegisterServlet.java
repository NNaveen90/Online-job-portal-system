package com.jobportal.controller.auth;

import java.io.IOException;

import com.jobportal.dao.ProfileDAO;
import com.jobportal.dao.RecruiterProfileDAO;
import com.jobportal.dao.UserDAO;
import com.jobportal.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet 
{

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException 
    {

        String fullName = req.getParameter("fullName").trim();
        String email = req.getParameter("email").trim();
        String password = req.getParameter("password").trim();
        String role = req.getParameter("role").trim();

        User user = new User();
        user.setFullName(fullName);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);

        UserDAO userDAO = new UserDAO();

        int userId = userDAO.registerUser(user);

        if (userId > 0) 
        {

            if ("CANDIDATE".equals(role)) 
            {
                ProfileDAO profileDAO = new ProfileDAO();
                profileDAO.createEmptyProfile(userId);
            }
            if ("RECRUITER".equals(role)) 
            {
                RecruiterProfileDAO dao = new RecruiterProfileDAO();
                dao.createEmptyRecruiterProfile(userId);
            }

            resp.sendRedirect(req.getContextPath() + "/auth/login.jsp?success=1");

        }
        else 
        {
            resp.sendRedirect(req.getContextPath() + "/auth/register.jsp?error=1");
        }
    }
}