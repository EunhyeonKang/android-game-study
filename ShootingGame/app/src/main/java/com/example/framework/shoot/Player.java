package com.example.framework.shoot;


import android.graphics.Bitmap;
import android.graphics.Rect;

import com.example.framework.SpriteAnimation;

public class Player extends SpriteAnimation {
    private boolean bMove;
    private int _dirX;
    private int _dirY;

    int m_Life = 3; // 생명 3추가
    Rect m_BoundBox = new Rect();

    public Player ( Bitmap bitmap ) {
        super(bitmap);
        this .initSpriteData(165, 230, 5,6); // 애니메이션 정보
        this .setPosition (400,1300); // 초기위치값 설정
    }

    public void Update (long gameTime){
        super .Update(gameTime);

        if (bMove) {
            this .m_x += _dirX;
            this .m_y += _dirY;
        }
        m_BoundBox .set(m_x,m_y,m_x + 60, m_y + 100);
    }

    public int getLife() { return m_Life; }
    public void addLife() { m_Life++; } // 생명 증가
    public void destroyPlayer() { m_Life--; }  //생명감소
}
