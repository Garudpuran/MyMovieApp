package com.example.moviewitch.requests;

import com.example.moviewitch.utilities.Credentials;
import com.example.moviewitch.utilities.MovieApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Services {

    private static  Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
                    .baseUrl(Credentials.Base_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static  Retrofit retrofit = retrofitBuilder.build();

    private static MovieApi movieApi = retrofit.create(MovieApi.class);

    public static MovieApi getMovieApi(){
        return movieApi;
    }

}
