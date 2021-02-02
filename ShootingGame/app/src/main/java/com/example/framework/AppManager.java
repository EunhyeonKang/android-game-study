package com.example.framework;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.framework.shoot.GameState;

public class AppManager
{
    private static AppManager s_instance;

    private GameView m_gameView;
    private Resources m_resources;

    public GameState m_gameState;

    public static AppManager getInstance()
    {
        if (s_instance == null) s_instance = new AppManager();
        return s_instance;
    }

    void setGameView (GameView _gameView)
    {
        m_gameView = _gameView;
    }

    void setResources (Resources _resources)
    {
        m_resources = _resources;
    }

    public GameView getGameView()
    {
        return m_gameView;
    }

    public Resources getResources()
    {
        return m_resources;
    }

    public Bitmap getBitmap(int r)
    {
        return BitmapFactory.decodeResource(m_resources,r);
    }
}
