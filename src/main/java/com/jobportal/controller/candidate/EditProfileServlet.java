package com.jobportal.controller.candidate;

import java.io.IOException;

import com.jobportal.dao.ProfileDAO;
import com.jobportal.model.Profile;
import com.jobportal.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/candidate/editProfile")
public class EditProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");

        ProfileDAO dao = new ProfileDAO();
        Profile profile = dao.getProfile(user.getUserId());

        req.setAttribute("profile", profile);

        req.getRequestDispatcher("/candidate/edit-profile.jsp")
           .forward(req, resp);
    }
}