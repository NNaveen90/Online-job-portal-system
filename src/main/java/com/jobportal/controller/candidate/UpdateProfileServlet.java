package com.jobportal.controller.candidate;

import java.io.IOException;

import com.jobportal.dao.ProfileDAO;
import com.jobportal.model.Profile;
import com.jobportal.model.User;
import com.jobportal.util.FileUploadUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/candidate/updateProfile")
@MultipartConfig
public class UpdateProfileServlet extends HttpServlet 
{

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException 
    {

        User user = (User) req.getSession().getAttribute("user");
        
        Profile profile = new Profile();
        profile.setUserId(user.getUserId());
        
        profile.setPhone(req.getParameter("phone"));
        profile.setAddress(req.getParameter("address"));
        profile.setSkills(req.getParameter("skills"));
        profile.setExperience(req.getParameter("experience"));
        
        Part filePart = req.getPart("resume");
        
        if (filePart != null && filePart.getSize() > 0) {

            String uploadPath =
                getServletContext().getRealPath("") + "uploads";

            String fileName =
                FileUploadUtil.uploadFile(filePart, uploadPath);

            profile.setResumePath(fileName);
        }

        ProfileDAO dao = new ProfileDAO();
        dao.updateProfile(profile);

        
        resp.sendRedirect(req.getContextPath() + "/candidate/profile?success=1");
    }
}