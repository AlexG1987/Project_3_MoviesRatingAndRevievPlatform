package com.cursor.moviesratingandreviewplatform.controller;

import com.cursor.moviesratingandreviewplatform.model.Movie;
import com.cursor.moviesratingandreviewplatform.model.Rate;
import com.cursor.moviesratingandreviewplatform.service.impl.RateServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RateController {

    private final RateServiceImpl rateService;

    @PostMapping("/movie/rate/{id}")
    public ResponseEntity addRateToMovie(@PathVariable(name = "id") Long id, @RequestBody Rate rate) {
        rateService.addRateToMovie(id, rate);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }


}
