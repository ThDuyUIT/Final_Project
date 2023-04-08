package com.example.finalproject.authentication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.finalproject.R;

public class LoginActivity extends AppCompatActivity {

    EditText edtUserName,edtPass;
    Button btnLogin;
    TextView txtRegister;

    private ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == RESULT_OK){
                        Intent intent = result.getData();
                        Bundle bundle = intent.getBundleExtra("Account_info");
                        String getUserName = bundle.getString("Username");
                        //Log.d("test",getUserName);
                        edtUserName.setText(getUserName);
                        String getPass = bundle.getString("Password");
                        edtPass.setText(getPass);
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mapping();

        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                //startActivity(intent);
                activityResultLauncher.launch(intent);
            }
        });
    }

    private void mapping() {
        edtUserName = (EditText) findViewById(R.id.editTextUsername);
        edtPass = (EditText) findViewById(R.id.editTextPass);
        btnLogin = (Button) findViewById(R.id.buttonLogin);
        txtRegister = (TextView) findViewById(R.id.textViewRegister);
    }
}