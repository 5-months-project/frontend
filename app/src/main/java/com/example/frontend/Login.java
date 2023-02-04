package com.example.frontend;

import static com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState.ANCHORED;
import static com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState.COLLAPSED;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.frontend.Calendar.Mainpage;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView loginbtn = findViewById(R.id.btn_login);
        EditText login_id = findViewById(R.id.editText_id);
        EditText login_password = findViewById(R.id.editText_pw);
        EditText res_id = findViewById(R.id.editText_register_id);
        EditText res_pw = findViewById(R.id.editText_register_pw);
        TextView registbtn = findViewById(R.id.btn_regis_account);
        TextView slidetap = findViewById(R.id.btn_register);
        final String[] id = new String[1];
        final String[] pw = new String[1];
        SlidingUpPanelLayout slidingUpPanelLayout = findViewById(R.id.main_frame);
        registbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //등록 버튼을 눌렀을 때 id[1] , pw[1]를 서버로 넘겨서 회원가입을 진행하면 된다
            }
        });

        //edittext에서 텍스트 받아오는 코드
        login_id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {//입력하기 전에
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {//입력창에 변화가 있을 때
            }
            @Override
            public void afterTextChanged(Editable s) {//입력이 끝나고 난 후
                id[0] = login_id.getText().toString();
                Log.d("aaaaaaa",id[0]);
            }
        });
        login_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                pw[0] = login_password.getText().toString();
                Log.d("aaaaaaa",pw[0]);
            }
        });
        res_id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {//입력하기 전에
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {//입력창에 변화가 있을 때
            }
            @Override
            public void afterTextChanged(Editable s) {//입력이 끝나고 난 후
                id[0] = res_id.getText().toString();
                Log.d("aaaaaaa",id[0]);
            }
        });
        res_pw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                pw[0] = res_pw.getText().toString();
                Log.d("aaaaaaa",pw[0]);
            }
        });
        //로그인 버튼
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //로그인 버튼을 눌렀을 때 서버에서 회원정보를 조회하여 로그인 여부를 판단하여 페이지를 넘기면 된다.
                Intent i = new Intent(Login.this , Mainpage.class);
                startActivity(i);
            }
        });
        //회원가입 탭 여는 코드
        slidetap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SlidingUpPanelLayout.PanelState state = slidingUpPanelLayout.getPanelState();
                if (state == COLLAPSED) {
                    slidingUpPanelLayout.setPanelState(ANCHORED);
                }
                else if (state == SlidingUpPanelLayout.PanelState.ANCHORED) {
                    slidingUpPanelLayout.setPanelState(COLLAPSED);
                }
            }
        });

    }
}