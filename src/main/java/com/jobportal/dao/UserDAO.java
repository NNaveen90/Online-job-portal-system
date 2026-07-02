package com.jobportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jobportal.model.User;
import com.jobportal.util.DBConnection;

public class UserDAO 
{

    public int registerUser(User user) 
    {

        try (Connection con = DBConnection.getConnection()) 
        {

            String sql = "INSERT INTO users(full_name,email,password,role) VALUES (?,?,?,?)";

            PreparedStatement ps =
                con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, user.getFullName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole());

            int rows = ps.executeUpdate();

            if (rows > 0) 
            {
                ResultSet rs = ps.getGeneratedKeys();

                if (rs.next()) 
                {
                    return rs.getInt(1);
                }
            }

        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        return -1;
    }

    public User loginUser(String email, String password) 
    {

        try (Connection con = DBConnection.getConnection()) 
        {

            String sql = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) 
            {

                User u = new User();

                u.setUserId(rs.getInt("user_id"));
                u.setFullName(rs.getString("full_name"));
                u.setEmail(rs.getString("email"));
                u.setRole(rs.getString("role"));

                return u;
            }

        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        return null;
    }
}