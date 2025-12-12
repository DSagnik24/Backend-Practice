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
    @GetMapping
    public List<Review> getAllReviews(){
        return reviewService.getAllReviews();
    }
    @PostMapping
    public ResponseEntity<String> addReview(@RequestBody Review review){
        reviewService.createReview(review);
        return new ResponseEntity<>("Review Created Successfully", HttpStatus.CREATED);
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
    @GetMapping("/{Id}")
    public ResponseEntity<Object> getReviewById(@PathVariable Long Id){
        Object isFetched = reviewService.getReviewById(Id);
        if(isFetched != null){
            return new ResponseEntity<>(isFetched,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
