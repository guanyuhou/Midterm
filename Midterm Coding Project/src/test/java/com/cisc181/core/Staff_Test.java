package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

import antlr.collections.List;

public class Staff_Test{

	static ArrayList<Staff> stafflist = new ArrayList<Staff>();
	
	@BeforeClass
	public static void setup() throws PersonException{

		Date DOB = new Date(1);
		Date hireDate = new Date();
		
		Staff a = new Staff("Fi", "Mi", "La", DOB, "address",
				"1111111111", "email@udel.edu", "office hr", 1, 120000, hireDate, eTitle.MR);
		Staff b = new Staff("Fi", "Mi", "La", DOB, "address",
				"1111111111", "email@udel.edu", "office hr", 1, 150000, hireDate, eTitle.MR);
		Staff c = new Staff("Fi", "Mi", "La", DOB, "address",
				"1111111111", "email@udel.edu", "office hr", 1, 300000, hireDate, eTitle.MR);
		Staff d = new Staff("Fi", "Mi", "La", DOB, "address",
				"1111111111", "email@udel.edu", "office hr", 1, 500000, hireDate, eTitle.MR);
		Staff e = new Staff("Fi", "Mi", "La", DOB, "address",
				"1111111111", "email@udel.edu", "office hr", 1, 1000000, hireDate, eTitle.MR);
		
		stafflist.add(a);
		stafflist.add(b);
		stafflist.add(c);
		stafflist.add(d);
		stafflist.add(e);
		
	}
	
	@Test
	public void test1(){
		double sum = 0;
		for (Staff i:stafflist)
			sum += i.getSalary();
		
		assertEquals(414000, (sum/5.0), 0);
	}
	
	@Test
	public void test2() throws PersonException{
		//Test for invalid phone number.
		Date DOB = new Date(1);
		Date hireDate = new Date();
		Staff f = new Staff("Fi", "Mi", "La", DOB, "address",
				"123456789", "email@udel.edu", "office hr", 1, 1000000, hireDate, eTitle.MR);
		System.out.println(f.getPhone());
	}

	@Test
	public void test3() throws PersonException{
		//Test for invalid birth date
		Calendar birthDate = Calendar.getInstance();
		birthDate.set(1900, 1, 1);
		Date DOB = birthDate.getTime();
		Date hireDate = new Date();
		Staff g = new Staff("Fi", "Mi", "La", DOB, "address",
				"1234567890", "email@udel.edu", "office hr", 1, 1000000, hireDate, eTitle.MR);
		System.out.println(g.getDOB());
	}
}
