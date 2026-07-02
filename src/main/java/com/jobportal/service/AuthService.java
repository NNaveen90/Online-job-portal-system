package com.jobportal.service;

import com.jobportal.dao.UserDAO;
import com.jobportal.model.User;

public class AuthService {

    private UserDAO userDAO = new UserDAO();

    public User login(String email, String password) {
        return userDAO.loginUser(email, password);
    }
}