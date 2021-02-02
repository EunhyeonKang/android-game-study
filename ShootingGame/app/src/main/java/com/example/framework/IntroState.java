package com.example.framework;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class IntroState implements IState
{
    Bitmap icon;
    int x,y;

    public void Destroy()
    {

    }

    public void Init(){
        icon = AppManager.getInstance().getBitmap(R.drawable.icon);
    }

    public void Render(Canvas canvas){
        canvas.drawBitmap(icon,x,y,null);
    }

    public void Update()
    {

    }

    public boolean onKeyDown(int keyCode, KeyEvent event){
        return true;
    }

    public boolean onTouchEvent(MotionEvent event)
    {
        AppManager.getInstance().getGameView().ChangeGameState(new CreditState());

        return true;
    }
}
