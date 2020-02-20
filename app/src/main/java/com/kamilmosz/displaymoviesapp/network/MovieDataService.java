package com.kamilmosz.displaymoviesapp.network;

import com.kamilmosz.displaymoviesapp.model.MovieDBResponse;

import retrofit2.Call;
import retrofit2.http.GET;


public interface MovieDataService {
    @GET("now_playing?api_key=36a9335b97de344e540bf46e01cbc67a&language=en-US&page=1")
    Call<MovieDBResponse> getMovies();
}
