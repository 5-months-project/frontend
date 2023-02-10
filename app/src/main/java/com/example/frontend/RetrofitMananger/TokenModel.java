package com.example.frontend.RetrofitMananger;

import com.google.gson.annotations.SerializedName;

public class TokenModel {
    @SerializedName("response") private String response;

    public String getresponse() {return response;}
    public void setresponse(String response) {this.response = response;}

    @Override
    public String toString() {
        return "Tokenmodel{" +
                "response='" + response + '\'' +
                '}';
    }


}
