package com.example.linearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edtUserName, edtPassword;
    private Button btnReset, btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the input field reference from XML layout
         edtUserName = findViewById(R.id.edtUserName);
         edtPassword = findViewById(R.id.edtPassword);
         btnLogin = findViewById(R.id.btnLogin);
         btnReset = findViewById(R.id.btnReset);
         btnLogin.setOnClickListener(this);
         btnReset.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                String userName = edtUserName.getText().toString();
                String userPassword = edtPassword.getText().toString();
                if(userName.isEmpty()) {
                    Toast.makeText(MainActivity.this.getApplicationContext(), "Insert Username", Toast.LENGTH_LONG).show();
                }
                if(userPassword.isEmpty()) {
                    Toast.makeText(MainActivity.this.getApplicationContext(), "Insert Password", Toast.LENGTH_LONG).show();
                }
                else if(!Objects.equals(userName, "") && (Objects.equals(userName, "aamaruf") && Objects.equals(userPassword, "183002084"))) {
                    Toast.makeText(MainActivity.this.getApplicationContext(), "Authorized", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this.getApplicationContext(), "Access Denied", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btnReset:
                edtUserName.getText().clear();
                edtPassword.getText().clear();
                break;
        }
    }
}