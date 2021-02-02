package com.example.hello;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void onBackButtonClicked(View v){
        Toast.makeText(getApplicationContext(),"돌아가기 번튼이 눌렸어요.",Toast.LENGTH_LONG).show();
        finish();
    }
}