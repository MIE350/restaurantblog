package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

import com.mie.model.Review;
import com.mie.model.Student;
import com.mie.util.DbUtil;
import com.mie.model.ReviewList;
import com.mie.model.Reply;

public class ReviewDao {
	
	private Connection connection;

	public void main(){
		
		ReviewList reviews = (ReviewList) getAllReviews();
		Iterator iterator = reviews.iterator();
		while (iterator.hasNext()){
			Review review = (Review) iterator.next();
			sortReplies(review);
			review.printContents();
		}
		
	}
	
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
	
	public ReviewList getAllReviews() {
		/**
		 * This method returns the list of all students in the form of a List
		 * object.
		 */
		ReviewList reviews = new ReviewList();
		try {
			Statement statement = connection.createStatement();
			// System.out.println("getting reviews from table");
			ResultSet rs = statement.executeQuery("select * from reviews");
			while (rs.next()) {
				Review review = new Review();
				review.setUserId(rs.getInt("studentID"));
				review.setRestaurantId(rs.getInt("restaurantID"));
				review.setReviewId(rs.getInt("reviewID"));
				review.setReviewContent(rs.getString("review"));
				review.setRating(rs.getInt("rating"));
				review.setPostTime(rs.getTimestamp("postTime"));
				reviews.add(review);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reviews;
	}
	
	public ReviewList getRestaurantReviews(int restaurantId) {
		ReviewList reviews = new ReviewList();
		try {
			Statement statement = connection.createStatement();
			// System.out.println("getting reviews from table");
			ResultSet rs = statement.executeQuery("select * from reviews where restaurantID=" 
					+ restaurantId + " order by postTime desc;");
			while (rs.next()) {
				//set parameters for review object
				Review review = new Review();
				review.setUserId(rs.getInt("studentID"));
				review.setRestaurantId(rs.getInt("restaurantID"));
				review.setReviewId(rs.getInt("reviewID"));
				review.setReviewContent(rs.getString("review"));
				review.setRating(rs.getInt("rating"));
				review.setPostTime(rs.getTimestamp("postTime"));
				
				//find and sort replies
				//sortReplies(review);
				
				//reviews.add(review);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reviews;
	}
	
	public void sortAllReplies() {
		/**
		 * This method returns the list of all students in the form of a List
		 * object.
		 */
		ReviewList reviews = getAllReviews();
		
		Iterator iterator = reviews.iterator();
		
		while (iterator.hasNext()){
			Review review = (Review) iterator.next();
			int reviewId = review.getReviewId();
			
			try {
				Statement statement = connection.createStatement();
				// System.out.println("getting reviews from table");
				ResultSet rs = statement.executeQuery("select * from replies where reviewID ="+reviewId+" order by postTime ASC;");
				while (rs.next()){
					Reply reply = new Reply();
					reply.setReplyId(rs.getInt("replyID"));
					reply.setReviewId(rs.getInt("reviewID"));
					reply.setUserId(rs.getInt("studentID"));
					reply.setReplyContent(rs.getString("reply"));
					reply.setPostTime(rs.getTimestamp("postTime"));
					review.addReply(reply);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void sortReplies(Review review) {
		/**
		 * This method returns the list of all students in the form of a List
		 * object.
		 */

			int reviewId = review.getReviewId();
			
			try {
				Statement statement = connection.createStatement();
				// System.out.println("getting reviews from table");
				ResultSet rs = statement.executeQuery("select * from replies where reviewID ="+reviewId+" order by postTime ASC;");
				while (rs.next()){
					Reply reply = new Reply();
					reply.setReplyId(rs.getInt("replyID"));
					reply.setReviewId(rs.getInt("reviewID"));
					reply.setUserId(rs.getInt("studentID"));
					reply.setReplyContent(rs.getString("reply"));
					reply.setPostTime(rs.getTimestamp("postTime"));
					review.addReply(reply);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}


}