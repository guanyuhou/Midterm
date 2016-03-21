package com.cisc181.core;

import java.util.UUID;

public class Section {
	
	private UUID CourseID;
	private UUID SemesterID;
	private UUID SectionID;
	private UUID RoomID;

	public Section(){
		
	}
	
	public Section(UUID CourseID, UUID SemesterID)
	{
		this.CourseID = CourseID;
		this.SemesterID = SemesterID;
		this.SectionID = UUID.randomUUID();
		this.RoomID = UUID.randomUUID();
	}
	
	public UUID getCourseID(){
		return this.CourseID;
	}
	public UUID getSemesterID(){
		return this.SemesterID;
	}
	public UUID getSectionID(){
		return this.SectionID;
	}
	public UUID getRoomID(){
		return this.RoomID;
	}
}
