package com.driver;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {


    HashMap<String, Movie> movieHashMap = new HashMap<>();
    HashMap<String, Director> directorHashMap = new HashMap<>();
    HashMap<String, List<String>> movieDirectorHashMap = new HashMap<>();


    public void addMovie(Movie movie) {
        if (movieHashMap.containsKey(movie.getName())) {
            return;
        } else {
            movieHashMap.put(movie.getName(), movie);
        }
    }

    public void addDirector(Director director) {
        if (directorHashMap.containsKey(director.getName())) {
            return;
        } else {
            directorHashMap.put(director.getName(), director);
        }
    }

    public void addMovieDirectorPair(String movieName, String directorName) {
        if (movieDirectorHashMap.containsKey(directorName)) {
            movieDirectorHashMap.get(directorName).add(movieName);
        } else {
            List<String> m = new ArrayList<>();
            m.add(movieName);
            movieDirectorHashMap.put(directorName, m);
        }
    }

    public Movie getMovieByName(String movieName) {
        return movieHashMap.get(movieName);
    }

    public Director getDirectorByName(String directorName) {
        return directorHashMap.get(directorName);
    }

    public List<String> getMoviesByDirectorName(String directorName) {
        return new ArrayList<>(movieDirectorHashMap.get(directorName));
    }

    public List<String> findAllMovies() {
        return new ArrayList<>(movieHashMap.keySet());
    }

    public void deleteDirectorByName(String directorName) {
        List<String> l = new ArrayList<>(movieDirectorHashMap.get(directorName));

        movieDirectorHashMap.remove(directorName);
        directorHashMap.remove(directorName);
        for (String s : l) {
            movieHashMap.remove(s);
        }
    }

    public void deleteAllDirectors() {
        List<String> l = new ArrayList<>();

        for (String s : movieDirectorHashMap.keySet()) {
            for (String k : movieDirectorHashMap.get(s)) {
                l.add(k);
            }
        }

        movieDirectorHashMap.clear();
        directorHashMap.clear();
        for (String s : l) {
            movieHashMap.remove(s);
        }
    }
}
