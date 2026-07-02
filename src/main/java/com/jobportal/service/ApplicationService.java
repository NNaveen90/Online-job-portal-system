package com.jobportal.service;

import java.util.List;
import java.util.Map;

import com.jobportal.dao.ApplicationDAO;

public class ApplicationService {

    private ApplicationDAO dao = new ApplicationDAO();

    public boolean applyJob(int jobId, int candidateId) {
        return dao.applyJob(jobId, candidateId);
    }

    public List<Map<String, String>> getApplicants(int recruiterId) {
        return dao.getApplicantsByRecruiter(recruiterId);
    }
}