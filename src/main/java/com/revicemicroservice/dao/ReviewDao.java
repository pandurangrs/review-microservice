package com.revicemicroservice.dao;

import org.springframework.data.domain.Page;

import com.revicemicroservice.entity.Review;

public interface ReviewDao {

	
	Review saveReview(Review review);
	
	Page<Review> getReviewList(int page,int pageSize);
	
	Review getReviewUsingUuid(String reviewUuid);
	
	void deleteReview(Review review);
}
