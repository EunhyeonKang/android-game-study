package com.example.framework.shoot;

import com.example.framework.AppManager;
import com.example.framework.R;

public class Enemy_1 extends Enemy
{
    public Enemy_1()
    {
        super (AppManager.getInstance().getBitmap(R.drawable.enemy1));
        this .initSpriteData(180,300,3,1);

        hp = 10;
        speed = 2.5f;
    }

    public void Update(long gameTime)
    {
        super .Update(gameTime);

        m_BoundBox .set(m_x,m_y,m_x+180,m_y+300);
    }
}
