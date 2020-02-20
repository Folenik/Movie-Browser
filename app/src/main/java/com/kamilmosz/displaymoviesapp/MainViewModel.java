package com.kamilmosz.displaymoviesapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.kamilmosz.displaymoviesapp.model.Movie;
import com.kamilmosz.displaymoviesapp.model.MovieRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private MovieRepository movieRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        movieRepository = new MovieRepository();
    }

    public LiveData<List<Movie>> getAllMovies() {
        return movieRepository.getMutableLiveData();
    }
}
