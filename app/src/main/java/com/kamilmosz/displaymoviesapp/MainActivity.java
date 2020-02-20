package com.kamilmosz.displaymoviesapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kamilmosz.displaymoviesapp.adapter.MovieDataAdapter;
import com.kamilmosz.displaymoviesapp.databinding.ActivityMainBinding;
import com.kamilmosz.displaymoviesapp.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MainViewModel mainViewModel;
    private MovieDataAdapter movieDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);

        recyclerView = activityMainBinding.recyclerView;

        setup();
        getMovies();
    }


    private void setup() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        movieDataAdapter = new MovieDataAdapter();
        recyclerView.setAdapter(movieDataAdapter);
    }

    private void getMovies() {
        mainViewModel.getAllMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(@Nullable List<Movie> movies) {
                movieDataAdapter.setMovieList((ArrayList<Movie>) movies);
            }
        });
    }

}
