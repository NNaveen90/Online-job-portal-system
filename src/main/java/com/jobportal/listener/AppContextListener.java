package com.jobportal.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import com.jobportal.util.DBConnection;

@WebListener
public class AppContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Job Portal Started...");
        DBConnection.getConnection(); // initialize DB early
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Job Portal Stopped...");
    }
}