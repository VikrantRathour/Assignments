package com.example.assignment_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment_2.Models.Users;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    EditText etEmailLogin, etPasswordLogin;
    Button btnLogin;
    TextView tvRegister;

    public static ArrayList<Users> users = new ArrayList<Users>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmailLogin = findViewById(R.id.et_email_login);
        etPasswordLogin = findViewById(R.id.et_password_login);
        btnLogin = findViewById(R.id.btn_login);
        tvRegister = findViewById(R.id.tv_register);

        users.add(new Users("admin@gmail.com", "Admin"));
        SpannableString ss;
        ss = new SpannableString("Don't have an account?REGISTER");
        ClickableSpan cs=new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);//intent for register page
                startActivity(intent);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        };
        ForegroundColorSpan fcsBlue=new ForegroundColorSpan(getResources().getColor((android.R.color.holo_blue_dark)));

        // to set on click event on clickable span
        ss.setSpan(cs,22,30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //to set the color to the span
        ss.setSpan(fcsBlue,22,30,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        tvRegister.setText(ss);
        tvRegister.setMovementMethod(LinkMovementMethod.getInstance());

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmailLogin.getText().toString().trim();
                String pass = etPasswordLogin.getText().toString().trim();

                checkData();  // to check either the edittext is empty or the data is valid or not

                for (int i = 0; i < users.size(); i++){
                    if (email.equals(users.get(i).getEmail()) && pass.equals(users.get(i).getPass())){

                        //intent to otp page
                        Intent intent = new Intent(LoginActivity.this, OtpActivity.class);
                        startActivity(intent);
                    }else{

                        //Show snackbar if email or password is not valid
                        Snackbar snackbar = Snackbar.make(getWindow().getDecorView().getRootView() , "Email or password not Valid", Snackbar.LENGTH_LONG);
                        snackbar.show();

                    }
                }
            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }


    // to check if an edittext is empty or not
    boolean isEmpty(EditText text){
        CharSequence check = text.getText().toString().trim();
        return TextUtils.isEmpty(check);
    }

    // to validate email
    boolean isEmail(EditText text){
        CharSequence check = text.getText().toString().trim();
        return (!TextUtils.isEmpty(check) && Patterns.EMAIL_ADDRESS.matcher(check).matches());
    }

    public void checkData(){

        // to check the email field is empty or not
        if (isEmpty(etEmailLogin)){
            etEmailLogin.setError("Enter Email");
        }

        //to check if the email is valid
        else if (!isEmail(etEmailLogin)){
            Toast.makeText(this, "Please Enter Email Address", Toast.LENGTH_SHORT).show();
        }

        //to check if the password is entered
        else if (isEmpty(etPasswordLogin)){
            etPasswordLogin.setError("Enter Password");
        }
    }
}
