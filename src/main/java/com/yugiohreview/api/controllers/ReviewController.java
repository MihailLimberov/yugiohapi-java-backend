package com.yugiohreview.api.controllers;

import com.yugiohreview.api.dto.ReviewDto;
import com.yugiohreview.api.models.Review;
import com.yugiohreview.api.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ReviewController {
    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @PostMapping("/yugioh/{yugiohId}/reviews")
    public ResponseEntity<ReviewDto> createReview(@PathVariable(value = "yugiohId") int yugiohId, @RequestBody ReviewDto reviewDto){
        return new ResponseEntity<>(reviewService.createReview(yugiohId,reviewDto), HttpStatus.CREATED);
    }

    @GetMapping("/yugioh/{yugiohId}/reviews")
    public List<ReviewDto> getReviewsByYugiohId(@PathVariable(value = "yugiohId") int yugiohId){
        return reviewService.getReviewsByYugiohId(yugiohId);
    }

    @GetMapping("/yugioh/{yugiohId}/reviews/{id}")
    public ResponseEntity<ReviewDto> getReviewById(@PathVariable(value = "yugiohId") int yugiohId, @PathVariable(value = "id") int reviewId){
        ReviewDto reviewDto = reviewService.getReviewById(yugiohId,reviewId);
        return new ResponseEntity<>(reviewDto,HttpStatus.OK);
    }

    @PutMapping("/yugioh/{yugiohId}/reviews/{id}")
    public ResponseEntity<ReviewDto> updateReview(@PathVariable(value = "yugiohId") int yugiohId, @PathVariable(value = "id") int reviewId,
                                                  @RequestBody ReviewDto reviewDto){
        ReviewDto updatedReview = reviewService.updateReview(yugiohId, reviewId, reviewDto);
        return new ResponseEntity<>(updatedReview,HttpStatus.OK);
    }
}
