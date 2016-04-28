package com.example.jer.myproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainSignUp extends AppCompatActivity {

    private EditText Edit1, Edit2, Edit3, Edit4, Edit5, Edit6, Edit7, Edit8, Edit9;
    private Spinner spinStart, spinStop;
    public static String startString, stopString,StringEdit1, StringEdit2, StringEdit3, StringEdit4,
            StringEdit5, StringEdit6, StringEdit7, StringEdit8, StringEdit9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sign_up);

        bindWidget();

        spinnerTime();

    }

    public void signup_next1(View view){

        StringEdit1 = Edit1.getText().toString();
        StringEdit2 = Edit2.getText().toString();
        StringEdit3 = Edit3.getText().toString();
        StringEdit4 = Edit4.getText().toString();
        StringEdit5 = Edit5.getText().toString();
        StringEdit6 = Edit6.getText().toString();
        StringEdit7 = Edit7.getText().toString();
        StringEdit8 = Edit8.getText().toString();
        StringEdit9 = Edit9.getText().toString();

        if (StringEdit1.equals("") ||
                StringEdit2.equals("") ||
                StringEdit3.equals("") ||
                StringEdit4.equals("") ||
                StringEdit5.equals("") ||
                StringEdit6.equals("") ||
                StringEdit7.equals("") ||
                StringEdit8.equals("") ||
                StringEdit9.equals("")) {

            MyAlertDialog objMyAlertDialog = new MyAlertDialog();
            objMyAlertDialog.myDialog(MainSignUp.this, R.drawable.danger,
                    "Have Space", "Please Fill All Blank");

        } else {

            //No Space
            startActivity(new Intent(MainSignUp.this, MainSignUp2.class));

        }



    }
    private void spinnerTime() {

        //spinner เวลาเปิดบริการ
        final String[] startProvinceStrings = getResources().getStringArray(R.array.time_start);
        ArrayAdapter<String> startArrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, startProvinceStrings);
        spinStart.setAdapter(startArrayAdapter);
        spinStart.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                startString = startProvinceStrings[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                startString = startProvinceStrings[0];
            }
        });

        //spinner เวลาปิดบริการ
        final String[] stopProvinceStrings = getResources().getStringArray(R.array.time_stop);
        ArrayAdapter<String> stopArrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, stopProvinceStrings);
        spinStop.setAdapter(stopArrayAdapter);
        spinStop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                stopString = stopProvinceStrings[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                stopString = stopProvinceStrings[0];
            }
        });
    }

    public void bindWidget() {

        Edit1 = (EditText) findViewById(R.id.Edit_Data_1);
        Edit2 = (EditText) findViewById(R.id.Edit_Data_2);
        Edit3 = (EditText) findViewById(R.id.Edit_Data_3);
        Edit4 = (EditText) findViewById(R.id.Edit_Data_4);
        Edit5 = (EditText) findViewById(R.id.Edit_Data_5);
        Edit6 = (EditText) findViewById(R.id.Edit_Data_6);
        Edit7 = (EditText) findViewById(R.id.Edit_Data_7);
        Edit8 = (EditText) findViewById(R.id.Edit_Data_8);
        Edit9 = (EditText) findViewById(R.id.Edit_Data_9);
        spinStart = (Spinner) findViewById(R.id.spinner3);
        spinStop = (Spinner) findViewById(R.id.spinner4);

    }
}
