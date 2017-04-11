package com.example.android.quiz_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    //Layout Elements
    RadioGroup radioGroup_q1;
    RadioGroup radioGroup_q2;
    RadioGroup radioGroup_q3;
    RadioGroup radioGroup_q4;
    RadioGroup radioGroup_q5;
    RadioGroup radioGroup_q6;
    CheckBox checkBox_7a;
    CheckBox checkBox_7b;
    CheckBox checkBox_7c;
    EditText editText_name ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initiate layout elements
        radioGroup_q1 = (RadioGroup) findViewById(R.id.radioGroup_q1);
        radioGroup_q2 = (RadioGroup) findViewById(R.id.radioGroup_q2);
        radioGroup_q3 = (RadioGroup) findViewById(R.id.radioGroup_q3);
        radioGroup_q4 = (RadioGroup) findViewById(R.id.radioGroup_q4);
        radioGroup_q5 = (RadioGroup) findViewById(R.id.radioGroup_q5);
        radioGroup_q6 = (RadioGroup) findViewById(R.id.radioGroup_q6);
        checkBox_7a = (CheckBox) findViewById(R.id.checkBox_7a);
        checkBox_7b = (CheckBox) findViewById(R.id.checkBox_7b);
        checkBox_7c = (CheckBox) findViewById(R.id.checkBox_7c);
        editText_name = (EditText) findViewById(R.id.editText_name);
    }

    public void check(View view){
        int points = 0;

        //Let us check the first answer
        if(radioGroup_q1.getCheckedRadioButtonId()==R.id.rB_1b){
            points++;
        }
        //Let us check the rest radio button answers
        if(radioGroup_q2.getCheckedRadioButtonId()==R.id.rB_2a){
            points++;
        }
        if(radioGroup_q3.getCheckedRadioButtonId()==R.id.rB_3b){
            points++;
        }
        if(radioGroup_q4.getCheckedRadioButtonId()==R.id.rB_4c){
            points++;
        }
        if(radioGroup_q5.getCheckedRadioButtonId()==R.id.rB_5c){
            points++;
        }
        if(radioGroup_q6.getCheckedRadioButtonId()==R.id.rB_6b){
            points++;
        }

        //Let us check now the Check Boxes question
        if(checkBox_7a.isChecked()){
            if(checkBox_7b.isChecked()){
                if(checkBox_7c.isChecked()==false){
                    points++;
                }
            }
        }

        //Take the name from EditText
        String name = editText_name.getText().toString();

        //Create feedback message
        String feedback = getString(R.string.quiz_summary_points,points);
        if(points>=4) {
            feedback += "\n" + getString(R.string.quiz_summary_ok, name);
        }else{
            feedback += "\n" + getString(R.string.quiz_summary_wrong, name);
        }

        //Give the feedback in Toast message
        Toast.makeText(getApplicationContext(), feedback, Toast.LENGTH_SHORT).show();
    }
}
