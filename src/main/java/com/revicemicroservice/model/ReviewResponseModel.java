package com.revicemicroservice.model;

import java.util.List;

import com.revicemicroservice.payload.PaginationResponse;

import lombok.Data;


@Data
public class ReviewResponseModel extends PaginationResponse {

	private List<ReviewModel> reviewModel;
}
