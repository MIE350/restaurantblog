package com.mie.model;

import java.sql.Timestamp;

public class Reply {
	
	private int replyId;
	private int reviewId;
	private int userId;
	private String replyContent;
	private Timestamp postTime;
	
	public void readData (int replyId, int reviewId,
			int userId, String replyContent, Timestamp postTime){
		this.replyId = replyId;
		this.reviewId = reviewId;
		this.userId = userId;
		this.replyContent = replyContent;
		this.postTime = postTime;
	}
	
	//getters
	public int getReplyId() {
		return replyId;
	}
	
	public int getReviewId(){
		return reviewId;
	}
	
	public int getUserId(){
		return userId;
	}
	
	public String getReplyContent(){
		return replyContent;
	}
	
	public Timestamp getPostTime(){
		return postTime;
	}
	
	//setters
	public void setReplyContent(String newReplyContent){
		replyContent = newReplyContent;
	}

}
