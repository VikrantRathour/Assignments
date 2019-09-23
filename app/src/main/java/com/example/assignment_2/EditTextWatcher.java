package com.example.assignment_2;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class EditTextWatcher implements TextWatcher
{
    private View view;
    public EditTextWatcher(View view)
    {
        this.view = view;
    }

    EditText et1, et2, et3, et4;

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

        et1 = OtpActivity.et_otp1;
        et2 = OtpActivity.et_otp2;
        et3 = OtpActivity.et_otp3;
        et4 = OtpActivity.et_otp4;
        String text = editable.toString();
        switch(view.getId())
        {

            case R.id.et_otp1:
                if(text.length()==1)
                    et2.requestFocus();
                break;
            case R.id.et_otp2:
                if(text.length()==1)
                    et3.requestFocus();
                else if(text.length()==0)
                    et1.requestFocus();
                break;
            case R.id.et_otp3:
                if(text.length()==1)
                    et4.requestFocus();
                else if(text.length()==0)
                    et2.requestFocus();
                break;
            case R.id.et_otp4:
                if(text.length()==0)
                    et1.requestFocus();
                break;
        }
    }


}