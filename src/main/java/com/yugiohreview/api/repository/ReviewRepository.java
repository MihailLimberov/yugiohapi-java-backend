package com.yugiohreview.api.repository;

import com.yugiohreview.api.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByYugiohId(int yugiohId);
}
