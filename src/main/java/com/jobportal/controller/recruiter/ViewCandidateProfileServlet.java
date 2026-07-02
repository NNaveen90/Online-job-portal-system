package com.jobportal.controller.recruiter;

import java.io.IOException;

import com.jobportal.dao.ProfileDAO;
import com.jobportal.model.Profile;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/recruiter/viewCandidateProfile")
public class ViewCandidateProfileServlet extends HttpServlet 
{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException 
    {

        int candidateId = Integer.parseInt(req.getParameter("candidateId"));

        ProfileDAO dao = new ProfileDAO();

        Profile profile = dao.getProfileByUserId(candidateId);

        req.setAttribute("profile", profile);

        req.getRequestDispatcher("/recruiter/view-candidate-profile.jsp")
           .forward(req, resp);
    }
}