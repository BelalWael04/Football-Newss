package com.example.firstproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.firstproject.R;
import com.example.firstproject.activity.MainActivity;

public class LoginScreen extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnLogin, btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.bt_Login);
        TextView tvSignUp = findViewById(R.id.Create_Account);

        btnLogin.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(LoginScreen.this, "الرجاء ملء جميع الحقول", Toast.LENGTH_SHORT).show();
                return;
            }

            // التحقق من صحة البيانات

            if (email.equals("belal@gmail.com") && password.equals("123456")) {
                Intent intent = new Intent(LoginScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(LoginScreen.this, "البريد الإلكتروني أو كلمة المرور غير صحيحة", Toast.LENGTH_SHORT).show();
            }
        });

        tvSignUp.setOnClickListener(v -> {
            // الانتقال لصفحة إنشاء حساب
            Intent intent = new Intent(LoginScreen.this, SingScreen.class);
            startActivity(intent);
        });
    }
}
