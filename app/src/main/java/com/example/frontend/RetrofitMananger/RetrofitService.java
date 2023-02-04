package com.example.frontend.RetrofitMananger;

import com.example.frontend.Calendar.CalendarModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {

    @GET("getCalendar")
    Call<List<CalendarModel>> getCalendar();


    @GET("push/{tokens}")
    Call<String> insertToken(@Path("tokens") String tokens);

}
