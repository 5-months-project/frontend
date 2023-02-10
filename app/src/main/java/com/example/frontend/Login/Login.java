package com.example.frontend.Login;

import static com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState.ANCHORED;
import static com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState.COLLAPSED;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.frontend.Calendar.Mainpage;
import com.example.frontend.R;
import com.example.frontend.RetrofitMananger.AuthenticateModel;
import com.example.frontend.RetrofitMananger.RetrofitInstance;
import com.example.frontend.RetrofitMananger.RetrofitService;
import com.example.frontend.RetrofitMananger.TokenModel;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Login extends AppCompatActivity {

    private final Retrofit retrofit = null;



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
        final TokenModel[] hel = new TokenModel[1];
        final AuthenticateModel[] res_aut = new AuthenticateModel[1];
        final String[] id = new String[2];
        final String[] pw = new String[2];

        SlidingUpPanelLayout slidingUpPanelLayout = findViewById(R.id.main_frame);
//        slidingUpPanelLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                hideKeyboard();
//            }
//        });
        registbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignupModel signupModel = new SignupModel(
                        id[1],
                        pw[1]
                );
                Call<SignupModel> call = RetrofitInstance.getApiService().signup(signupModel);
                call.enqueue(new Callback<SignupModel>() {
                    @Override
                    public void onResponse(Call<SignupModel> call, Response<SignupModel> response) {
                        String result = response.body().toString();
                        Log.d("TAGGGG","result is : "+result);
                        Toast.makeText(getApplicationContext(), "success!" , Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onFailure(Call<SignupModel> call, Throwable t) {
                        Log.d("fail",t.getMessage());
                    }
                });
            }
        });
        TextView tokenbtn = findViewById(R.id.tokenbtn);
        tokenbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AuthenticateModel authenticateModel = new AuthenticateModel(
                        id[0],
                        pw[0]
                );
                Call<AuthenticateModel> call = RetrofitInstance.getApiService().gettoken(authenticateModel);
                call.enqueue(new Callback<AuthenticateModel>() {
                    @Override
                    public void onResponse(Call<AuthenticateModel> call, Response<AuthenticateModel> response) {
                        res_aut[0] = response.body();
                        Log.d("Ttttttt","result is : "+res_aut[0].gettoken());
                        Toast.makeText(getApplicationContext(), "success!" , Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onFailure(Call<AuthenticateModel> call, Throwable t) {
                        Log.d("fail",t.getMessage());
                    }
                });
            }
        });
        TextView hello = findViewById(R.id.hello);
        hello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<TokenModel> call = RetrofitInstance.getApiService().hello(res_aut[0].gettoken());
                call.enqueue(new Callback<TokenModel>() {
                    @Override
                    public void onResponse(Call<TokenModel> call, Response<TokenModel> response) {
                        hel[0] = response.body();
                        Log.d("이거 되나요?",hel[0].getresponse());
                    }
                    @Override
                    public void onFailure(Call<TokenModel> call, Throwable t) {
                    }
                });


            }
        });

        //edittext에서 텍스트 받아오는 코드
        //로그인 edittext는 id[0] pw[0]에 저장하고 회원가입은 id[1] pw[1]에 저장
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
                id[1] = res_id.getText().toString();
                Log.d("aaaaaaa",id[1]);
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
                pw[1] = res_pw.getText().toString();
                Log.d("aaaaaaa",pw[1]);
            }
        });

        login_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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