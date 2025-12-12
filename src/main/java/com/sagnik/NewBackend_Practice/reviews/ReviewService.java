package com.sagnik.NewBackend_Practice.reviews;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);

    boolean updateReviews(Review review,Long Id);

    boolean addReview(Long companyId, Review review);

    boolean deleteReviewById(Long Id);

    Object getReviewById(Long companyId,Long reviewId);
}
