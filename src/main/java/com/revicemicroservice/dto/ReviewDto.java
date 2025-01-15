package com.revicemicroservice.dto;

import lombok.Data;

@Data
public class ReviewDto {

	private String uuid;

	private String userUuid;

	private String hotelUuid;

	private Integer rating;

	private String remark;
}
