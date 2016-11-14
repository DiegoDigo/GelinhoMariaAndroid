package com.example.diego.gelinhomaria.api;

import com.example.diego.gelinhomaria.modes.SaboresGelinho;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by diego on 13/11/16.
 */

public interface EndPoints {

    @GET("v1/sabores")
    public Call<List<SaboresGelinho>> getSabores();

    @GET("v1/sabor/{id}")
    public Call<SaboresGelinho> getSabor();
}
