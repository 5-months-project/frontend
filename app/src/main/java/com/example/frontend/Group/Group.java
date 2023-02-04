package com.example.frontend.Group;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.frontend.Calendar.CalendarAdapter;
import com.example.frontend.Calendar.Mainpage;
import com.example.frontend.Profile;
import com.example.frontend.R;

public class Group extends AppCompatActivity {

    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);



        String[][] sample = new String[2][4];
        sample[0][0] = "Project 3조 회의";
        sample[0][1] = "2023.01.27";
        sample[0][2] = "회의내용1";
        sample[0][3] = "회의내용2";
        sample[1][0] = "친구들 여행";
        sample[1][1] = "2023.02.06";
        sample[1][2] = "여행일정1";
        sample[1][3] = "여행일정2";


        final RecyclerView recyclerView = findViewById(R.id.recyclerView_group);
        recyclerView.setLayoutManager(layoutManager);
        adapter =new GroupAdapter(sample);
        recyclerView.setAdapter(adapter);

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