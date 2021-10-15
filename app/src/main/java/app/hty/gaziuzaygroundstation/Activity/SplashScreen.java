package app.hty.gaziuzaygroundstation.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import app.hty.gaziuzaygroundstation.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler mHandler = new Handler(getMainLooper());
        Runnable mRunnable = new Runnable() {
            @Override
            public void run() {
                finish();
                Intent i = new Intent(SplashScreen.this, Intro.class);
                startActivity(i);

            }
        };
        mHandler.postDelayed(mRunnable, 2300);
    }
}