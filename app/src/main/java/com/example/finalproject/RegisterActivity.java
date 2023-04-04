package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    EditText edtName, edtPhoneNum, edtUser, edtPass, edtPass2;
    Button btnRegister;
    TextView txtGotoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mapping();

        txtGotoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strUserName = edtUser.getText().toString();
                String strPass = edtPass.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("Username", strUserName);
                bundle.putString("Password", strPass);

                Intent intent = new Intent();
                intent.putExtra("Account_info", bundle);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private void mapping(){
        edtName = (EditText) findViewById(R.id.editTextName);
        edtPhoneNum = (EditText) findViewById(R.id.editPhoneNumbers);
        edtUser = (EditText) findViewById(R.id.editTextRegisterUsername);
        edtPass = (EditText) findViewById(R.id.editTextRegisterPass);
        edtPass2 = (EditText) findViewById(R.id.editTextConfirmPass);
        txtGotoLogin = (TextView) findViewById(R.id.textViewGotoLogin);
        btnRegister = (Button) findViewById(R.id.buttonRegister);
    }
}