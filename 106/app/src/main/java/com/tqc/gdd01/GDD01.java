package com.tqc.gdd01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GDD01 extends Activity
{
  private static final String TAG = "Android_Log";
  private TextView tv;
  private Button b1;
  private Button b2;

  @Override
  public void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    // TO DO 加入Log
    tv=(TextView) findViewById(R.id.text1);
    b1 = (Button) findViewById(R.id.button1);
    b2 = (Button) findViewById(R.id.button2);

    //TO DO: b1.setOnClickListener
    b1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent=new Intent(GDD01.this,GDD01_2.class);
        startActivityForResult(intent,99);

      }
    });

    // TO DO: b2.setOnClickListener
    b2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        finish();
      }
    });

  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    // TO DO
    if(requestCode == 2020){
      tv.setText(resultCode+"");
    }

  }

 // TO DO 在onCreate()、onStart()、onResume()、onPause()、onStop()、onRestart()、onDestroy()這些Method裡加入Log的設定


  @Override
  protected void onStart() {
    super.onStart();
    Log.i(TAG,"onStart()");
  }

  @Override
  protected void onRestart() {
    super.onRestart();
    Log.i(TAG,"onRestart()");
  }

  @Override
  protected void onResume() {
    super.onResume();
    Log.i(TAG,"onResume()");
  }

  @Override
  protected void onPause() {
    super.onPause();
    Log.i(TAG,"onPause()");
  }

  @Override
  protected void onStop() {
    super.onStop();
    Log.i(TAG,"onStop()");
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    Log.i(TAG,"onDestroy()");
  }
}
