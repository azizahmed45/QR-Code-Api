package com.mrgreenapps.qrcodeapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    public static final String BASE_URL = "https://eventeasy.nl/";

    private Retrofit retrofit;
    private ApiClient apiClient;
    private HttpLoggingInterceptor loggingInterceptor;
    private OkHttpClient okHttpClient;

    public ApiService() {
        loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient = new OkHttpClient.Builder()
                //debug
                .addInterceptor(loggingInterceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();


        Gson gson = new GsonBuilder()
                .setDateFormat("yyy-MM-dd HH:mm:ss")
                //For (fix) null value skip
                .serializeNulls()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();

        apiClient = retrofit.create(ApiClient.class);
    }

    public Call<ResponseModel> getResult(String input){
        return apiClient.getResult(input);
    }
}