package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mie.model.Review;
import com.mie.util.DbUtil;

public class ReviewDao {
	
	private Connection connection;

	public ReviewDao() {
		/**
		 * Get the database connection.
		 */
		connection = DbUtil.getConnection();
	}

	public void addReview(Review review) {
		/**
		 * This method adds a new student to the database.
		 */
		try {
			PreparedStatement ps = connection
					.prepareStatement("insert into reviews(studentID,restaurantID,reviewID,review,rating,postTime) values (?, ?, ?, ?, ?, ?)");
			// Parameters start with 1
			ps.setInt(1, review.getUserId());
			ps.setInt(2, review.getRestaurantId());
			ps.setInt(3, review.getReviewId());
			ps.setString(4, review.getReviewContent());
			ps.setInt(5, review.getRating());
			ps.setDate(6, new java.sql.Date(review.getPostTime().getTime()));
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
