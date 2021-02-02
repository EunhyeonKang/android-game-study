package com.example.framework.shoot;

import com.example.framework.AppManager;
import com.example.framework.R;

public class Enemy_2 extends Enemy
{
    public Enemy_2()
    {
        super (AppManager.getInstance().getBitmap(R.drawable.enemy2));
        this .initSpriteData(180,300,3,1);
        hp = 15;
        speed = 2.0f;
    }

    public void Update(long gameTime)
    {
        super .Update(gameTime);
        m_BoundBox .set(m_x,m_y,m_x+180,m_y+300);
    }

}
