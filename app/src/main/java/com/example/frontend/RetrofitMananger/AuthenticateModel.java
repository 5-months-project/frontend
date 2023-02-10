package com.example.frontend.RetrofitMananger;

import com.google.gson.annotations.SerializedName;

public class AuthenticateModel {
    @SerializedName("username") private String username;
    @SerializedName("password") private String password;
    @SerializedName("token") private String token;
    public AuthenticateModel(String username , String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}

    public String getpassword() {return password;}
    public void setpassword(String password) {this.password = password;}

    public String gettoken() {return token;}
    public void settoken(String token) {this.token = token;}

    @Override
    public String toString() {
        return "AuthenticateModel{" +
                "token='" + token + '\'' +
                '}';
    }
}
