package com.diginamic.movie.repos;

import org.springframework.data.repository.CrudRepository;
import com.diginamic.movie.entities.FilmEntity;

public interface FilmRepository extends CrudRepository<FilmEntity, Long> {
    
}