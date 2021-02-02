package com.example.gameframwork;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class CreditState implements IState {
	Bitmap android;

	int x;
	int y;

	@Override
	public void Destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Init() {
		// TODO Auto-generated method stub
		android = AppManager.getInstance().getBitmap(R.drawable.android);
	}

	@Override
	public void Render(Canvas canvas) {
		// TODO Auto-generated method stub
		canvas.drawBitmap(android, x, y, null);
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return true;
	}

}
