package com.kamilmosz.displaymoviesapp.model;

import androidx.lifecycle.MutableLiveData;

import com.kamilmosz.displaymoviesapp.network.MovieDataService;
import com.kamilmosz.displaymoviesapp.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private static final String TAG = "MovieRepository";
    private ArrayList<Movie> movies = new ArrayList<>();
    private MutableLiveData<List<Movie>> mutableLiveData = new MutableLiveData<>();

    public MovieRepository() {
    }

    public MutableLiveData<List<Movie>> getMutableLiveData() {
        final MovieDataService movieDataService = RetrofitClient.getService();
        Call<MovieDBResponse> call = movieDataService.getMovies();
        call.enqueue(new Callback<MovieDBResponse>() {
            @Override
            public void onResponse(Call<MovieDBResponse> call, Response<MovieDBResponse> response) {
                MovieDBResponse movieDBResponse = response.body();
                if (movieDBResponse != null && movieDBResponse.getMovie() != null) {
                    movies = (ArrayList<Movie>) movieDBResponse.getMovie();
                    mutableLiveData.setValue(movies);
                }
            }
            @Override
            public void onFailure(Call<MovieDBResponse> call, Throwable t) {
            }
        });
        return mutableLiveData;
    }

}
