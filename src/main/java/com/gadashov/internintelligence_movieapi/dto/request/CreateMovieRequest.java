package com.gadashov.internintelligence_movieapi.dto.request;

import com.gadashov.internintelligence_movieapi.enums.Genre;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateMovieRequest(
        @NotBlank String title,
        @NotBlank String director,
        @NotNull @Min(1888) int releaseYear,
        @NotNull Genre genre,
        @Min(0) @Max(10) double imdbRating
) {
}
