package org.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Looper;
import android.widget.Toast;

public class CardGameThread extends Thread {
    CardGameView _cardGameView;

    public CardGameThread(CardGameView _cardGameView) {
        this._cardGameView = _cardGameView;
    }

    @Override
    public void run() {
        while(true) {
            _cardGameView.checkMatch();
            if(_cardGameView.isMatchedAll()){
                System.out.println("스레드 종료");
                break;
            }
        }
    }
}