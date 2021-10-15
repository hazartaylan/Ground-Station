package app.hty.gaziuzaygroundstation.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import app.hty.gaziuzaygroundstation.R;

public class ChooseConnection extends AppCompatActivity {
    CardView i1,i2,i3,i4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_connection);
        i1=findViewById(R.id.i1);
        i2=findViewById(R.id.i2);
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ChooseConnection.this, MainActivity.class);
                startActivity(i);
            }

        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(ChooseConnection.this, TcpActivity.class);
                startActivity(i2);
            }
        });
    }
}