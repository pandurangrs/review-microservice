package com.revicemicroservice.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revicemicroservice.entity.Review;

public interface ReviewRepo extends JpaRepository<Review, Long>{

	Optional<Review> findByUuid(String reviewUuid);

}
