package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {

	static ArrayList<Course> listCourse = new ArrayList<Course>();
	static ArrayList<Semester> listSemester = new ArrayList<Semester>();
	static ArrayList<Section> listSection = new ArrayList<Section>();
	static ArrayList<Student> listStudent = new ArrayList<Student>();

	@BeforeClass
	public static void setup() throws PersonException {
		Date DOB = new Date(0);

		// three Course records
		Course course1 = new Course("101", 4, eMajor.CHEM);
		Course course2 = new Course("100", 4, eMajor.BUSINESS);
		Course course3 = new Course("300", 4, eMajor.PHYSICS);
		listCourse.add(course1);
		listCourse.add(course2);
		listCourse.add(course3);

		// two Semesters, one for Fall, one for Spring
		Calendar fallStart = Calendar.getInstance();
		Calendar fallEnd = Calendar.getInstance();
		Calendar springStart = Calendar.getInstance();
		Calendar springEnd = Calendar.getInstance();
		fallStart.set(2015, 9, 1);
		fallEnd.set(2015, 12, 20);
		springStart.set(2016, 2, 10);
		springEnd.set(2016, 5, 20);
		Date fallStartDate = fallStart.getTime();
		Date fallEndDate = fallEnd.getTime();
		Date springStartDate = springStart.getTime();
		Date springEndDate = springEnd.getTime();
		Semester semfal = new Semester(fallStartDate, fallEndDate);
		Semester semspr = new Semester(springStartDate, springEndDate);
		listSemester.add(semfal);
		listSemester.add(semspr);

		// two Sections for each Course & Semester
		Section SectionFC1 = new Section(course1.getCourseID(), semfal.getSemesterID());
		Section SectionFC2 = new Section(course1.getCourseID(), semfal.getSemesterID());
		Section SectionFB1 = new Section(course2.getCourseID(), semfal.getSemesterID());
		Section SectionFB2 = new Section(course2.getCourseID(), semfal.getSemesterID());
		Section SectionFP1 = new Section(course3.getCourseID(), semfal.getSemesterID());
		Section SectionFP2 = new Section(course3.getCourseID(), semfal.getSemesterID());
		Section SectionSC1 = new Section(course1.getCourseID(), semspr.getSemesterID());
		Section SectionSC2 = new Section(course1.getCourseID(), semspr.getSemesterID());
		Section SectionSB1 = new Section(course2.getCourseID(), semspr.getSemesterID());
		Section SectionSB2 = new Section(course2.getCourseID(), semspr.getSemesterID());
		Section SectionSP1 = new Section(course3.getCourseID(), semspr.getSemesterID());
		Section SectionSP2 = new Section(course3.getCourseID(), semspr.getSemesterID());
		listSection.add(SectionFC1);
		listSection.add(SectionFC2);
		listSection.add(SectionFB1);
		listSection.add(SectionFB2);
		listSection.add(SectionFP1);
		listSection.add(SectionFP2);
		listSection.add(SectionSC1);
		listSection.add(SectionSC2);
		listSection.add(SectionSB1);
		listSection.add(SectionSB2);
		listSection.add(SectionSP1);
		listSection.add(SectionSP2);

		// ten Student records
		Student a = new Student("A", "Mi", "La", DOB, eMajor.CHEM, "Address", "1234567890", "a@udel.edu");
		Student b = new Student("B", "Mi", "La", DOB, eMajor.CHEM, "Address", "1234567890", "a@udel.edu");
		Student c = new Student("C", "Mi", "La", DOB, eMajor.CHEM, "Address", "1234567890", "a@udel.edu");
		Student d = new Student("D", "Mi", "La", DOB, eMajor.CHEM, "Address", "1234567890", "a@udel.edu");
		Student e = new Student("E", "Mi", "La", DOB, eMajor.CHEM, "Address", "1234567890", "a@udel.edu");
		Student f = new Student("F", "Mi", "La", DOB, eMajor.CHEM, "Address", "1234567890", "a@udel.edu");
		Student g = new Student("G", "Mi", "La", DOB, eMajor.CHEM, "Address", "1234567890", "a@udel.edu");
		Student h = new Student("H", "Mi", "La", DOB, eMajor.CHEM, "Address", "1234567890", "a@udel.edu");
		Student i = new Student("I", "Mi", "La", DOB, eMajor.CHEM, "Address", "1234567890", "a@udel.edu");
		Student j = new Student("J", "Mi", "La", DOB, eMajor.CHEM, "Address", "1234567890", "a@udel.edu");
		listStudent.add(a);
		listStudent.add(b);
		listStudent.add(c);
		listStudent.add(d);
		listStudent.add(e);
		listStudent.add(f);
		listStudent.add(g);
		listStudent.add(h);
		listStudent.add(i);
		listStudent.add(j);
	}

	@Test
	public void test() {
		ArrayList<Enrollment> listEnroll = new ArrayList<Enrollment>();
		for (Student i : listStudent) {
			for (Section j : listSection) {
				Enrollment ijEnroll = new Enrollment(i.getStudentID(), j.getSectionID());
				listEnroll.add(ijEnroll);
			}
		}

		for (Enrollment i : listEnroll) {
			i.SetGrade(4.0);
		}
		
//		System.out.println("Student ID's from Enrollment List");
//		for (Enrollment e:listEnroll)
//		{
//			System.out.println(e.getStudentID());
//		}
//		System.out.println("\n\n\n\n Student ID's from Student List");
//		for (Student s:listStudent)
//		{
//			System.out.println(s.getStudentID());
//		}
		
		// Test GPA for each student
		for (Student stud : listStudent) {
			int count = 0;
			double GPA = 0;
			for (Enrollment enroll : listEnroll) {
				if (count >= 12)
					break;
				else if (enroll.getStudentID().equals(stud.getStudentID())) {
					count++;
					GPA += enroll.getGrade();
				}
			}
			GPA = GPA / 12.0;
			assertEquals(4.0, GPA, 0);
		}

		// Test GPA for each course
		for (Course cou : listCourse) {
			int count = 0;
			double GPA = 0;
			for (Section sec : listSection) {
				if (cou.getCourseID().equals(sec.getCourseID())) {
					for (Enrollment enroll : listEnroll) {
						if (count >= 40)
							break;
						else if (enroll.getSectionID().equals(sec.getSectionID())) {
							count++;
							GPA += enroll.getGrade();
						}
					}
				}
			}
			//10 students in each sections, each course has 4 sections
			GPA = GPA / 40.0;
			assertEquals(4.0, GPA, 0);
		}
	}
	
	@Test
	public void test2(){
		//Change major from Chem to Compsi
		assertEquals(listStudent.get(0).getMajor(), eMajor.CHEM);
		listStudent.get(0).setMajor(eMajor.COMPSI);
		assertEquals(listStudent.get(0).getMajor(), eMajor.COMPSI);
	}
}