package com.gadashov.internintelligence_movieapi.service;

import com.gadashov.internintelligence_movieapi.dto.request.CreateMovieRequest;
import com.gadashov.internintelligence_movieapi.dto.request.UpdateMovieRequest;
import com.gadashov.internintelligence_movieapi.dto.response.MovieResponse;

import java.util.List;

public interface MovieService {

    MovieResponse createMovie(CreateMovieRequest request);

    MovieResponse updateMovie(Long id, UpdateMovieRequest request);

    MovieResponse getMovieById(Long id);

    List<MovieResponse> getAllMovies();

    void deleteMovie(Long id);

}
