package com.revicemicroservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="review_microservices")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ratingId;
	
	@Column
	private String uuid;
	
	@Column
	private String userUuid;
	
	@Column
	private String hotelUuid;
	
	@Column
	private Integer rating;
	
	@Column
	private String remark;
}
