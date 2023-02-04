package com.example.frontend.Calendar;

import com.google.gson.annotations.SerializedName;

public class CalendarModel {

    @SerializedName("schedule_name")
    private String schedule_name;

    @SerializedName("schedule_content")
    private String schedule_content;

    @SerializedName("schedule_time_from")
    private String schedule_time_from;

    @SerializedName("schedule_time_to")
    private String schedule_time_to;

    @SerializedName("schedule_creator")
    private String schedule_creator;

    @SerializedName("schedule_created_at")
    private String schedule_created_at;

    @SerializedName("schedule_updated_at")
    private String schedule_updated_at;

    @SerializedName("schedule_group_id")
    private String schedule_group_id;

    public String getschedule_name() {return schedule_name;}

    public void setschedule_name(String schedule_name) {
        this.schedule_name = schedule_name;
    }

    public String getschedule_content() {
        return schedule_content;
    }

    public void setschedule_content(String schedule_content) {
        this.schedule_content = schedule_content;
    }

    public String getschedule_time_from() {
        return schedule_time_from;
    }

    public void setschedule_time_to(String schedule_time_to) {
        this.schedule_time_to = schedule_time_to;
    }

    public String toString() {
        return "CalendarModel{" +
                "schedule_name='" + schedule_name + '\'' +
                ", schedule_content='" + schedule_content + '\'' +
                ", schedule_time_from='" + schedule_time_from + '\'' +
                ", schedule_time_to='" + schedule_time_to + '\'' +
                '}';
    }

}
