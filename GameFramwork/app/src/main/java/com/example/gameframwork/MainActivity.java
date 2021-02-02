package com.example.gameframwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
    /** Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 최상단탭과타이블바를제거하여전체화면으로만들어줌
        requestWindowFeature( Window. FEATURE_NO_TITLE);
        getWindow( ).setFlags( WindowManager.LayoutParams. FLAG_FULLSCREEN,
                WindowManager.LayoutParams. FLAG_FULLSCREEN);

        setContentView(new GameView(this));
    }
}