package com.jobportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jobportal.model.Job;
import com.jobportal.util.DBConnection;

public class JobDAO 
{

    // ================= POST JOB =================
    public boolean postJob(Job job) 
    {

        boolean status = false;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO jobs(recruiter_id, title, description, location, salary, experience_required) VALUES (?,?,?,?,?,?)"
             )) {

            ps.setInt(1, job.getRecruiterId());
            ps.setString(2, job.getTitle());
            ps.setString(3, job.getDescription());
            ps.setString(4, job.getLocation());
            ps.setString(5, job.getSalary());
            ps.setString(6, job.getExperienceRequired());

            int rows = ps.executeUpdate();

            status = rows > 0;

        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        return status;
    }


    // ================= GET ALL JOBS =================
    public List<Job> getAllJobs() 
    {

        List<Job> jobList = new ArrayList<>();

        String sql = "SELECT * FROM jobs ORDER BY job_id DESC";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) 
            {

                Job job = new Job();

                job.setJobId(rs.getInt("job_id"));
                job.setRecruiterId(rs.getInt("recruiter_id"));
                job.setTitle(rs.getString("title"));
                job.setDescription(rs.getString("description"));
                job.setLocation(rs.getString("location"));
                job.setSalary(rs.getString("salary"));
                job.setExperienceRequired(rs.getString("experience_required"));

                jobList.add(job);
            }

        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        return jobList;
    }
    
    public List<Job> getJobsByRecruiter(int recruiterId) 
    {

        List<Job> jobList = new ArrayList<>();

        String sql = "SELECT * FROM jobs WHERE recruiter_id=? ORDER BY job_id DESC";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) 
        {

            ps.setInt(1, recruiterId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) 
            {

                Job job = new Job();

                job.setJobId(rs.getInt("job_id"));
                job.setRecruiterId(rs.getInt("recruiter_id"));
                job.setTitle(rs.getString("title"));
                job.setDescription(rs.getString("description"));
                job.setLocation(rs.getString("location"));
                job.setSalary(rs.getString("salary"));
                job.setExperienceRequired(rs.getString("experience_required"));

                jobList.add(job);
            }

        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        return jobList;
    }
    
    public boolean deleteJob(int jobId) 
    {

        boolean status = false;

        try (Connection con = DBConnection.getConnection()) 
        {

            String sql = "DELETE FROM jobs WHERE job_id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, jobId);

            status = ps.executeUpdate() > 0;

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }

        return status;
    }
    
    public Job getJobById(int jobId) {

        Job job = null;

        try (Connection con = DBConnection.getConnection()) {

            String sql = "SELECT * FROM jobs WHERE job_id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, jobId);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                job = new Job();

                job.setJobId(rs.getInt("job_id"));
                job.setTitle(rs.getString("title"));
                job.setDescription(rs.getString("description"));
                job.setLocation(rs.getString("location"));
                job.setSalary(rs.getString("salary"));
                job.setExperienceRequired(rs.getString("experience_required"));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return job;
    }
    
    public boolean updateJob(Job job) 
    {

        boolean status = false;

        try (Connection con = DBConnection.getConnection()) 
        {

            String sql = "UPDATE jobs SET title=?, description=?, location=?, salary=?, experience_required=? WHERE job_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, job.getTitle());
            ps.setString(2, job.getDescription());
            ps.setString(3, job.getLocation());
            ps.setString(4, job.getSalary());
            ps.setString(5, job.getExperienceRequired());
            ps.setInt(6, job.getJobId());

            status = ps.executeUpdate() > 0;

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }

        return status;
    }
    
    public List<Job> searchJobs(String keyword, String location) 
    {

        List<Job> jobList = new ArrayList<>();

        String sql =
            "SELECT * FROM jobs " +
            "WHERE title LIKE ? AND location LIKE ? " +
            "ORDER BY job_id DESC";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) 
        {

            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + location + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) 
            {

                Job job = new Job();

                job.setJobId(rs.getInt("job_id"));
                job.setRecruiterId(rs.getInt("recruiter_id"));
                job.setTitle(rs.getString("title"));
                job.setDescription(rs.getString("description"));
                job.setLocation(rs.getString("location"));
                job.setSalary(rs.getString("salary"));
                job.setExperienceRequired(rs.getString("experience_required"));

                jobList.add(job);
            }

        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        return jobList;
    }
    
}