package com.jobportal.dao;

import java.sql.*;

import com.jobportal.model.RecruiterProfile;
import com.jobportal.util.DBConnection;

public class RecruiterProfileDAO 
{

    public RecruiterProfile getProfile(int userId) 
    {

        RecruiterProfile profile = null;

        try (Connection con = DBConnection.getConnection()) 
        {

            String sql = "SELECT * FROM recruiter_profiles WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                profile = new RecruiterProfile();

                profile.setRecruiterId(rs.getInt("recruiter_id"));
                profile.setUserId(rs.getInt("user_id"));
                profile.setCompanyName(rs.getString("company_name"));
                profile.setCompanyWebsite(rs.getString("company_website"));
                profile.setCompanyDescription(rs.getString("company_description"));
            }

        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        return profile;
    }

    public boolean updateProfile(RecruiterProfile profile) 
    {

        try (Connection con = DBConnection.getConnection()) 
        {

            String sql =
                "UPDATE recruiter_profiles " +
                "SET company_name=?, company_website=?, company_description=? " +
                "WHERE user_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, profile.getCompanyName());
            ps.setString(2, profile.getCompanyWebsite());
            ps.setString(3, profile.getCompanyDescription());
            ps.setInt(4, profile.getUserId());

            return ps.executeUpdate() > 0;

        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        return false;
    }

    public boolean createEmptyRecruiterProfile(int userId) 
    {

        try (Connection con = DBConnection.getConnection()) 
        {

            String sql = "INSERT INTO recruiter_profiles(user_id) VALUES (?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);

            return ps.executeUpdate() > 0;

        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        return false;
    }

	
}