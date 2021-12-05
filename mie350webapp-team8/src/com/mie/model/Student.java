package com.mie.model;

import java.util.Date;

public class Student {
	/**
	 * This class contains all of the relevant information, and getter/setter
	 * methods for the Student object.
	 */

	private int studentid;
	private String firstName;
	private String lastName;
	//private Date dob;
	private String email;
	private String username;
	private String password;
	private RestaurantList shortlist;
	private String bio;

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
/*
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
*/
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setUserName(String username) {
		this.username = username;
	}
	
	public String getUserName() {
		return username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public RestaurantList getShortlist() {
		return shortlist;
	}
	
	public void setShortlist(RestaurantList shortlist) {
		shortlist.createShortlist(this.studentid);
	}
	
	//todo: add to shortlist method (see reveiw class on maia branch)

	public void readData(int studid, String lname, String fname, String email, 
			String username, String password){
		
		this.studentid = studid;
		this.lastName = lname;
		this.firstName = fname;
		this.email = email;
		//this.dob = dbirth;
		this.username = username;
		this.password = password;
		
	}
	
	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + "]";
	}
}