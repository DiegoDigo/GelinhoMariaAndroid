package com.example.diego.gelinhomaria.api;

import com.example.diego.gelinhomaria.modes.SaboresGelinho;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;

/**
 * Created by diego on 13/11/16.
 */

public interface EndPoints {

    @Headers({"Authorization: Token 4a388a5bb3a1f8d0677233d2758433c693e37eed"})
    @GET("v1/sabores")
    public Call<List<SaboresGelinho>> getSabores();

    @Headers({"Authorization: Token 4a388a5bb3a1f8d0677233d2758433c693e37eed"})
    @GET("v1/sabor/{id}")
    public Call<SaboresGelinho> getSabor(@Path("id") Long id);
}
