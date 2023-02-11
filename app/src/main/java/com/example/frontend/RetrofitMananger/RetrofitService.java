package com.example.frontend.RetrofitMananger;

import com.example.frontend.Group.GroupModel;
import com.example.frontend.Login.SignupModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
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
    Call<TokenModel> hello();


    @POST("groups")//그룹 생성
    Call<GroupModel>creategroup(@Body GroupModel groupModel);

    @POST("groups")//그룹 리스트 조회
    Call<GroupModel>grouplist(@Body GroupModel groupModel);



    @GET("push/{tokens}")
    Call<String> insertToken(@Path("tokens") String tokens);

}
