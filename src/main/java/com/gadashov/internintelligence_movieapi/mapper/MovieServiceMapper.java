package com.gadashov.internintelligence_movieapi.mapper;

import com.gadashov.internintelligence_movieapi.dto.request.CreateMovieRequest;
import com.gadashov.internintelligence_movieapi.dto.request.UpdateMovieRequest;
import com.gadashov.internintelligence_movieapi.dto.response.MovieResponse;
import com.gadashov.internintelligence_movieapi.entity.Movie;
import com.gadashov.internintelligence_movieapi.enums.Genre;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MovieServiceMapper {

    public Movie movieCreateRequestToUserEntity(CreateMovieRequest request) {
        return Movie.builder()
                .title(request.title())
                .director(request.director())
                .releaseYear(request.releaseYear())
                .genre(parseGenre(String.valueOf(request.genre())))
                .imdbRating(request.imdbRating())
                .build();
    }

    public Movie movieUpdateRequestToMovieEntity(Movie movie, UpdateMovieRequest request) {
        if (request.title() != null) {
            movie.setTitle(request.title());
        }
        if (request.director() != null) {
            movie.setDirector(request.director());
        }
        if (request.releaseYear() != null) {
            movie.setReleaseYear(request.releaseYear());
        }
        if (request.genre() != null) {
            movie.setGenre(parseGenre(String.valueOf(request.genre())));
        }
        if (request.imdbRating() != null) {
            movie.setImdbRating(request.imdbRating());
        }
        return movie;
    }

    public MovieResponse movieEntityToMovieResponse(Movie movie) {
        return MovieResponse.builder()
                .title(movie.getTitle())
                .director(movie.getDirector())
                .releaseYear(movie.getReleaseYear())
                .genre(movie.getGenre())
                .imdbRating(movie.getImdbRating())
                .build();
    }

    private Genre parseGenre(String genre) {
        try {
            return Genre.valueOf(genre.toUpperCase());
        } catch (IllegalArgumentException e) {
            log.error("Invalid genre provided: {}", genre);
            throw new IllegalArgumentException("Invalid genre: " + genre);
        }
    }
}
