package com.example.frontend.Calendar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.frontend.Group;
import com.example.frontend.Profile;
import com.example.frontend.R;

import org.w3c.dom.Text;

import java.time.LocalDate;
import java.util.Calendar;

public class Mainpage extends AppCompatActivity {


    LocalDate yeardate;
    public static TextView dt[] = new TextView[42];
    public static FrameLayout btn_dt[] = new FrameLayout[42];
    public static int[] inttmp  = new int[2];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);



        TextView profilebtn = findViewById(R.id.calendar_btn_profile);
        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Mainpage.this, Profile.class);
                startActivity(i);
            }
        });//페이지 넘기는 코드(to profile)
        TextView groupbtn = findViewById(R.id.calendar_btn_group);
        groupbtn.setOnClickListener(v -> {
            Intent i = new Intent(Mainpage.this, Group.class);
            startActivity(i);
        });//페이지 넘기는 코드(to group)


        //달력에 날짜 설정
        yeardate = LocalDate.now();
        String tmp = yeardate.toString();
        String[] date = tmp.split("-");
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.set(Integer.parseInt(date[0]),Integer.parseInt(date[1])-1,1);
        end.set(Integer.parseInt(date[0]),Integer.parseInt(date[1]),1);
        end.add(Calendar.DATE,-1);
        int Start_day = start.get(Calendar.DAY_OF_WEEK);
        int End_day = end.get(Calendar.DATE);
        setdate(Start_day,End_day);




        //일정
        btn_dt[0] = findViewById(R.id.case_1);
        btn_dt[1] = findViewById(R.id.case_2);
        btn_dt[2] = findViewById(R.id.case_3);
        btn_dt[3] = findViewById(R.id.case_4);
        btn_dt[4] = findViewById(R.id.case_5);
        btn_dt[5] = findViewById(R.id.case_6);
        btn_dt[6] = findViewById(R.id.case_7);
        btn_dt[7] = findViewById(R.id.case_8);
        btn_dt[8] = findViewById(R.id.case_9);
        btn_dt[9] = findViewById(R.id.case_10);
        btn_dt[10] = findViewById(R.id.case_11);
        btn_dt[11] = findViewById(R.id.case_12);
        btn_dt[12] = findViewById(R.id.case_13);
        btn_dt[13] = findViewById(R.id.case_14);
        btn_dt[14] = findViewById(R.id.case_15);
        btn_dt[15] = findViewById(R.id.case_16);
        btn_dt[16] = findViewById(R.id.case_17);
        btn_dt[17] = findViewById(R.id.case_18);
        btn_dt[18] = findViewById(R.id.case_19);
        btn_dt[19] = findViewById(R.id.case_20);
        btn_dt[20] = findViewById(R.id.case_21);
        btn_dt[21] = findViewById(R.id.case_22);
        btn_dt[22] = findViewById(R.id.case_23);
        btn_dt[23] = findViewById(R.id.case_24);
        btn_dt[24] = findViewById(R.id.case_25);
        btn_dt[25] = findViewById(R.id.case_26);
        btn_dt[26] = findViewById(R.id.case_27);
        btn_dt[27] = findViewById(R.id.case_28);
        btn_dt[28] = findViewById(R.id.case_29);
        btn_dt[29] = findViewById(R.id.case_30);
        btn_dt[30] = findViewById(R.id.case_31);
        btn_dt[31] = findViewById(R.id.case_32);
        btn_dt[32] = findViewById(R.id.case_33);
        btn_dt[33] = findViewById(R.id.case_34);
        btn_dt[34] = findViewById(R.id.case_35);
        btn_dt[35] = findViewById(R.id.case_36);
        btn_dt[36] = findViewById(R.id.case_37);
        btn_dt[37] = findViewById(R.id.case_38);
        btn_dt[38] = findViewById(R.id.case_39);
        btn_dt[39] = findViewById(R.id.case_40);
        btn_dt[40] = findViewById(R.id.case_41);
        btn_dt[41] = findViewById(R.id.case_42);


        for(int i = 0 ; i < 42 ; i ++)
        {
            btn_dt[i].setTag(i);
            btn_dt[i].setOnClickListener(dialogclicklistener);
        }
    }

    private final View.OnClickListener dialogclicklistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int t = (int)v.getTag();//t는 몇번째 칸인지 표시 -> 요일 계산
            dialog(t, Integer.parseInt((String) dt[t].getText()));//dt에는 cal_txt가 들어가있고 여기엔 그날이 몇일인지 표시
        }
    };
    public void dialog(int day, int date)
    {

        View dialogView = getLayoutInflater().inflate(R.layout.dialog,null);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,dptopx(this,400));
        dialogView.setLayoutParams(params);
        final TextView dialogdate = dialogView.findViewById(R.id.dialog_date);
        final TextView dialogday = dialogView.findViewById(R.id.dialog_day);
        dialogdate.setText(String.valueOf(date));
        if(day==0||day==7||day==14||day==21||day==28||day==35) dialogday.setText("Sunday");
        else if(day==1||day==8||day==15||day==22||day==29||day==36) dialogday.setText("Monday");
        else if(day==2||day==9||day==16||day==23||day==30||day==37) dialogday.setText("Tuesday");
        else if(day==3||day==10||day==17||day==24||day==31||day==38) dialogday.setText("Wednesday");
        else if(day==4||day==11||day==18||day==25||day==32||day==39) dialogday.setText("Thursday");
        else if(day==5||day==12||day==19||day==26||day==33||day==40) dialogday.setText("Friday");
        else if(day==6||day==13||day==20||day==27||day==34||day==41) dialogday.setText("Saturday");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    public int dptopx(Context context , int dp)
    {
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);

    }
    public void setdate(int start, int end)//달력 날짜 설정해주는 함수
    {

        dt[0] = findViewById(R.id.cal_txt_1);
        dt[1] =findViewById(R.id.cal_txt_2);
        dt[2] =findViewById(R.id.cal_txt_3);
        dt[3] = findViewById(R.id.cal_txt_4);
        dt[4] =findViewById(R.id.cal_txt_5);
        dt[5] =findViewById(R.id.cal_txt_6);
        dt[6] =findViewById(R.id.cal_txt_7);
        dt[7] =findViewById(R.id.cal_txt_8);
        dt[8] =findViewById(R.id.cal_txt_9);
        dt[9] =findViewById(R.id.cal_txt_10);
        dt[10] =findViewById(R.id.cal_txt_11);
        dt[11] =findViewById(R.id.cal_txt_12);
        dt[12] =findViewById(R.id.cal_txt_13);
        dt[13] =findViewById(R.id.cal_txt_14);
        dt[14] =findViewById(R.id.cal_txt_15);
        dt[15] =findViewById(R.id.cal_txt_16);
        dt[16] =findViewById(R.id.cal_txt_17);
        dt[17] =findViewById(R.id.cal_txt_18);
        dt[18] =findViewById(R.id.cal_txt_19);
        dt[19] =findViewById(R.id.cal_txt_20);
        dt[20] =findViewById(R.id.cal_txt_21);
        dt[21] =findViewById(R.id.cal_txt_22);
        dt[22] =findViewById(R.id.cal_txt_23);
        dt[23] =findViewById(R.id.cal_txt_24);
        dt[24] =findViewById(R.id.cal_txt_25);
        dt[25] =findViewById(R.id.cal_txt_26);
        dt[26] =findViewById(R.id.cal_txt_27);
        dt[27] =findViewById(R.id.cal_txt_28);
        dt[28] =findViewById(R.id.cal_txt_29);
        dt[29] =findViewById(R.id.cal_txt_30);
        dt[30] =findViewById(R.id.cal_txt_31);
        dt[31] =findViewById(R.id.cal_txt_32);
        dt[32] =findViewById(R.id.cal_txt_33);
        dt[33] =findViewById(R.id.cal_txt_34);
        dt[34] =findViewById(R.id.cal_txt_35);
        dt[35] =findViewById(R.id.cal_txt_36);
        dt[36] =findViewById(R.id.cal_txt_37);
        dt[37] =findViewById(R.id.cal_txt_38);
        dt[38] =findViewById(R.id.cal_txt_39);
        dt[39] =findViewById(R.id.cal_txt_40);
        dt[40] =findViewById(R.id.cal_txt_41);
        dt[41] =findViewById(R.id.cal_txt_42);
        ViewGroup layout6 = findViewById(R.id.viewgroup6);
        layout6.setVisibility(View.VISIBLE);
        for(int i = 0 ; i < 42; i++)
        {
            dt[i].setText("");
        }
        int k = 1;
        for(int i = 1 ; i < start+end ; i++)
        {
            if(i>=start)
            {
                dt[i-1].setText(""+k); k++;
            }
        }
        if(dt[35].getText() == "")
        {
            layout6.setVisibility(View.GONE);
        }
    }
}