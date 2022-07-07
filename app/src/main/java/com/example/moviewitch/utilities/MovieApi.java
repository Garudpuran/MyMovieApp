package com.example.moviewitch.utilities;

import com.example.moviewitch.response.MovieSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApi {
    // Search for movies
    // https://api.themoviedb.org/3/search/movie?api_key=f417a88e45af533fbc056083f9ba2c43&query=Jack+Reacher
@GET("/3/search/movie")
    Call<MovieSearchResponse> searchMovie(
       @Query("api_key") String key,
       @Query("query") String query,
       @Query("page") String page
    );
}
