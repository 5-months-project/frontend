package com.example.frontend.Group;

import com.google.gson.annotations.SerializedName;

public class GroupModel {

    @SerializedName("group_name")
    private String group_name;

    @SerializedName("group_code")
    private String group_code;

    @SerializedName("group_password")
    private String group_password;

    @SerializedName("group_created_at")
    private String group_created_at;

    @SerializedName("group_updated_at")
    private String group_updated_at;

    public String getgroup_name() {return group_name;}

    public void setgroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getgroup_code() {
        return group_code;
    }

    public void setgroup_code(String group_code) {
        this.group_code = group_code;
    }

    public String getgroup_password() {
        return group_password;
    }

    public void setgroup_password(String group_password) {
        this.group_password = group_password;
    }

    public String toString() {
        return "CalendarModel{" +
                "group_name='" + group_name + '\'' +
                ", group_code='" + group_code + '\'' +
                ", group_password='" + group_password + '\'' +
                ", group_created_at='" + group_created_at + '\'' +
                '}';
    }

}
