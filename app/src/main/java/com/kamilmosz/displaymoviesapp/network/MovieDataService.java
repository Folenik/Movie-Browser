package com.kamilmosz.displaymoviesapp.network;

public class MovieDataService {
    @GET("users/?per_page=12&page=1")
    Call<EmployeeDBResponse> getEmployees();
}
