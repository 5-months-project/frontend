package com.example.frontend.Login;

import com.google.gson.annotations.SerializedName;

public class SignupModel {
    @SerializedName("username") private String username;
    @SerializedName("password") private String password;
    @SerializedName("authorityName") private String authorityName;
    public SignupModel(String username , String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}

    public String getpassword() {return password;}
    public void setpassword(String password) {this.password = password;}

    public String getauthorityName() {return authorityName;}
    public void setauthorityName(String authorityName) {this.username = authorityName;}

    @Override
    public String toString() {
        return "SignupModel{" +
                "authorityName='" + authorityName + '\'' +
                '}';
    }


}
