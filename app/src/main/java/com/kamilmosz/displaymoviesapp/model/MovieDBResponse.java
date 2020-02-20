package com.kamilmosz.displaymoviesapp.model;

import com.kamilmosz.displaymoviesapp.model.Movie;

import java.util.List;

public class MovieDBResponse {

    @SerializedName("data")
    @Expose
    private List<Movie> movie = null;

    public List<Movie> getMovie() {
        return movie;
    }

    public void setMovie(List<Movie> movie) {
        this.movie = movie;

    }
}
