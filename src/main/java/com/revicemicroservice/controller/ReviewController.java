package com.revicemicroservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revicemicroservice.constant.AppConstant;
import com.revicemicroservice.constant.UrlMapping;
import com.revicemicroservice.dto.ReviewDto;
import com.revicemicroservice.model.ReviewModel;
import com.revicemicroservice.model.ReviewResponseModel;
import com.revicemicroservice.payload.ApiResponse;
import com.revicemicroservice.service.ReviewService;

@RestController
@RequestMapping(UrlMapping.BASE_URL)
public class ReviewController {

	private ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	@PostMapping(UrlMapping.REVIEW)
	public ResponseEntity<ReviewModel> saveReview(@RequestBody ReviewDto reviewDto) {
		ReviewModel reviewModel = reviewService.saveReview(reviewDto);
		return new ResponseEntity<>(reviewModel, HttpStatus.CREATED);
	}

	@GetMapping(UrlMapping.REVIEW)
	public ResponseEntity<ReviewResponseModel> getReviewList(
			@RequestParam(defaultValue = AppConstant.REVIEW_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(defaultValue = AppConstant.REVIEW_PAGE_NUMBER, required = false) int pageNumber) {
		ReviewResponseModel responseModel = reviewService.getReviewList(pageNumber, pageSize);
		return new ResponseEntity<>(responseModel, HttpStatus.OK);
	}

	@GetMapping(UrlMapping.REVIEW_UUID)
	public ResponseEntity<ReviewModel> geteview(@PathVariable String reviewUuid) {
		ReviewModel reviewModel = reviewService.getReviewUsingUuid(reviewUuid);
		return new ResponseEntity<>(reviewModel, HttpStatus.CREATED);
	}

	@PutMapping(UrlMapping.REVIEW_UUID)
	public ResponseEntity<ReviewModel> updateRview(@PathVariable String reviewUuid, @RequestBody ReviewDto reviewDto) {
		ReviewModel reviewModel = reviewService.updateReview(reviewUuid, reviewDto);
		return new ResponseEntity<>(reviewModel, HttpStatus.CREATED);
	}

	@DeleteMapping(UrlMapping.REVIEW_UUID)
	public ResponseEntity<ApiResponse> updateRview(@PathVariable String reviewUuid) {
		reviewService.deleteReview(reviewUuid);
		return new ResponseEntity<>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
	}

}
