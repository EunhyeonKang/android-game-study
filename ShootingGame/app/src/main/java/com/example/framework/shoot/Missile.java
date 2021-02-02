package com.example.framework.shoot;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.example.framework.GraphicObject;

public class  Missile extends GraphicObject
{
    public static final int STATE_NORMAL = 0;
    public static final int STATE_OUT = 1;
    public int state = STATE_NORMAL;
    Rect m_BoundBox = new Rect();

    public Missile(Bitmap bitmap){
        super (bitmap);
    }

}
