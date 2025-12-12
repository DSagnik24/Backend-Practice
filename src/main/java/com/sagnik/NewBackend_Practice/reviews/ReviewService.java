package com.sagnik.NewBackend_Practice.reviews;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);

    boolean updateReviews(Review review,Long reviewId,Long companyId);

    boolean addReview(Long companyId, Review review);

    boolean deleteReviewById(Long reviewId,Long companyId);

    Review getReviewById(Long companyId, Long reviewId);
}
