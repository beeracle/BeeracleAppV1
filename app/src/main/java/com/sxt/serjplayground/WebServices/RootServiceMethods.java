package com.sxt.serjplayground.WebServices;

import com.sxt.serjplayground.DTOs.DTOComment;
import com.sxt.serjplayground.DTOs.DTOGrains;
import com.sxt.serjplayground.DTOs.DTORecipe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface RootServiceMethods
{

    @GET("comments")
    Call<ArrayList<DTOComment>> GetAllComments();

    @GET("Grains")
    Call<ArrayList<DTOGrains>> GetGrainsList();

    @GET("Recipes")
    Call<ArrayList<DTORecipe>> GetRecipesList();
}
