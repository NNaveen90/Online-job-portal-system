package com.jobportal.controller.auth;

import java.io.IOException;

import com.jobportal.dao.UserDAO;
import com.jobportal.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		String email = req.getParameter("email");
        String password = req.getParameter("password");
        
        UserDAO dao = new UserDAO();
        
        User user = dao.loginUser(email, password);
        
        if (user != null)
        {
        	HttpSession session = req.getSession();
        	session.setAttribute("user", user);
        	
        	String role = user.getRole();
        	
        	if ("ADMIN".equals(role))
        	{
        		resp.sendRedirect(req.getContextPath() + "/admin/dashboard.jsp");
        	}
        	else if("RECRUITER".equals(role))
        	{
        		resp.sendRedirect(req.getContextPath() + "/recruiter/dashboard.jsp");
        	}
        	else
        	{
        		resp.sendRedirect(req.getContextPath() + "/candidate/dashboard.jsp");
        	}
        }
        else
        {
        	resp.sendRedirect(req.getContextPath() + "/auth/login.jsp?error=1");
        }

	}
}
