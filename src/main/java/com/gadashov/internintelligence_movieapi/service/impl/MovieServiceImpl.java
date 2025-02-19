package com.gadashov.internintelligence_movieapi.service.impl;

import com.gadashov.internintelligence_movieapi.dto.request.CreateMovieRequest;
import com.gadashov.internintelligence_movieapi.dto.request.UpdateMovieRequest;
import com.gadashov.internintelligence_movieapi.dto.response.MovieResponse;
import com.gadashov.internintelligence_movieapi.entity.Movie;
import com.gadashov.internintelligence_movieapi.exceptions.Exceptions;
import com.gadashov.internintelligence_movieapi.exceptions.GeneralExceptions;
import com.gadashov.internintelligence_movieapi.mapper.MovieServiceMapper;
import com.gadashov.internintelligence_movieapi.repository.MovieRepository;
import com.gadashov.internintelligence_movieapi.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieServiceMapper movieServiceMapper;

    @Override
    public MovieResponse createMovie(CreateMovieRequest request) {
        log.info("Creating a new movie: {}", request);
        Movie movie = movieServiceMapper.movieCreateRequestToUserEntity(request);
        movie = movieRepository.save(movie);
        log.info("Movie created successfully: {}", movie);
        return movieServiceMapper.movieEntityToMovieResponse(movie);
    }

    @Override
    public MovieResponse updateMovie(Long movieId, UpdateMovieRequest request) {
        log.info("Updating movie with ID {}: {}", movieId, request);
        Movie movie = findById(movieId);
        Movie updatedMovie = movieServiceMapper.movieUpdateRequestToMovieEntity(movie, request);
        updatedMovie = movieRepository.save(updatedMovie);
        log.info("Movie updated successfully: {}", updatedMovie);
        return movieServiceMapper.movieEntityToMovieResponse(updatedMovie);
    }

    @Override
    public MovieResponse getMovieById(Long movieId) {
        log.info("Fetching movie with ID {}", movieId);
        Movie movie = findById(movieId);
        return movieServiceMapper.movieEntityToMovieResponse(movie);
    }

    @Override
    public List<MovieResponse> getAllMovies() {
        log.info("Fetching all movies...");
        List<Movie> movies = movieRepository.findAll();
        return movies.stream().map(movieServiceMapper::movieEntityToMovieResponse).toList();
    }

    @Override
    public void deleteMovie(Long id) {
        log.warn("Deleting movie with ID {}", id);
        Movie movie = findById(id);
        movieRepository.delete(movie);
        log.warn("Movie deleted successfully with ID {}", id);
    }

    private Movie findById(Long movieId) {
        return movieRepository.findById(movieId)
                .orElseThrow(() -> {
                    log.error("Movie with ID {} not found!", movieId);
                    return new GeneralExceptions(Exceptions.MOVIE_NOT_FOUND);
                });
    }
}
