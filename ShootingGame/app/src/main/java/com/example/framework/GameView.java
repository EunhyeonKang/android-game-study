package com.example.framework;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import com.example.framework.shoot.GameState;

public class GameView extends SurfaceView implements SurfaceHolder.Callback{
    private GameViewThread m_thread;
    private IState m_state;
    private GraphicObject m_Image;
    private SpriteAnimation m_spr;

    public GameView (Context context)
    {
        super (context);
        setFocusable(true);

        AppManager.getInstance().setGameView(this);
        AppManager.getInstance().setResources(getResources());

        ChangeGameState(new GameState());
        getHolder().addCallback(this);
        m_thread = new GameViewThread(getHolder(),this);

        //!<m_Image = new GraphicObject(AppManager.getInstance().getBitmap(R.drawable.background2));
        //!<m_spr = new SpriteAnimation(BitmapFactory.decodeResource(getResources(),R.drawable.walk));
        //!<m_spr .initSpriteData(230,300,5,4);
    }

    public void onDraw (Canvas canvas)
    {
        Bitmap _scratch = BitmapFactory.decodeResource(getResources(),R.drawable.icon);

        //canvas.drawBitmap(_scratch,10,10,null);
        canvas.drawColor(Color.BLACK);
        m_state.Render(canvas);


        //!<m_Image.Draw(canvas);
        //!<m_spr.Draw(canvas);
    }

    public void Update()
    {
        m_state .Update();
        //long gameTime = System.currentTimeMillis();
        //m_spr .Update(gameTime);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        m_state.onKeyDown(keyCode, event);
        //return super.onKeyDown(keyCode, event);

        return false;
    }

    public boolean onTouchEvent(MotionEvent event)
    {
        m_state.onTouchEvent(event);
        //return super.onTouchEvent(event);
        return false;
    }

    public void ChangeGameState(IState _state)
    {
        if(m_state != null)
            m_state.Destroy();

        _state.Init();
        m_state = _state;
    }
    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder)
    {
        m_thread .setRunning(true);
        m_thread .start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2)
    {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder)
    {
        boolean retry = true;
        m_thread .setRunning(false);
        while(retry)
        {
            try
            {
                m_thread .join();
                retry = false;
            }

            catch(InterruptedException e)
            {

            }
        }
    }
}











