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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void check(View view){
        int points = 0;
        RadioGroup radioGroup;
        //Let us check the first answer
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup_q1);
        if(radioGroup.getCheckedRadioButtonId()==R.id.rB_1b){
            points++;
        }
        //Let us check the rest radio button answers
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup_q2);
        if(radioGroup.getCheckedRadioButtonId()==R.id.rB_2a){
            points++;
        }
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup_q3);
        if(radioGroup.getCheckedRadioButtonId()==R.id.rB_3b){
            points++;
        }
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup_q4);
        if(radioGroup.getCheckedRadioButtonId()==R.id.rB_4c){
            points++;
        }
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup_q5);
        if(radioGroup.getCheckedRadioButtonId()==R.id.rB_5c){
            points++;
        }
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup_q6);
        if(radioGroup.getCheckedRadioButtonId()==R.id.rB_6b){
            points++;
        }
        //Let us check now the Check Boxes question
        CheckBox cB_7a = (CheckBox) findViewById(R.id.checkBox_7a);
        CheckBox cB_7b = (CheckBox) findViewById(R.id.checkBox_7b);
        CheckBox cB_7c = (CheckBox) findViewById(R.id.checkBox_7c);
        if(cB_7a.isChecked()){
            if(cB_7b.isChecked()){
                if(cB_7c.isChecked()==false){
                    points++;
                }
            }
        }
        //Take the name from EditText
        EditText editText_name = (EditText) findViewById(R.id.editText_name);
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
