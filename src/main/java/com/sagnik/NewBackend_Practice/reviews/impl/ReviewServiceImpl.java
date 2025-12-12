package com.sagnik.NewBackend_Practice.reviews.impl;

import com.sagnik.NewBackend_Practice.company.Company;
import com.sagnik.NewBackend_Practice.company.CompanyService;
import com.sagnik.NewBackend_Practice.reviews.Review;
import com.sagnik.NewBackend_Practice.reviews.ReviewRepository;
import com.sagnik.NewBackend_Practice.reviews.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository,CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }


    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findAll();
        return List.of();
    }

    @Override
    public boolean updateReviews(Review review, Long Id) {
        return false;
    }

    @Override
    public boolean addReview(Long id, Review review) {
        Company company = companyService.getCompanyById(id);
        if (company != null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteReviewById(Long Id) {
        return false;
    }

    @Override
    public Review getReviewById(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                        .findFirst().orElse(null);
    }


}
