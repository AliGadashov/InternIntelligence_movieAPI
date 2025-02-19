package com.gadashov.internintelligence_movieapi.dto.request;

import com.gadashov.internintelligence_movieapi.enums.Genre;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record UpdateMovieRequest(
        String title,
        String director,
        @Min(1888) Integer releaseYear,
        Genre genre,
        @Min(0) @Max(10) Double imdbRating
) {
}
