package com.cisc181.core;

import java.util.UUID;

import com.cisc181.eNums.eMajor;

public class Course {

	private UUID CourseID;
	private String CourseName;
	private int GradePoints;
	private eMajor Major;
	
	public Course(){
		
	}
	
	public Course(String CourseName, int GradePoints, eMajor Major)
	{
		this.CourseID = UUID.randomUUID();
		this.CourseName = CourseName;
		this.GradePoints = GradePoints;
		this.Major = Major;
	}
	
	public UUID getCourseID(){
		return this.CourseID;
	}
	public String getCourseName(){
		return this.CourseName;
	}
	public int getCGradePounts(){
		return this.GradePoints;
	}
	public eMajor getMajor(){
		return this.Major;
	}
}
