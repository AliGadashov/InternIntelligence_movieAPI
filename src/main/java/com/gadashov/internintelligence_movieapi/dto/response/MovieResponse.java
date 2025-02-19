package com.gadashov.internintelligence_movieapi.dto.response;

import com.gadashov.internintelligence_movieapi.enums.Genre;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class MovieResponse {

    Long id;
    String title;
    String director;
    int releaseYear;
    Genre genre;
    double imdbRating;
}
