package com.example.jer.myproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn2 ;
    public static String jj="xxxx";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void SignUp(View view){

        startActivity(new Intent(MainActivity.this, MainSignUp.class));

    }
    public void Login(View view){

        startActivity(new Intent(MainActivity.this, MainLogin.class));

    }
}
