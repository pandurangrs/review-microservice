package com.revicemicroservice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.revicemicroservice.entity.Review;
import com.revicemicroservice.exception.ResourceNotFoundException;
import com.revicemicroservice.repo.ReviewRepo;

@Repository
public class ReviewDaoImpl implements ReviewDao {

	@Autowired
	private ReviewRepo reviewRepo;

	@Override
	public Review saveReview(Review review) {

		return reviewRepo.save(review);
	}

	@Override
	public Page<Review> getReviewList(int page,int pageSize) {

		return reviewRepo.findAll(PageRequest.of(--page, pageSize));
	}

	@Override
	public Review getReviewUsingUuid(String reviewUuid) {
		// TODO Auto-generated method stub
		return reviewRepo.findByUuid(reviewUuid)
				.orElseThrow(() -> new ResourceNotFoundException("Data not Found", HttpStatus.INTERNAL_SERVER_ERROR));
	}

	@Override
	public void deleteReview(Review review) {	
		reviewRepo.delete(review);
	}

	@Override
	public List<Review> getReviewUsingUserUuid(String userUuid) {
		
		return reviewRepo.findByUserUuid(userUuid);
	}

	@Override
	public List<Review> getReviewUsingHotelUuid(String hotelUuid) {
		// TODO Auto-generated method stub
		return reviewRepo.findByHotelUuid(hotelUuid);
	}

}
