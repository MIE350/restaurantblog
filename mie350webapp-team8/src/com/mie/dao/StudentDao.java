package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.mie.model.Student;
import com.mie.model.Restaurant;
import com.mie.util.DbUtil;

//TO DO LIST:
// - Connect shortlist to student class
	//create all three shortlist methods - look at maia's branch for reviews
	//add controller methods for shortlist


public class StudentDao {
	/**
	 * This class handles all of the Student-related methods
	 * (add/update/delete/get).
	 */

	private static Connection connection;
	static Connection currentCon = null;
	static ResultSet rs = null;

	public StudentDao() {
		/**
		 * Get the database connection.
		 */
		connection = DbUtil.getConnection();
	}

	public void addStudent(Student student) {
		/**
		 * This method adds a new student to the database.
		 */
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into students(firstname,lastname,email,username,password,bio) values (?, ?, ?, ?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, student.getFirstName());
			preparedStatement.setString(2, student.getLastName());
			preparedStatement.setString(3, student.getEmail());
			preparedStatement.setString(4, student.getUserName());
			preparedStatement.setString(5, student.getPassword());
			preparedStatement.setString(6, student.getBio());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Student login(Student student) {

		Statement stmt = null;

		String username = student.getUserName();
		String password = student.getPassword();

		String searchQuery = "select * from students where username='" + username + "' AND password='" + password + "'";

		try {
			// connect to DB
			currentCon = DbUtil.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			/**
			 * If there are no results from the query, set the member to false.
			 * The person attempting to log in will be redirected to the home
			 * page when isValid is false.
			 */
			
			if (!more) {
				student.setValid(false);
			}

			/**
			 * If the query results in an database entry that matches the
			 * username and password, assign the appropriate information to
			 * the Member object.
			 */
			else if (more) {				

				student.setFirstName(rs.getString("firstname"));
				student.setLastName(rs.getString("lastname"));
				student.setBio(rs.getString("bio"));
				student.setStudentid(rs.getInt("studentID"));
				student.setEmail(rs.getString("email"));
				populateShortlist(student);
				student.setValid(true);
			}
		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		}
		/**
		 * Return the Member object.
		 */
		return student;

	}

	public void updateStudent(Student student) {
		/**
		 * This method updates a student's information into the database.
		 */
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update students set lastname=?, firstname=?, email=?, password=?, username=?, bio=? where studentid=?");
			// Parameters start with 1
			preparedStatement.setString(1, student.getLastName());
			preparedStatement.setString(2, student.getFirstName());
			preparedStatement.setString(3, student.getEmail());
			preparedStatement.setString(4, student.getPassword());
			preparedStatement.setString(5, student.getUserName());
			preparedStatement.setString(6, student.getBio());
			preparedStatement.setInt(7, student.getStudentid());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void populateShortlist (Student student) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * from shortlist left join restaurants on shortlist.restaurantID=restaurants.restaurantID where studentID=?;");
			preparedStatement.setInt(1, student.getStudentid());
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				Restaurant restaurant = new Restaurant();
				restaurant.setId(rs.getInt("shortlist.restaurantID"));
				restaurant.setAddress(rs.getString("address"));
				restaurant.setCuisine(rs.getString("cuisine"));
				restaurant.setHours(rs.getString("hoursOperation"));
				restaurant.setName(rs.getString("name"));
				restaurant.setPicture(rs.getString("picture"));
				restaurant.setPrice(rs.getString("price"));
				restaurant.setRating(rs.getDouble("avgRating"));
				restaurant.setWebsite(rs.getString("website"));
				student.addToShortlist(restaurant);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Student> getAllStudents() {
		/**
		 * This method returns the list of all students in the form of a List
		 * object.
		 */
		List<Student> students = new ArrayList<Student>();
		try {
			Statement statement = connection.createStatement();
			// System.out.println("getting students from table");
			ResultSet rs = statement.executeQuery("select * from students");
			while (rs.next()) {
				Student student = new Student();
				student.setStudentid(rs.getInt("studentid"));
				student.setFirstName(rs.getString("firstname"));
				student.setLastName(rs.getString("lastname"));
				student.setDob(rs.getDate("dob"));
				student.setEmail(rs.getString("email"));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return students;
	}

	public Student getStudentById(int studentid) {
		/**
		 * This method retrieves a student by their StudentID number.
		 * 
		 * Currently not used in the sample web app, but code is left here for
		 * your review.
		 */
		Student student = new Student();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from students where studentid=?");
			preparedStatement.setInt(1, studentid);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				student.setStudentid(rs.getInt("studentid"));
				student.setFirstName(rs.getString("firstname"));
				student.setLastName(rs.getString("lastname"));
				student.setDob(rs.getDate("dob"));
				student.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return student;
	}

	public List<Student> getStudentByKeyword(String keyword) {
		/**
		 * This method retrieves a list of students that matches the keyword
		 * entered by the user.
		 */
		List<Student> students = new ArrayList<Student>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from students where firstname LIKE ? OR lastname LIKE ? OR email LIKE ? OR dob LIKE ?");

			preparedStatement.setString(1, "%" + keyword + "%");
			preparedStatement.setString(2, "%" + keyword + "%");
			preparedStatement.setString(3, "%" + keyword + "%");
			preparedStatement.setString(4, "%" + keyword + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setStudentid(rs.getInt("studentid"));
				student.setFirstName(rs.getString("firstname"));
				student.setLastName(rs.getString("lastname"));
				student.setDob(rs.getDate("dob"));
				student.setEmail(rs.getString("email"));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return students;
	}

}