package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface LocationsApi {
    @GET("location")
    Call<JSONResponse> getLocations();
    @GET
    Call<Character>getCharacters(@Url String url);
}
