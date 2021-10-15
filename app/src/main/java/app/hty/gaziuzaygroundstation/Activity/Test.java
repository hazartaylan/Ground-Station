package app.hty.gaziuzaygroundstation.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

import app.hty.gaziuzaygroundstation.GraphView;
import app.hty.gaziuzaygroundstation.R;

public class Test extends AppCompatActivity {
GraphView mGraphView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        final EditText numberEditText4 = findViewById(R.id.numberPicker4);
        mGraphView = findViewById(R.id.graphView4);
        Button generateButton4 = findViewById(R.id.generateButton4);
        generateButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGraphView.setData(getRandomData(Integer.valueOf(numberEditText4.getText().toString())));
            }
        });

    }
    private float[] getRandomData(int dataSize) {
        float[] randomData = new float[dataSize];
        Random random = new Random();
        randomData[0] = 5 + random.nextFloat();
        for (int i = 1; i < randomData.length; i++) {
            randomData[i] = randomData[i - 1] + random.nextFloat() - .47f;
        }
        return randomData;
    }
}