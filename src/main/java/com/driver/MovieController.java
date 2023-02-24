package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    ResponseEntity<String> addMovie(@RequestBody() Movie movie) {
        movieService.addMovie(movie);
        return new ResponseEntity<>("Movie added Successfully", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    ResponseEntity<String> addDirector(@RequestBody() Director director) {
        movieService.addDirector(director);
        return new ResponseEntity<>("Director added Successfully", HttpStatus.CREATED);
    }

    @PutMapping("add-movie-director-pair")
    ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movieName, @RequestParam("director") String directorName) {
        movieService.addMovieDirectorPair(movieName, directorName);
        return new ResponseEntity<>("Movie Director Pair added Successfully", HttpStatus.CREATED);
    }


    @GetMapping("get-movie-by-name/{name}")
    ResponseEntity<Movie> getMovieByName(@PathVariable("name") String movieName) {
        Movie m = movieService.getMovieByName(movieName);
        return new ResponseEntity<>(m, HttpStatus.CREATED);
    }


    @GetMapping("get-director-by-name/{name}")
    ResponseEntity<Director> getDirectorByName(@PathVariable("name") String directorName) {
        Director d = movieService.getDirectorByName(directorName);
        return new ResponseEntity<>(d, HttpStatus.CREATED);
    }


    @GetMapping("get-movies-by-director-name/{director}")
    ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String directorName) {
        List<String> s = movieService.getMoviesByDirectorName(directorName);
        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }


    @GetMapping("get-all-movies")
    ResponseEntity<List<String>> findAllMovies() {
        List<String> s = movieService.findAllMovies();
        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }

    @DeleteMapping("delete-director-by-name")
    ResponseEntity<String> deleteDirectorByName(@RequestParam("name") String directorName) {
        movieService.deleteDirectorByName(directorName);
        return new ResponseEntity<>("delete director by name", HttpStatus.CREATED);
    }


    @DeleteMapping("delete-all-directors")
    ResponseEntity<String> deleteAllDirectors() {
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("all directors deleted successfully", HttpStatus.CREATED);
    }
}