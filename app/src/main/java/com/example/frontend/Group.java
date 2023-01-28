package com.example.frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.frontend.Calendar.Mainpage;

public class Group extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        TextView profilebtn = findViewById(R.id.group_btn_profile);
        profilebtn.setOnClickListener(v -> {
            Intent i = new Intent(Group.this, Profile.class);
            startActivity(i);
        });
        TextView Calendarbtn = findViewById(R.id.group_btn_calendar);
        Calendarbtn.setOnClickListener(v -> {
            Intent i = new Intent(Group.this, Mainpage.class);
            startActivity(i);
        });
    }
}