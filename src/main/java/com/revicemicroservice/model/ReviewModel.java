package com.revicemicroservice.model;

import lombok.Data;

@Data
public class ReviewModel {

	private String uuid;

	private Integer rating;

	private String remark;
}
