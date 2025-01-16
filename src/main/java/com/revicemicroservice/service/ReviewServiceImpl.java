package com.revicemicroservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.revicemicroservice.dao.ReviewDao;
import com.revicemicroservice.dto.ReviewDto;
import com.revicemicroservice.entity.Review;
import com.revicemicroservice.mapper.Mapper;
import com.revicemicroservice.model.ReviewModel;
import com.revicemicroservice.model.ReviewResponseModel;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewDao reviewDao;

	@Autowired
	private Mapper mapper;



	@Override
	public ReviewModel saveReview(ReviewDto reviewDto) {

		Review review = mapper.convert(reviewDto, Review.class);
		review.setUuid(UUID.randomUUID().toString());
		reviewDao.saveReview(review);
		
		
		return mapper.convert(review, ReviewModel.class);
	}

	@Override
	public ReviewResponseModel getReviewList(int page,int pageSize) {

		ReviewResponseModel reviewResponseModel = new ReviewResponseModel();
		Page<Review> pageResponse = reviewDao.getReviewList(page,pageSize);
		List<Review> reviews = pageResponse.getContent();

		reviewResponseModel.setReviewModel(mapper.convertToList(reviews, ReviewModel.class));

		buildPageResponse(pageResponse, reviewResponseModel);

		return reviewResponseModel;
	}

	private void buildPageResponse(Page<Review> pageResponse, ReviewResponseModel reviewResponseModel) {
		reviewResponseModel.setLastPage(pageResponse.isLast());
		reviewResponseModel.setPageNumber(pageResponse.getNumber());
		reviewResponseModel.setPageSize(pageResponse.getSize());
		reviewResponseModel.setTotalElements(pageResponse.getTotalElements());
		reviewResponseModel.setTotalPages(pageResponse.getTotalPages());

	}

	@Override
	public ReviewModel getReviewUsingUuid(String reviewUuid) {

		return mapper.convert(reviewDao.getReviewUsingUuid(reviewUuid), ReviewModel.class);
	}

	@Override
	public ReviewModel updateReview(String reviewUuid, ReviewDto reviewDto) {

		Review review = reviewDao.getReviewUsingUuid(reviewUuid);

		review.setHotelUuid(reviewDto.getHotelUuid());
		review.setUserUuid(reviewDto.getUserUuid());
		review.setRemark(reviewDto.getRemark());
		review.setRating(reviewDto.getRating());

		return mapper.convert(reviewDao.saveReview(review), ReviewModel.class);
	}

	@Override
	public void deleteReview(String reviewUuid) {
		Review review = reviewDao.getReviewUsingUuid(reviewUuid);
		reviewDao.deleteReview(review);

	}

	@Override
	public List<ReviewModel> geteviewUsingUserAndHoleId(String userUuid, String hotelUuid) {
		
		List<ReviewModel> models=new ArrayList<>();
		List<Review> review=new ArrayList<>();
		if(userUuid!=null) {
			models=mapper.convertToList(reviewDao.getReviewUsingUserUuid(userUuid), ReviewModel.class);
		}else {
			models=mapper.convertToList(reviewDao.getReviewUsingHotelUuid(hotelUuid), ReviewModel.class);
		}
		
		
		return models;
	}

}
