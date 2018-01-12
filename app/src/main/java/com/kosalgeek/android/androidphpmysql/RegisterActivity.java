package com.kosalgeek.android.androidphpmysql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener  {
    final String LOG ="RegisterActivity";

    private EditText etName, etEmail,etPassword;
    private Button btnDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etName = (EditText)findViewById(R.id.etName);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etPassword = (EditText)findViewById(R.id.etPassword);
        btnDaftar = (Button)findViewById(R.id.btnDaftar);
        btnDaftar.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        HashMap postData = new HashMap();
        postData.put("txtName", etName.getText().toString());
        postData.put("txtEmail", etEmail.getText().toString());
        postData.put("txtPassword", etPassword.getText().toString());
        postData.put("mobile", "android");


        PostResponseAsyncTask taskInsert = new PostResponseAsyncTask(RegisterActivity.this,
                postData, new AsyncResponse() {
            @Override
            public void processFinish(String s) {
                Log.d(LOG, s);
                if(s.contains("success")){
                    Toast.makeText(RegisterActivity.this, "Register Success", Toast.LENGTH_LONG).show();
                    Intent in = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(in);
                }
            }
        });
        taskInsert.execute("http://192.168.43.62/amikom/register.php");
    }
}