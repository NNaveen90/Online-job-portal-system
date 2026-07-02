package com.jobportal.model;

public class RecruiterProfile 
{

    private int recruiterId;
    private int userId;
    private String companyName;
    private String companyWebsite;
    private String companyDescription;

    public int getRecruiterId() 
    {
        return recruiterId;
    }

    public void setRecruiterId(int recruiterId) 
    {
        this.recruiterId = recruiterId;
    }

    public int getUserId() 
    {
        return userId;
    }

    public void setUserId(int userId) 
    {
        this.userId = userId;
    }

    public String getCompanyName() 
    {
        return companyName;
    }

    public void setCompanyName(String companyName) 
    {
        this.companyName = companyName;
    }

    public String getCompanyWebsite() 
    {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) 
    {
        this.companyWebsite = companyWebsite;
    }

    public String getCompanyDescription() 
    {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) 
    {
        this.companyDescription = companyDescription;
    }
}