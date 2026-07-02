package com.jobportal.model;

public class Job 
{
	private int jobId;
    private int recruiterId;
    private String title;
    private String description;
    private String location;
    private String salary;
    private String experienceRequired;
    
    
	public int getJobId() 
	{
		return jobId;
	}
	public void setJobId(int jobId) 
	{
		this.jobId = jobId;
	}
	public int getRecruiterId() 
	{
		return recruiterId;
	}
	public void setRecruiterId(int recruiterId) 
	{
		this.recruiterId = recruiterId;
	}
	public String getTitle() 
	{
		return title;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}
	public String getDescription() 
	{
		return description;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}
	public String getLocation() 
	{
		return location;
	}
	public void setLocation(String location) 
	{
		this.location = location;
	}
	public String getSalary() 
	{
		return salary;
	}
	public void setSalary(String salary) 
	{
		this.salary = salary;
	}
	public String getExperienceRequired() 
	{
		return experienceRequired;
	}
	public void setExperienceRequired(String experienceRequired) 
	{
		this.experienceRequired = experienceRequired;
	}
    
    
}
