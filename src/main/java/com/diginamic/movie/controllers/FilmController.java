package com.diginamic.movie.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diginamic.movie.entities.FilmEntity;
import com.diginamic.movie.exceptions.NotFoundException;
import com.diginamic.movie.services.FilmService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:8081/")
public class FilmController {
    private FilmService filmService;


    public FilmController(FilmService filmService) {
		super();
		this.filmService = filmService;
	}


	@GetMapping("/films")
    public Iterable<FilmEntity> getFilms() {      
            return filmService.getFilms();
    }
	
	
}