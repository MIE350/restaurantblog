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
	private String email;
	private String username;
	private String password;
	private RestaurantList shortlist;
	private String bio;
	private boolean valid;

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int new_studentid) {
		studentid = new_studentid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String new_firstName) {
		firstName = new_firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String new_lastName) {
		lastName = new_lastName;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String new_email) {
		email = new_email;
	}
	
	public void setUserName(String new_username) {
		username = new_username;
	}
	
	public String getUserName() {
		return username;
	}
	
	public void setPassword(String new_password) {
		password = new_password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setBio(String new_bio) {
		bio = new_bio;
	}
	
	public String getBio() {
		return bio;
	}
	
	public RestaurantList getShortlist() {
		return shortlist;
	}
	
	public void addToShortlist(Restaurant restaurant) {
		shortlist.add(restaurant);
	}
	
	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean newValid) {
		valid = newValid;
	}
	
}