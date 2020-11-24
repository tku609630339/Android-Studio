package com.tqc.gdd01;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class GDD01 extends Activity
{
  EditText mEditText1,mEditText2;
  CheckBox mcheckBox;

  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
   // TO DO
    mEditText1 = (EditText)findViewById(R.id.mAccount);
    mEditText2 = (EditText)findViewById(R.id.mPassword);
    mcheckBox = (CheckBox)findViewById(R.id.mCheck);
    mcheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(b){
          mEditText2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }else {
          mEditText2.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }

      }
    });

  }
}
