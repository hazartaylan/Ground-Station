package app.hty.gaziuzaygroundstation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

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
                Intent i = new Intent(SplashScreen.this,ChooseConnection.class);
                startActivity(i);

            }
        };
        mHandler.postDelayed(mRunnable, 2300);
    }
}