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

    @PostMapping("/{Id}")
    public ResponseEntity<String> updateReview(@RequestBody Review review, @PathVariable Long Id){
        reviewService.updateReviews(review,Id);
        return new ResponseEntity<>("Review Updated Successfully",HttpStatus.OK);
    }
    @DeleteMapping("/{Id}")
    public ResponseEntity<String> deleteReviewById(@PathVariable Long Id,@RequestBody Review review){
        boolean isDeleted = reviewService.deleteReviewById(Id);
        if(isDeleted){
            return new ResponseEntity<>("Review Deleted",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Review Not Deleted",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long companyId,
                                                @PathVariable Long reviewId){
        return new ResponseEntity<>(reviewService.getReviewById(companyId,reviewId),HttpStatus.OK);

    }
}
