package com.cisc181.core;

import java.io.*;
import java.util.Date;

public class PersonException extends Exception{

	
	private String invalid_number;
	private Date invalid_DOB;
	
	public PersonException(Date invalid_DOB)
	{
		this.invalid_DOB = invalid_DOB;
	}
	
	public PersonException(String invalid_number)
	{
		this.invalid_number = invalid_number;
	}
	
}
