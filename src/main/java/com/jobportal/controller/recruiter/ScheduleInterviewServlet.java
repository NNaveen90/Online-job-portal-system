package com.jobportal.controller.recruiter;

import java.io.IOException;

import com.jobportal.dao.ApplicationDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/recruiter/scheduleInterview")
public class ScheduleInterviewServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        int applicationId =
            Integer.parseInt(req.getParameter("applicationId"));

        String date = req.getParameter("interviewDate");
        String time = req.getParameter("interviewTime");
        String mode = req.getParameter("interviewMode");

        ApplicationDAO dao = new ApplicationDAO();

        dao.scheduleInterview(applicationId, date, time, mode);

        resp.sendRedirect(req.getContextPath() + "/recruiter/applicants");
    }
}