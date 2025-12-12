package com.sagnik.NewBackend_Practice.reviews.impl;

import com.sagnik.NewBackend_Practice.reviews.Review;
import com.sagnik.NewBackend_Practice.reviews.ReviewRepository;
import com.sagnik.NewBackend_Practice.reviews.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public boolean updateReviews(Review review, Long Id) {
        Optional<Review> reviewOptional = reviewRepository.findById(Id);

        if(reviewOptional.isPresent()){
            Review reviewToUpdate = reviewOptional.get();
            reviewToUpdate.setId(reviewToUpdate.getId());
            reviewToUpdate.setName(reviewToUpdate.getName());
            reviewToUpdate.setDescription(reviewToUpdate.getDescription());

            reviewRepository.save(reviewToUpdate);

            return true;
        }else{
            return false;
        }

    }

    @Override
    public void createReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public boolean deleteReviewById(Long Id) {
        if(reviewRepository.existsById(Id)){
            reviewRepository.deleteById(Id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Object getReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }
}
