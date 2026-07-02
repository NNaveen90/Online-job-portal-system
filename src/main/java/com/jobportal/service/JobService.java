package com.jobportal.service;

import java.util.List;
import com.jobportal.dao.JobDAO;
import com.jobportal.model.Job;

public class JobService {

    private JobDAO jobDAO = new JobDAO();

    public boolean postJob(Job job) {
        return jobDAO.postJob(job);
    }

    public List<Job> getAllJobs() {
        return jobDAO.getAllJobs();
    }
}