package com.example.gameframwork;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.SurfaceHolder;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameViewThread extends Thread {

        private SurfaceHolder m_surfaceHolder;
        private GameView m_gameView;

        private boolean m_run = false;

        public GameViewThread(SurfaceHolder surfaceHolder, GameView gameView){
                m_surfaceHolder = surfaceHolder;
                m_gameView = gameView;
        }

        public void setRunning(boolean run){
                m_run = run;
        }

        public void run(){

                Canvas _canvas;
                while(m_run){
                        _canvas = null;
                        try{
                                m_gameView.Update();
                                _canvas = m_surfaceHolder.lockCanvas(null);
                                synchronized(m_surfaceHolder){
                                        m_gameView.OnDraw(_canvas);
                                }
                        }finally{
                                if(_canvas != null)
                                        m_surfaceHolder.unlockCanvasAndPost(_canvas);
                        }
                }
        }
}
