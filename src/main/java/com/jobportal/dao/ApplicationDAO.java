package com.jobportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jobportal.util.DBConnection;

public class ApplicationDAO 
{

    // ================= APPLY JOB =================
    public boolean applyJob(int jobId, int candidateId) 
    {

        boolean status = false;

        try (Connection con = DBConnection.getConnection()) 
        {

            // check duplicate
            String checkSql = "SELECT 1 FROM applications WHERE job_id=? AND candidate_id=?";
            PreparedStatement checkPs = con.prepareStatement(checkSql);
            checkPs.setInt(1, jobId);
            checkPs.setInt(2, candidateId);

            ResultSet rs = checkPs.executeQuery();

            boolean alreadyApplied = rs.next();

            if (!alreadyApplied) {

                String sql = "INSERT INTO applications(job_id, candidate_id, status) VALUES (?, ?, 'APPLIED')";

                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, jobId);
                ps.setInt(2, candidateId);

                status = ps.executeUpdate() > 0;
            }

        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        return status;
    }


    // ================= GET APPLICANTS =================
    public List<Map<String, String>> getApplicantsByRecruiter(int recruiterId)
    {

        List<Map<String, String>> list = new ArrayList<>();

        String sql =
            "SELECT a.application_id, a.status, " +
            "u.user_id, u.full_name, u.email, " +
            "j.title " +
            "FROM applications a " +
            "JOIN jobs j ON a.job_id = j.job_id " +
            "JOIN users u ON a.candidate_id = u.user_id " +
            "WHERE j.recruiter_id = ? " +
            "ORDER BY a.application_id DESC";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) 
        {

            ps.setInt(1, recruiterId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) 
            {

                Map<String, String> map = new HashMap<>();

                map.put("applicationId", rs.getString("application_id"));
                map.put("candidateId", rs.getString("user_id"));
                map.put("name", rs.getString("full_name"));
                map.put("email", rs.getString("email"));
                map.put("jobTitle", rs.getString("title"));
                map.put("status", rs.getString("status"));
                list.add(map);
            }

        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        return list;
    }
    
    public boolean updateStatus(int applicationId, String statusValue) 
    {

        boolean status = false;

        try (Connection con = DBConnection.getConnection()) 
        {

            String sql = "UPDATE applications SET status=? WHERE application_id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, statusValue);
            ps.setInt(2, applicationId);

            status = ps.executeUpdate() > 0;

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }

        return status;
    }
    
    public boolean isAlreadyApplied(int jobId, int candidateId) 
    {

        boolean exists = false;

        try (Connection con = DBConnection.getConnection()) 
        {

            String sql = "SELECT 1 FROM applications WHERE job_id=? AND candidate_id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, jobId);
            ps.setInt(2, candidateId);

            ResultSet rs = ps.executeQuery();

            exists = rs.next();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }

        return exists;
    }
    
    public List<Map<String, String>> getApplicationsByCandidate(int candidateId)
    {
        List<Map<String, String>> list = new ArrayList<>();

        String sql =
            "SELECT a.application_id, a.status, " +
            "a.interview_date, a.interview_time, a.interview_mode, " +
            "j.title, j.location, j.salary " +
            "FROM applications a " +
            "JOIN jobs j ON a.job_id = j.job_id " +
            "WHERE a.candidate_id = ? " +
            "ORDER BY a.application_id DESC";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql))
        {
            ps.setInt(1, candidateId);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                Map<String, String> map = new HashMap<>();

                map.put("applicationId", rs.getString("application_id"));
                map.put("jobTitle", rs.getString("title"));
                map.put("location", rs.getString("location"));
                map.put("salary", rs.getString("salary"));
                map.put("status", rs.getString("status"));

                map.put("interviewDate", rs.getString("interview_date"));
                map.put("interviewTime", rs.getString("interview_time"));
                map.put("interviewMode", rs.getString("interview_mode"));

                list.add(map);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return list;
    }

    public boolean scheduleInterview(int applicationId, String date, String time, String mode)
    {
        boolean status = false;

        try (Connection con = DBConnection.getConnection())
        {
            String sql =
                "UPDATE applications " +
                "SET interview_date=?, interview_time=?, interview_mode=? " +
                "WHERE application_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, date);
            ps.setString(2, time);
            ps.setString(3, mode);
            ps.setInt(4, applicationId);

            status = ps.executeUpdate() > 0;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return status;
    }
    
}