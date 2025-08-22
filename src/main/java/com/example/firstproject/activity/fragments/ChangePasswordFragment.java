package com.example.firstproject.activity.fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.firstproject.R;
import com.example.firstproject.activity.LoginScreen;

public class ChangePasswordFragment extends Fragment {

    public ChangePasswordFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_password, container, false);

        EditText etOldPassword = view.findViewById(R.id.etOldPassword);
        EditText etNewPassword = view.findViewById(R.id.etNewPassword);
        EditText etConfirmPassword = view.findViewById(R.id.etConfirmPassword);
        Button btnChangePassword = view.findViewById(R.id.btnSavePassword);

        btnChangePassword.setOnClickListener(v -> {
            String oldPass = etOldPassword.getText().toString().trim();
            String newPass = etNewPassword.getText().toString().trim();
            String confirmPass = etConfirmPassword.getText().toString().trim();

            if (TextUtils.isEmpty(oldPass) || TextUtils.isEmpty(newPass) || TextUtils.isEmpty(confirmPass)) {
                Toast.makeText(getContext(), "الرجاء ملء جميع الحقول", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!newPass.equals(confirmPass)) {
                Toast.makeText(getContext(), "كلمة المرور الجديدة غير متطابقة", Toast.LENGTH_SHORT).show();
                return;
            }

            
            Toast.makeText(getContext(), "تم تغيير كلمة المرور بنجاح", Toast.LENGTH_SHORT).show();

            
            Intent intent = new Intent(getActivity(), LoginScreen.class);
            startActivity(intent);

        });

        return view;
    }
}
