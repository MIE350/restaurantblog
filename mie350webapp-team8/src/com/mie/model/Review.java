package com.mie.model;

import java.sql.Timestamp;
import java.util.Iterator;

public class Review {

	/**
	 * This class contains all of the relevant information, and getter/setter
	 * methods for the Review object.
	 */
	
	private int reviewId;
	private int restaurantId;
	private int userId;
	private String reviewContent;
	private int rating;
	private Timestamp postTime;
	
	private ReplyList replies = new ReplyList();
	
	public void readData (int reviewId, int restaurantId, int userId, String reviewContent, 
			int rating, Timestamp postTime) {
		this.reviewId = reviewId;
		this.restaurantId = restaurantId;
		this.userId = userId;
		this.reviewContent = reviewContent;
		this.rating = rating;
		this.postTime = postTime;
	}
	
	//getters
	public int getReviewId() {
		return reviewId;
	}
	
	public int getRestaurantId() {
		return restaurantId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public String getReviewContent() {
		return reviewContent;
	}
	
	public int getRating() {
		return rating;
	}
	
	public Timestamp getPostTime() {
		return postTime;
	}
	
	public ReplyList getReplies() {
		return replies;
	}
	
	//setters
	public void setReviewContent(String newReviewContent) {
		reviewContent = newReviewContent;
	}
	
	public void setRating(int newRating) {
		rating = newRating;
	}
	
	public void setUserId(int newUserId){
		userId = newUserId;
	}
	
	public void setRestaurantId(int newRestaurantId){
		restaurantId = newRestaurantId;
	}
	
	public void setReviewId(int newReviewId){
		reviewId =newReviewId;
	}
	
	public void setPostTime(Timestamp newPostTime){
		postTime = newPostTime;
	}
	
	//add new reply to review
	public void addReply(Reply reply) {
		replies.add(reply);
	}
	
	public void printContents(){
		System.out.println("ReviewID: "+this.reviewId+"\nRestaurantID: "+this.restaurantId
				+"\nUserID: "+this.userId+"\nReviewContent: "+(String) this.reviewContent+
				"\nRating: "+this.rating+"\npostTime: "+this.postTime);
		Iterator iterator = replies.iterator(); 
		while (iterator.hasNext()){
			Reply reply = (Reply) iterator.next();
			reply.printContents();
		}
	}

}