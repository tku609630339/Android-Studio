package com.tqc.gdd01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class GDD01 extends Activity
{
  private EditText etheight;
  private EditText etweight;
  private RadioButton rb1;
  private RadioButton rb2;//虛擬物件宣告

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    etheight=(EditText)findViewById(R.id.editText);
    etweight=(EditText)findViewById(R.id.editText2);
    rb1=(RadioButton)findViewById(R.id.radioButton);
    rb2=(RadioButton)findViewById(R.id.radioButton2);

    Button b1 = (Button) findViewById(R.id.button1);
    b1.setOnClickListener(new Button.OnClickListener()
    {
      public void onClick(View v)
      {
        //從輸入介面中取出了的身高、體重值，要將身高、體重值傳送給 child_Activity 後作計算
        double h = Double.parseDouble(etheight.getText().toString());
        double w = Double.parseDouble(etweight.getText().toString());

        //===String sex = rb1.isChecked() ? "M" : "F";===
        String sex ="";
        if(rb1.isChecked()){
          sex="M";
        }else {
          sex="F";
        }
        //這些附加在 Intent 上的訊息都儲存在 Bundle 物件中
        Intent intent=new Intent(GDD01.this,GDD01_child.class);
        Bundle bundle=new Bundle();
        bundle.getDouble("height",h);
        bundle.getDouble("weight",w);
        bundle.putString("Sex",sex);

        //透過「intent.putExtras(bundle)」敘述，將「bundle」 物件附加在 Intent 上，隨著 Intent 送出而送出
        intent.putExtras(bundle);
        startActivity(intent);
      }
    });
  }

}
