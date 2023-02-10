package com.example.frontend.RetrofitMananger;

import com.example.frontend.Login.SignupModel;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitService {



    @POST("signup")
    Call<SignupModel> signup(@Body SignupModel signupmodel);

    @POST("authenticate")
    Call<AuthenticateModel> gettoken(@Body AuthenticateModel authenticateModel);

    @GET("hello")
    Call<TokenModel> hello(@Path("bearer token") String token);


    @GET("push/{tokens}")
    Call<String> insertToken(@Path("tokens") String tokens);

}
