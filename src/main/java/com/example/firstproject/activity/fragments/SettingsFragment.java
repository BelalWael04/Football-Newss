package com.example.firstproject.activity.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.firstproject.R;
import com.example.firstproject.activity.LoginScreen;

public class SettingsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        Button btnChangePassword = view.findViewById(R.id.btnChangePassword);
        Button btnArabic = view.findViewById(R.id.btnArabic);
        Button btnEnglish = view.findViewById(R.id.btnEnglish);
        Button btnFrench = view.findViewById(R.id.btnFrench);
        Button btnAboutApp = view.findViewById(R.id.btnAboutApp);
        Button btnLogout = view.findViewById(R.id.btnLogout);

        btnChangePassword.setOnClickListener(v -> {
            Intent intent = new Intent(requireActivity(), ChangePasswordFragment.class);
            startActivity(intent);
            Toast.makeText(getContext(), "فتح صفحة تغيير كلمة المرور", Toast.LENGTH_SHORT).show();
        });

        btnArabic.setOnClickListener(v ->
                Toast.makeText(getContext(), "تم اختيار اللغة العربية", Toast.LENGTH_SHORT).show()
        );

        btnEnglish.setOnClickListener(v ->
                Toast.makeText(getContext(), "English language selected", Toast.LENGTH_SHORT).show()
        );

        btnFrench.setOnClickListener(v ->
                Toast.makeText(getContext(), "Langue française sélectionnée", Toast.LENGTH_SHORT).show()
        );

        btnAboutApp.setOnClickListener(v -> {
            Intent intent = new Intent(requireActivity(), AboutFragment.class);
            startActivity(intent);
            Toast.makeText(getContext(), "تطبيق لمتابعة المباريات والأخبار", Toast.LENGTH_LONG).show();
        });

        btnLogout.setOnClickListener(v -> {
            Toast.makeText(getContext(), "تم تسجيل الخروج", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(getActivity(), LoginScreen.class);
            startActivity(i);
            requireActivity().finish(); // إغلاق الصفحة الحالية حتى لا يرجع لها بالرجوع
        });

        // زر عن التطبيق
        btnAboutApp.setOnClickListener(v -> {
            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new AboutFragment())
                    .addToBackStack(null)
                    .commit();
        });

        // زر تغيير كلمة المرور
        btnChangePassword.setOnClickListener(v -> {
            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new ChangePasswordFragment())
                    .addToBackStack(null)
                    .commit();
        });


        return view;
    }
}
