package com.jobportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jobportal.model.Job;
import com.jobportal.util.DBConnection;

public class SavedJobDAO 
{
	public boolean saveJob(int candidateId, int jobId)
	{
		try(Connection con = DBConnection.getConnection())
		{
			String sql = "INSERT INTO saved_jobs(candidate_id,job_id) VALUES (?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, candidateId);
			ps.setInt(2, jobId);
			
			return ps.executeUpdate() > 0;
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean isJobSaved(int candidateId, int jobId)
	{
		try(Connection con = DBConnection.getConnection())
		{
			String sql = "SELECT 1 FROM saved_jobs WHERE candidate_id = ? AND job_id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, candidateId);
			ps.setInt(2, jobId);
			
			ResultSet rs = ps.executeQuery();
			
			return rs.next();
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Job> getSavedJobsByCandidate(int candidateId)
	{
		List<Job> list = new ArrayList<>();
		
		String sql = "SELECT j.* FROM saved_jobs s " +
	            	 "JOIN jobs j ON s.job_id = j.job_id " +
	            	 "WHERE s.candidate_id=? " +
	            	 "ORDER BY s.saved_id DESC";
		try (Connection con = DBConnection.getConnection())
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, candidateId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Job job = new Job();
				
				job.setJobId(rs.getInt("job_id"));
				job.setTitle(rs.getString("title"));
				job.setDescription(rs.getString("description"));
				job.setLocation(rs.getString("location"));
				job.setSalary(rs.getString("salary"));
				job.setExperienceRequired(rs.getString("experience_required"));
				
				list.add(job);
			}
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean removeSavedJob(int candidateId, int jobId) 
	{
		try(Connection con = DBConnection.getConnection())
		{
			String sql = "DELETE FROM saved_jobs WHERE candidate_id=? AND job_id=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, candidateId);
			ps.setInt(2, jobId);
			
			return ps.executeUpdate() > 0;
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
}
