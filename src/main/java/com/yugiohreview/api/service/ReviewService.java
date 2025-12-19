package com.yugiohreview.api.service;

import com.yugiohreview.api.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    ReviewDto createReview(int yugiohId,ReviewDto reviewDto);
    List<ReviewDto> getReviewsByYugiohId(int id);

    ReviewDto getReviewById(int reviewId, int yugiohId);
}
