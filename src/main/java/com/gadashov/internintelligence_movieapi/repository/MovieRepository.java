package com.gadashov.internintelligence_movieapi.repository;

import com.gadashov.internintelligence_movieapi.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
