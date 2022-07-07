package com.example.moviewitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.moviewitch.models.MovieModel;
import com.example.moviewitch.requests.Services;
import com.example.moviewitch.response.MovieSearchResponse;
import com.example.moviewitch.utilities.Credentials;
import com.example.moviewitch.utilities.MovieApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;

public class MovieListActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetRetrofitResponse();
            }
        });
    }

    private void GetRetrofitResponse() {
        MovieApi movieApi = Services.getMovieApi();

        Call<MovieSearchResponse> responseCall = movieApi
                .searchMovie(Credentials.API_KEY,"Action","1");
        responseCall.enqueue(new Callback<MovieSearchResponse>() {
            @Override
            public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {

                if(response.code() == 200){

                    Log.v("Tag","the response:"+response.body().toString());

                    List<MovieModel> movies = new ArrayList<>(response.body().getMovies());

                    for(MovieModel movie : movies){
                        Log.v("Tag","The release date: "+movie.getTitle());
                    }
                }
                else{
                    Log.v("Tag","Error: "+response.errorBody().toString());
                }

            }

            @Override
            public void onFailure(Call<MovieSearchResponse> call, Throwable t) {

            }
        });
    }
}