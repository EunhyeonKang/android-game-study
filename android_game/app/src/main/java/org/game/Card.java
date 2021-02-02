package org.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

//카드 상태 정보
public class Card {
    //카드 상태 상수 정의
    public static final int CARD_SHOW=0;
    public static final int CARD_CLOSE=1;
    public static final int CARD_PLAYEROPEN=2;
    public static final int CARD_MATCHED=3;

    //카드 상태 멤버 변수
    public int _state;

    protected static final int IMG_RED=1;
    protected static final int IMG_GREEN=2;
    protected static final int IMG_BLUE=3;

    public int _color;

    public Card(int color){
        _state=CARD_SHOW; //카드 상태 초기화
        _color=color;
    }
}