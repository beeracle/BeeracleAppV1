package com.sxt.serjplayground.WebServices;

import com.sxt.serjplayground.WebServices.Interceptors.WaitInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Serj on 07/03/2017.
 */

public class LazyServiceManager
{

    private static LazyServiceManager instance = null;
    public static final String BASE_URL = "http://192.168.0.111:14047/api/";

    private RootServiceMethods mainServiceMethods;

    public static LazyServiceManager getInstance() {
        if (instance == null) {
            instance = new LazyServiceManager();
        }

        return instance;
    }

    private LazyServiceManager() {
        buildRetrofit(BASE_URL);
    }

    private void buildRetrofit(String baseUrl) {


        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new WaitInterceptor());
        OkHttpClient client = httpClient.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        this.mainServiceMethods = retrofit.create(RootServiceMethods.class);
    }

    public RootServiceMethods getRootMethods() {
        return this.mainServiceMethods;
    }


}
