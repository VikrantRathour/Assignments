package com.example.assignment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OtpActivity extends AppCompatActivity {

    static EditText et_otp1;
    static EditText et_otp2;
    static EditText et_otp3;
    static EditText et_otp4;
    Button btn_otp_resend, btn_otp_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        et_otp1 = findViewById(R.id.et_otp1);
        et_otp2 = findViewById(R.id.et_otp2);
        et_otp3 = findViewById(R.id.et_otp3);
        et_otp4 = findViewById(R.id.et_otp4);
        btn_otp_resend = findViewById(R.id.btn_otp_resend);
        btn_otp_submit = findViewById(R.id.btn_otp_submit);


        // jump to the next field using custom class EditTextWatcher
        et_otp1.addTextChangedListener(new EditTextWatcher(et_otp1));
        et_otp2.addTextChangedListener(new EditTextWatcher(et_otp2));
        et_otp3.addTextChangedListener(new EditTextWatcher(et_otp3));
        et_otp4.addTextChangedListener(new EditTextWatcher(et_otp4));


        // clear the feilds on resend
        btn_otp_resend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_otp1.getText().clear();
                et_otp2.getText().clear();
                et_otp3.getText().clear();
                et_otp4.getText().clear();

                Toast.makeText(OtpActivity.this, "OTP has been sent successfully!!!", Toast.LENGTH_SHORT).show();
            }
        });

        btn_otp_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(OtpActivity.this, LoginActivity.class);
                startActivity(intent);
                Toast.makeText(OtpActivity.this, "Login Successfully!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
