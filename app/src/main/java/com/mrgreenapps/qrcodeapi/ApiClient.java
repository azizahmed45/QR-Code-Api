package com.mrgreenapps.qrcodeapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiClient {
    @GET("qrcheck")
    public Call<ResponseModel> getResult(@Query("input") String input);
}
