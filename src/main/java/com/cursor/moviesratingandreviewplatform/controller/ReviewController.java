package com.cursor.moviesratingandreviewplatform.controller;

import com.cursor.moviesratingandreviewplatform.model.Review;
import com.cursor.moviesratingandreviewplatform.service.impl.ReviewServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewServiceImpl reviewService;

    @PostMapping("/")
    public ResponseEntity addReview(@RequestBody Review review) {
        reviewService.addReviewToMovie(review);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("/{movieId}")
    public ResponseEntity editMovie(@PathVariable(name = "movieId") Long movieId, @RequestBody Review review) {
        reviewService.updateReview(movieId, review);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @GetMapping("/{movieId}")
    public List<Review> findAllByMovieId(@PathVariable(name = "movieId") Long movieId) {
        return reviewService.findAllByMovieId(movieId);
    }

}
