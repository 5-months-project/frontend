package com.example.frontend.RetrofitMananger;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthenticationInterceptor implements Interceptor {
    private final String authToken;

    public AuthenticationInterceptor(String token) {
        this.authToken = token;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        if(authToken!= null) {

            Request.Builder builder = original.newBuilder()
                    .header("Authorization", authToken);


            Request request = builder.build();

            return chain.proceed(request);
        }
        else {
            Request.Builder builder = original.newBuilder();
            Request request = builder.build();
            return chain.proceed(request);
        }
    }
}
