package com.sagnik.NewBackend_Practice.reviews;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId),HttpStatus.OK);
    }
    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@RequestBody Review review,@PathVariable Long companyId){
        boolean isReviewed = reviewService.addReview(companyId,review);
        if(isReviewed){
            return new ResponseEntity<>("Review added Successfully", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("Review not added Successfully", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<String> deleteReviewById(@PathVariable Long companyId,
                                                   @PathVariable Long reviewId){
        boolean isDeleted = reviewService.deleteReviewById(companyId,reviewId);
        if(isDeleted){
            return new ResponseEntity<>("Review Deleted",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Review Not Deleted",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long companyId,
                                                @PathVariable Long reviewId){
        Review review = reviewService.getReviewById(companyId,reviewId);
        return new ResponseEntity<>(review,HttpStatus.OK);

    }
    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReviews(@RequestBody Review review,
                                                @PathVariable Long reviewId,
                                                @PathVariable Long companyId){
        boolean isReviewUpdated = reviewService.updateReviews(review,reviewId,companyId);

        if(isReviewUpdated)
            return new ResponseEntity<>("Review updated successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Review not updated",HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> updateReviews(@PathVariable Long reviewId,
                                                @PathVariable Long companyId){
        boolean isReviewDeleted = reviewService.deleteReviewById(reviewId,companyId);

        if(isReviewDeleted)
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Review not deleted",HttpStatus.NOT_FOUND);
    }
}
