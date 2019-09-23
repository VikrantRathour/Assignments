package com.example.assignment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment_2.Models.Users;

public class RegisterActivity extends AppCompatActivity {

    ImageView ivBack;
    EditText etFullName, etEmailReg, etPassReg, etConfirmPassReg, etGender, etDateOfBirth, etUserType, etOccupation;
    TextView tvDiffAccSignin;
    Button btnReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initFn(); // find view by id for all views


        onClick(); // onclick event on buttons

    }
    public void initFn(){
        ivBack = findViewById(R.id.iv_back);
        etFullName = findViewById(R.id.et_full_name);
        etEmailReg = findViewById(R.id.et_email_reg);
        etPassReg = findViewById(R.id.et_pass_reg);
        etConfirmPassReg = findViewById(R.id.et_confirm_pass_reg);
        etGender = findViewById(R.id.et_gender);
        etDateOfBirth = findViewById(R.id.etDateOfBirth);
        etUserType = findViewById(R.id.etUserType);
        etOccupation = findViewById(R.id.etOccupation);
        tvDiffAccSignin = findViewById(R.id.tvDiffAccSignin);
        btnReg = findViewById(R.id.btnReg);
    }

    public void onClick(){



        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fullName = etFullName.getText().toString().trim();
                String email = etEmailReg.getText().toString().trim();
                String pass = etPassReg.getText().toString().trim();
                String confPass = etConfirmPassReg.getText().toString().trim();
                String gender = etGender.getText().toString().trim();

                checkData();  // to check if the field is empty and to validate the data


                //add the user to arraylist
                LoginActivity.users.add(new Users(email, pass));

                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        tvDiffAccSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    boolean isEmpty(EditText text){
        CharSequence check = text.getText().toString().trim();
        return TextUtils.isEmpty(check);
    }
    boolean isEmail(EditText text){
        CharSequence check = text.getText().toString().trim();
        return (!TextUtils.isEmpty(check) && Patterns.EMAIL_ADDRESS.matcher(check).matches());
    }
    boolean notEqual(EditText text1, EditText text2){
        CharSequence check1 = text1.getText().toString().trim();
        CharSequence check2 = text2.getText().toString().trim();
        boolean result;
        if (check1==check2){
            result = true;
        }else{
            result = false;
        }
        return !result;
    }

    public void checkData(){
        if (!isEmail(etEmailReg)){
            Toast.makeText(this, "Please Enter Email Address", Toast.LENGTH_SHORT).show();
        }
        else if (isEmpty(etPassReg)){
            etPassReg.setError("Enter Password");
        }
        else if (isEmpty(etFullName)){
            etFullName.setError("Enter Full Name");
        }
        else if (isEmpty(etConfirmPassReg)){
            etConfirmPassReg.setError("Enter Password Again");
        }
        else if (notEqual(etPassReg, etConfirmPassReg)){
            etConfirmPassReg.setError("Password not Matched");
        }
        else if (isEmpty(etGender)){
            etGender.setError("Enter Gender");
        }
        else if (isEmpty(etDateOfBirth)){
            etDateOfBirth.setError("Enter Full Name");
        }

    }
}
