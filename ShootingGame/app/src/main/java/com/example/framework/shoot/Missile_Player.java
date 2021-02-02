package com.example.framework.shoot;

import com.example.framework.AppManager;
import com.example.framework.R;

public class Missile_Player extends Missile
{
    public Missile_Player(int x, int y)
    {
        super (AppManager.getInstance().getBitmap(R.drawable.missile_1));
        this .setPosition(x,y);
    }

    public void Update()
    {
        m_y -= 2;

        if (m_y < 50 )
            state = STATE_OUT;

        m_BoundBox.left = m_x;
        m_BoundBox.top = m_y;
        m_BoundBox.right = m_x + 100;
        m_BoundBox.bottom = m_y + 100;
    }
}
