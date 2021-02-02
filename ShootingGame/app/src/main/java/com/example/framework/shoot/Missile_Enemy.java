package com.example.framework.shoot;

import com.example.framework.AppManager;
import com.example.framework.R;

public class Missile_Enemy extends Missile
{
    Missile_Enemy ( int x, int y)
    {
        super (AppManager.getInstance().getBitmap(R.drawable.missile_2));
        this .setPosition(x,y);
    }

    public void Update()
    {
        m_y += 6;
        if(m_y > 1200) state = STATE_OUT;

        m_BoundBox.set(m_x, m_y,m_x + 43,m_y + 43);
    }
}
