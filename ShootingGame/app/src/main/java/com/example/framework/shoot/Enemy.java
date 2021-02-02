package com.example.framework.shoot;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.example.framework.AppManager;
import com.example.framework.SpriteAnimation;

public class Enemy extends SpriteAnimation
{
    public int hp;
    public float speed;

    public static final int MOVE_PATTERN_1 = 0;
    public static final int MOVE_PATTERN_2 = 1;
    public static final int MOVE_PATTERN_3 = 2;

    protected int movetype;

    public static final int STATE_NORMAL = 0;
    public static final int STATE_OUT = 1;
    public int state = STATE_NORMAL;

    public Enemy(Bitmap bitmap)
    {
        super (bitmap);
    }

    long LastShoot = System.currentTimeMillis();
    Rect m_BoundBox = new Rect();

    void Move()
    {
        if ( movetype == MOVE_PATTERN_1)
        {
            if ( m_y <= 600 ) m_y += speed;
            else
                m_y += speed*2;
        }
        else if ( movetype == MOVE_PATTERN_2)
        {
            if ( m_y <= 600 ) m_y += speed;
            else
            {
                m_x += speed;
                m_y += speed;
            }
        }
        else if ( movetype == MOVE_PATTERN_3)
        {
            if (m_y <= 600) m_y += speed;

            else
                {
                m_x -= speed;
                m_y += speed;
            }
        }

        if (m_y > 1200) state = STATE_OUT;
    }

    void Attack()
    {
        if(System.currentTimeMillis() - LastShoot >= 2500)
        {
            LastShoot = System.currentTimeMillis();
            AppManager.getInstance().m_gameState.m_enemmslist.add(new Missile_Enemy(m_x+10, m_y+104));
        }
    }

    public void Update(long gameTime)
    {
        super .Update(gameTime);
        Attack();
        Move();
    }
}
