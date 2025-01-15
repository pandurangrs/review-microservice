package com.revicemicroservice.service;

import java.util.List;

import com.revicemicroservice.dto.ReviewDto;
import com.revicemicroservice.model.ReviewModel;
import com.revicemicroservice.model.ReviewResponseModel;

public interface ReviewService {

	ReviewModel saveReview(ReviewDto reviewDto);
	
	ReviewResponseModel getReviewList(int page,int pageSize);
	
	ReviewModel getReviewUsingUuid(String reviewUuid);
	
	ReviewModel updateReview(String reviewUuid,ReviewDto reviewDto);
	
	void deleteReview(String reviewUuuid);

}
