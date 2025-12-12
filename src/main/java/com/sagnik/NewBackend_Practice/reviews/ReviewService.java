package com.sagnik.NewBackend_Practice.reviews;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews();

    boolean updateReviews(Review review,Long Id);

    void createReview(Review review);

    boolean deleteReviewById(Long Id);

    Object getReviewById(Long Id);
}
