package com.mie.model;

import java.sql.Timestamp;
import java.util.*;

public class ReviewList {
	
	private Map map = new HashMap();

	/**
	 * Adds a review
	 * 
	 * @param newReview
	 *            - new <tt>Review</tt> to add
	 */
	public void add(Review newReview) {
		map.put(newReview.getReviewId(), newReview);
	}

	/**
	 * 
	 * @param reviewId
	 *            <tt>String</tt>
	 * @return if review with code <tt>reviewId</tt> is in the list
	 */
	public boolean has(String reviewId) {
		return map.containsKey(reviewId);
	}

	/**
	 * 
	 * @param course
	 *            <tt>Course</tt>
	 * @return if course is in the list
	 */
	public boolean has(Review review) {
		return map.containsKey(review.getReviewId());
	}

	public int size() {
		return map.size();
	}

	public Review get(String reviewId) throws NotFoundException {
		if (!has(reviewId)) {
			throw new NotFoundException(reviewId);
		}
		return (Review) map.get(reviewId);
	}

	public Iterator iterator() {
		return map.values().iterator();
	}

}