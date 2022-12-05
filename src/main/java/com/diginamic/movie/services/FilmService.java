package com.diginamic.movie.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diginamic.movie.entities.FilmEntity;
import com.diginamic.movie.exceptions.NotFoundException;
import com.diginamic.movie.repos.FilmRepository;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepo;  
    
    
    
	public FilmService(FilmRepository filmRepo) {
		super();
		this.filmRepo = filmRepo;
	}



	public Iterable<FilmEntity> getFilms() {       
        return filmRepo.findAll();
    }
	
	
	
}