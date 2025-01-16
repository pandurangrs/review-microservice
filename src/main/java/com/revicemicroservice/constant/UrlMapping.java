package com.revicemicroservice.constant;

public class UrlMapping {

	UrlMapping(){
		super();
	}
	
	
	public static final String BASE_URL="revivew-micro2/";
	
	
	public static final String REVIEW="review";
	public static final String REVIEW_UUID = REVIEW+"/{reviewUuid}";
	public static final String GET_REVIEW_USING_USER_OR_HODEK_ID="get-review-using-id";
}
