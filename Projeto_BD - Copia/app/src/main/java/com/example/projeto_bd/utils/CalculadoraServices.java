package com.example.projeto_bd.utils;

import com.example.projeto_bd.Calculadora;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CalculadoraServices {
    @GET("listar")
    Call<List<Calculadora>> getCalculadora();

    @POST("add")
    Call<Calculadora>addCalculo(@Body Calculadora calculadora);
    @POST("update/{id}")
    Call<Calculadora>updateCalculo(@Body Calculadora calculadora, @Path("id") int id);

    @POST("deleta/{id}")
    Call<Calculadora> deletaCalculo(@Path("id") int id);
}

