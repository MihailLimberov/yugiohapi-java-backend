package com.yugiohreview.api.service.impl;

import com.yugiohreview.api.dto.ReviewDto;
import com.yugiohreview.api.exceptions.YugiohNotFoundException;
import com.yugiohreview.api.models.YuGiOh;
import com.yugiohreview.api.models.Review;
import com.yugiohreview.api.repository.YugiohRepository;
import com.yugiohreview.api.repository.ReviewRepository;
import com.yugiohreview.api.service.YugiohService;
import com.yugiohreview.api.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService{
    private ReviewRepository reviewRepository;
    private YugiohRepository yugiohRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository,YugiohRepository yugiohRepository){
        this.reviewRepository = reviewRepository;
        this.yugiohRepository = yugiohRepository;
    }

    @Override
    public ReviewDto createReview(int yugiohId,ReviewDto reviewDto){
        Review review = mapToEntity(reviewDto);

        YuGiOh yugioh = yugiohRepository.findById(yugiohId).orElseThrow(()-> new YugiohNotFoundException("Yugioh card with associated review not found"));

        review.setYugioh(yugioh);

        Review newReview = reviewRepository.save(review);

        return mapToDto(newReview);
    }

    @Override
    public List<ReviewDto> getReviewsByYugiohId(int id){
        List<Review> reviews = reviewRepository.findByYugiohId(id);

        return reviews.stream().map(review -> mapToDto(review)).collect(Collectors.toList());
    }



    private ReviewDto mapToDto(Review review){
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setId(review.getId());
        reviewDto.setTitle(review.getTitle());
        reviewDto.setContent(review.getContent());
        reviewDto.setStars(review.getStars());
        return reviewDto;
    }

    private Review mapToEntity(ReviewDto reviewDto){
        Review review = new Review();
        review.setId(reviewDto.getId());
        review.setTitle(reviewDto.getTitle());
        review.setContent(reviewDto.getContent());
        review.setStars(reviewDto.getStars());
        return review;
    }
}
