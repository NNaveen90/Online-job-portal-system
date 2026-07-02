package com.jobportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jobportal.model.Profile;
import com.jobportal.util.DBConnection;

public class ProfileDAO 
{

    public Profile getProfile(int userId) 
    {

        Profile profile = null;

        try (Connection con = DBConnection.getConnection()) 
        {

            String sql = "SELECT * FROM candidate_profiles WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                profile = new Profile();

                profile.setProfileId(rs.getInt("profile_id"));
                profile.setUserId(userId);
                profile.setPhone(rs.getString("phone"));
                profile.setAddress(rs.getString("address"));
                profile.setSkills(rs.getString("skills"));
                profile.setExperience(rs.getString("experience"));
                profile.setResumePath(rs.getString("resume_path"));
            }

        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        return profile;
    }


    public boolean updateProfile(Profile p) 
    {

        try (Connection con = DBConnection.getConnection()) 
        {

            String checkSql = "SELECT profile_id FROM candidate_profiles WHERE user_id=?";
            PreparedStatement checkPs = con.prepareStatement(checkSql);
            checkPs.setInt(1, p.getUserId());

            ResultSet rs = checkPs.executeQuery();

            if (rs.next()) 
            {

            	String updateSql =
            		    "UPDATE candidate_profiles SET phone=?, address=?, skills=?, experience=?, resume_path=? WHERE user_id=?";

                PreparedStatement ps = con.prepareStatement(updateSql);

                ps.setString(1, p.getPhone());
                ps.setString(2, p.getAddress());
                ps.setString(3, p.getSkills());
                ps.setString(4, p.getExperience());
                ps.setString(5, p.getResumePath());
                ps.setInt(6, p.getUserId());

                return ps.executeUpdate() > 0;

            }
            else 
            {

                String insertSql =
                    "INSERT INTO candidate_profiles(user_id, phone, address, skills, experience,resume_path) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

                PreparedStatement ps = con.prepareStatement(insertSql);

                ps.setInt(1, p.getUserId());
                ps.setString(2, p.getPhone());
                ps.setString(3, p.getAddress());
                ps.setString(4, p.getSkills());
                ps.setString(5, p.getExperience());
                ps.setString(6, p.getResumePath());

                return ps.executeUpdate() > 0;
            }

        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        return false;
    }


    public void createEmptyProfile(int userId) 
    {

        try (Connection con = DBConnection.getConnection()) 
        {

            String sql = "INSERT INTO candidate_profiles(user_id) VALUES (?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);

            ps.executeUpdate();

        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public Profile getProfileByUserId(int userId) 
    {

        Profile profile = null;

        try (Connection con = DBConnection.getConnection()) 
        {

            String sql = "SELECT * FROM candidate_profiles WHERE user_id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) 
            {

                profile = new Profile();

                profile.setUserId(rs.getInt("user_id"));
                profile.setPhone(rs.getString("phone"));
                profile.setAddress(rs.getString("address"));
                profile.setSkills(rs.getString("skills"));
                profile.setExperience(rs.getString("experience"));
            }

        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        return profile;
    }
}