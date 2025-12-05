package com.revicemicroservice.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revicemicroservice.entity.Review;

public interface ReviewRepo extends JpaRepository<Review, Long>{

	Optional<Review> findByUuid(String reviewUuid);

	List<Review> findByUserUuid(String userUuid);

	List<Review> findByHotelUuid(String hotelUuid);

}
