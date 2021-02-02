package com.example.framework;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameViewThread extends Thread
{
    public SurfaceHolder m_surfaceHolder;

    public GameView m_gameView;

    public boolean m_run = false;

    public GameViewThread(SurfaceHolder surfaceHolder, GameView gameView)
    {
        m_surfaceHolder = surfaceHolder;
        m_gameView = gameView;
    }

    public void setRunning ( boolean run )
    {
        m_run = run;
    }

    public void run()
    {
        Canvas _canvas;

        while ( m_run )
        {
            _canvas = null;
            try
            {
                m_gameView .Update();

                _canvas = m_surfaceHolder .lockCanvas(null);

                synchronized (m_surfaceHolder )
                {
                    m_gameView.onDraw(_canvas); // 그림을 그림
                }
            }

            finally
            {
                if (_canvas != null)
                    m_surfaceHolder .unlockCanvasAndPost(_canvas); //surface를 화면에 표시함
            }
        }

    }
}
