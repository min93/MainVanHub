package com.example.jer.myproject;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;

public class MainLogin extends AppCompatActivity {

    private EditText edtlogin1, edtlogon2;
    private String edtString1, edtString2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        bindWidget();

    }

    private void bindWidget() {

        edtlogin1 = (EditText) findViewById(R.id.EditLogin1);
        edtlogon2 = (EditText) findViewById(R.id.EditLogin2);

    }

    public void clickLogin (View view){
        checkUser();
        startActivity(new Intent(MainLogin.this, MainShowlist.class));
    }

    private void checkUser() {

        edtString1 = edtlogin1.getText().toString();
        edtString2 = edtlogon2.getText().toString();

        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(threadPolicy);

        try {

            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("User", edtString1));
            nameValuePairs.add(new BasicNameValuePair("Pass", edtString2));

            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://192.168.105.1/login.php");
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
            httpClient.execute(httpPost);

            Toast.makeText(MainLogin.this, "ถูกต้อง", Toast.LENGTH_SHORT).show();
            finish();

        } catch (Exception e) {
            Toast.makeText(MainLogin.this, "ชื่อผู้ใช้และรหัสผ่านไม่ถูกต้อง", Toast.LENGTH_SHORT).show();
        }

    }
}
