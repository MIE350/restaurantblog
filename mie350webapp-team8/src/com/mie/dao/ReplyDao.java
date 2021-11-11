package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mie.model.Reply;
import com.mie.model.Review;
import com.mie.model.ReviewList;
import com.mie.util.DbUtil;
import com.mie.model.ReplyList;

public class ReplyDao {

	private Connection connection;
	
	public ReplyDao(){
		connection = DbUtil.getConnection();
	}
	
	public void addReply(Reply reply){
		try{
			PreparedStatement ps = connection.prepareStatement("insert into replies(replyId,reviewId,studentId,reply,postTime) values (?, ?, ?, ?, ?)");
		ps.setInt(1, reply.getReplyId());
		ps.setInt(2, reply.getReviewId());
		ps.setInt(3, reply.getUserId());
		ps.setString(4,  reply.getReplyContent());
		ps.setDate(5,  new java.sql.Date(reply.getPostTime().getTime()));
		ps.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	
	
}
