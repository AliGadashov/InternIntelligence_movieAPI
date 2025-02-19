package com.gadashov.internintelligence_movieapi.controller;

import com.gadashov.internintelligence_movieapi.dto.request.CreateMovieRequest;
import com.gadashov.internintelligence_movieapi.dto.request.UpdateMovieRequest;
import com.gadashov.internintelligence_movieapi.dto.response.MovieResponse;
import com.gadashov.internintelligence_movieapi.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/1.0/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieResponse> addMovie(@Valid @RequestBody CreateMovieRequest request) {
        log.info("Creating new movie: {}", request);
        MovieResponse response = movieService.createMovie(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MovieResponse> updateMovie(@PathVariable Long id,
                                                     @Valid @RequestBody UpdateMovieRequest request) {
        log.info("Updating movie with id {}: {}", id, request);
        MovieResponse response = movieService.updateMovie(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id) {
        log.warn("Deleting movie with id {}", id);
        movieService.deleteMovie(id);
        return ResponseEntity.ok("Movie deleted successfully!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> getMovieById(@PathVariable Long id) {
        log.info("Fetching movie with id {}", id);
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @GetMapping
    public ResponseEntity<List<MovieResponse>> getAllMovies() {
        log.info("Fetching all movies");
        return ResponseEntity.ok(movieService.getAllMovies());
    }
}
