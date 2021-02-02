package com.example.framework.shoot;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.example.framework.AppManager;
import com.example.framework.GraphicObject;
import com.example.framework.R;

public class BackGround extends GraphicObject
{
    static final float SCROLL_SPEED = 0.2f;
    private float m_scroll = -2000 + 480;

    Bitmap m_layer2;
    static final float SCROLL_SPEED_2 = 0.2f;
    private float m_scroll_2 = -2000 + 480;

    public BackGround(int backtype)
    {
        super (null);

        if (backtype == 0)
            m_bitmap = AppManager.getInstance().getBitmap(R.drawable.background1);

        else if (backtype == 1)
            m_bitmap = AppManager.getInstance().getBitmap(R.drawable.background2);
        m_layer2 = AppManager.getInstance().getBitmap(R.drawable.background_2);
        setPosition(0,(int) m_scroll);
    }

    void Update(long gameTime)
    {
        m_scroll = m_scroll + SCROLL_SPEED;

        if ( m_scroll >= 0) m_scroll = 0;
        setPosition(0,(int) m_scroll);

        m_scroll_2 = m_scroll_2 + SCROLL_SPEED_2;

        if ( m_scroll_2 >= 0) m_scroll_2 = 0;
    }

    public void Draw(Canvas canvas)
    {
        canvas.drawBitmap(m_bitmap, m_x, m_y,null);
        canvas.drawBitmap(m_layer2, m_x, m_scroll_2,null);
    }
}
