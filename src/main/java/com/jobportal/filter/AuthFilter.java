package com.jobportal.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();

        HttpSession session = req.getSession(false);
        boolean loggedIn = (session != null && session.getAttribute("user") != null);

        // PUBLIC PAGES ONLY
        boolean isPublic =
                uri.endsWith("login.jsp") ||
                uri.endsWith("register.jsp") ||
                uri.endsWith("login") ||
                uri.contains("/assets/") ||
                uri.contains("/css/") ||
                uri.contains("/js/") ||
                uri.contains("/images/");

        if (loggedIn || isPublic) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect(req.getContextPath() + "/auth/login.jsp");
        }
    }
}
