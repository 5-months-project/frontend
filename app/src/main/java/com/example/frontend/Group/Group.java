package com.example.frontend.Group;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
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






        TextView schedulebtn = findViewById(R.id.btn_schedule_group);
        schedulebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        TextView createbtn = findViewById(R.id.btn_create);
        createbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //통신해서 데이터 받아옴
                dialog_create();



            }
        });
        TextView joinbtn = findViewById(R.id.btn_join);
        joinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_join();
            }
        });

        //sample에 서버와 통신한 데이터를 넣어주면 된다!
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

//        TextView profilebtn = findViewById(R.id.group_btn_profile);
//        profilebtn.setOnClickListener(v -> {
//            Intent i = new Intent(Group.this, Profile.class);
//            startActivity(i);
//        });
        TextView Calendarbtn = findViewById(R.id.group_btn_plan);
        Calendarbtn.setOnClickListener(v -> {
            Intent i = new Intent(Group.this, Mainpage.class);
            startActivity(i);
        });


    }
    public void dialog_join()//로그인 다이얼로그
    {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog.setContentView(R.layout.dialog_join);
        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
        params.width = dptopx(this, 400);
        params.height = dptopx(this, 300);

        final EditText code = dialog.findViewById(R.id.dialog_join_code);//
        final EditText pw = dialog.findViewById(R.id.dialog_join_pw);
        final TextView close = dialog.findViewById(R.id.dialog_join_close);
        dialog.getWindow().setAttributes(params);
        dialog.show();
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

        public void dialog_create() {
            Dialog dialog = new Dialog(this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            dialog.setContentView(R.layout.dialog_create);
            WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
            params.width = dptopx(this, 400);
            params.height = dptopx(this, 300);

            final EditText id = dialog.findViewById(R.id.dialog_create_id);//
            final EditText pw = dialog.findViewById(R.id.dialog_create_pw);
            final TextView close = dialog.findViewById(R.id.dialog_create_close);
            final TextView code = dialog.findViewById(R.id.dialog_create_code);
            final TextView createbtn = dialog.findViewById(R.id.dialog_create_create);
            final String[] account = new String[2];
            dialog.getWindow().setAttributes(params);
            dialog.show();
            id.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    account[0] = id.getText().toString();
                    Log.d("aaaaaa",account[0]);

                }
            });
            pw.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    account[1] = id.getText().toString();
                    Log.d("aaaaaa",account[0]);
                }
            });
            createbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //서버와 통신해서 그룹 이름과 패스워드를 받고 생성된 그룹 코드를 표기해준다(account[0] -> 그룹이름 account[1] -> 패스워드)
                    code.setText("generatedgroupcode123");
                }
            });
            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
        }



    public int dptopx(Context context , int dp)//dp단위를 px로 바꿔준다
    {
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);

    }
}