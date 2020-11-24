package com.tqc.gdd03;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class GDD03 extends Activity implements GestureDetector.OnGestureListener, View.OnTouchListener
{
  public static SurfaceView mSurfaceView01;
  public static SurfaceHolder mSurfaceHolder01;
  public GestureDetector detector;

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);

    // TO DO 程式一執行即進入全螢幕模式，沒有狀態列
    Window win = getWindow();
    win.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    requestWindowFeature(Window.FEATURE_NO_TITLE);

    setContentView(R.layout.main);

    // TO DO
    detector =new GestureDetector(GDD03.this,GDD03.this);
    mSurfaceView01=findViewById(R.id.surfaceView);
    mSurfaceHolder01 = mSurfaceView01.getHolder();
    mSurfaceView01.setOnTouchListener(GDD03.this);

  }

  @Override
  public boolean onDown(MotionEvent e) {
   //TO DO
    Canvas canvus = mSurfaceHolder01.lockCanvas();
    canvus.drawColor(Color.BLACK);
    Paint paint = new Paint();
    paint.setColor(Color.WHITE);
    int x = (int)e.getX();
    int y = (int)e.getY();

    canvus.drawCircle(x,y,30,paint);
    mSurfaceHolder01.unlockCanvasAndPost(canvus);
    
    return true;
  }

  @Override
  public void onShowPress(MotionEvent e) {

  }

  @Override
  public boolean onSingleTapUp(MotionEvent e) {
    return false;
  }

  @Override
  public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
    return false;
  }

  @Override
  public void onLongPress(MotionEvent e) {

  }

  @Override
  public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
    return false;
  }

  @Override
  public boolean onTouch(View v, MotionEvent event) {
    return detector.onTouchEvent(event);
  }
}