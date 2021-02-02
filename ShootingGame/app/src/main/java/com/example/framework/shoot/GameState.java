package com.example.framework.shoot;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.example.framework.AppManager;
import com.example.framework.GraphicObject;
import com.example.framework.IState;
import com.example.framework.R;

import java.util.ArrayList;
import java.util.Random;

public class GameState implements IState
{
    private Player m_player;
    private GraphicObject m_keypad;
    private BackGround m_background;

    long LastRegenEnemy = System.currentTimeMillis();

    Random randEnem = new Random();

    ArrayList<Enemy> m_enemlist = new ArrayList<Enemy>();
    ArrayList<Missile_Player> m_pmslist = new ArrayList<Missile_Player>();
    ArrayList<Missile_Enemy> m_enemmslist = new ArrayList<Missile_Enemy>();

    @Override
    public void Init()
    {
        m_player = new Player(AppManager.getInstance().getBitmap(R.drawable.player));
        m_keypad = new GraphicObject(AppManager.getInstance().getBitmap(R.drawable.keypad));

        m_background = new BackGround(0);
        m_keypad .setPosition(50,1700);
    }

    @Override
    public void Destroy()
    {
    }

    @Override
    public void Update()
    {
        long gameTime = System.currentTimeMillis();

        m_player .Update(gameTime);
        m_background .Update(gameTime);

        for( int i = m_pmslist .size()-1; i>= 0; i--)
        {
            Missile_Player pms = m_pmslist .get(i);
            pms.Update();

            if ( pms.state == Missile. STATE_OUT)
                m_pmslist .remove(i);
        }

        for (int i = m_enemlist .size()-1; i>= 0; i--)
        {
            Enemy enem = m_enemlist .get(i);
            enem .Update(gameTime);

            if(enem.state == Enemy. STATE_OUT) m_enemlist .remove(i);
        }

        for ( int i = m_enemmslist.size()-1;i>=0;i--)
        {
            Missile_Enemy enemms = m_enemmslist.get(i);
            enemms .Update();
            if(enemms.state == Missile.STATE_OUT)
                m_enemmslist.remove(i);
        }

        MakeEnemy();
        CheckCollision();
    }

    @Override
    public void Render(Canvas canvas)
    {
        m_background .Draw(canvas);
        m_player .Draw(canvas);
        m_keypad .Draw(canvas);

        for(Missile_Player pms : m_pmslist)
            pms.Draw(canvas);

        for(Enemy enem : m_enemlist)
            enem .Draw(canvas);

        for(Missile enemms : m_enemmslist)
            enemms.Draw(canvas);

        Paint p = new Paint();
        p.setTextSize(70);
        p.setColor(Color.RED);

        canvas.drawText("남은 목숨 : " + String.valueOf(m_player.getLife()),200,70,p);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        int x = m_player .getX();
        int y = m_player .getY();

        if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT)
            m_player .setPosition (x-5,y);

        if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT)
            m_player .setPosition (x+5,y);

        if (keyCode == KeyEvent.KEYCODE_DPAD_UP)
            m_player .setPosition (x,y-5);

        if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN)

            m_player .setPosition (x,y+5);

        if (keyCode == KeyEvent.KEYCODE_SPACE)
            m_pmslist .add(new Missile_Player(x+10,y));

        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    public void MakeEnemy()
    {
        if (System.currentTimeMillis() - LastRegenEnemy >= 1000)
        {
            LastRegenEnemy = System.currentTimeMillis();

            int enemtype = randEnem .nextInt(3);
            Enemy enem = null;

            if(enemtype == 0)
                enem = new Enemy_1();

            else if (enemtype == 1)
                enem = new Enemy_2();

            else if (enemtype == 2)
                enem = new Enemy_3();

            enem .setPosition(randEnem .nextInt(800), -60);
            enem .movetype = randEnem .nextInt(3);

            m_enemlist .add(enem);
        }
    }

    public void CheckCollision()
    {
        for (int i = m_pmslist .size()-1;i>=0;i--)
        {
            for( int j = m_enemlist .size()-1;j>=0;j--)
            {
                if(CollisionManager.CheckBoxToBox(m_pmslist.get(i).m_BoundBox, m_enemlist.get(j).m_BoundBox))
                {
                    m_pmslist.remove(i);
                    m_enemlist.remove(j);
                }
            }
        }
        for(int i = m_enemlist.size()-1;i>=0;i--)
        {
            if(CollisionManager.CheckBoxToBox(m_player.m_BoundBox,m_enemlist.get(i).m_BoundBox))
            {
                m_enemlist.remove(i);
                m_player.destroyPlayer();

                if(m_player.getLife() <=0)
                    System.exit(0);
            }
        }

        for(int i = m_enemmslist.size()-1;i>=0;i--)
        {
            if(CollisionManager.CheckBoxToBox(m_player.m_BoundBox,m_enemmslist.get(i).m_BoundBox))
            {
                m_enemmslist.remove(i);
                m_player.destroyPlayer();

                if(m_player.getLife() <=0)
                    System.exit(0);
            }
        }
    }

    public GameState() {
        AppManager.getInstance().m_gameState = this;
    }
}
