package com.example.framework.shoot;

import com.example.framework.AppManager;
import com.example.framework.R;

public class Enemy_3 extends Enemy
{
    public Enemy_3()
    {
        super (AppManager.getInstance().getBitmap(R.drawable.enemy3));
        this .initSpriteData(180,300,3,1);
        hp = 20;
        speed = 1.5f;
    }

    public void Update(long gameTime)
    {
        super .Update(gameTime);
        m_BoundBox .set(m_x,m_y,m_x+180,m_y+300);
    }

}
