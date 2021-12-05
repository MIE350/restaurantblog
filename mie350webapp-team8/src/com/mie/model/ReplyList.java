package com.mie.model;

import java.util.*;
import java.sql.Timestamp;

public class ReplyList {
	private Map map = new HashMap();
	
	public void add(Reply newReply) {
		map.put(newReply.getReplyId(), newReply);
	}
	
	public boolean has(String replyId){
		return map.containsKey(replyId);
	}
	
	public boolean has(Reply reply){
		return map.containsKey(reply.getReplyId());
	}
	
	public int size(){
		return map.size();
	}
	
	public Reply get(String replyId) throws NotFoundException{
		if(!has(replyId)){
			throw new NotFoundException(replyId);
		}
		return (Reply) map.get(replyId);
	}
	
	public Iterator iterator(){
		return map.values().iterator();
	}

}