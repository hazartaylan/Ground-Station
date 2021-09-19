package app.hty.gaziuzaygroundstation;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.net.DatagramPacket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {
    private UDPBuild udpBuild;
    ImageView main;
    double y,x;
    String z="0";
    boolean durum=false;
    String strReceive,str;
    int a,b1,b,b2,b3,b4;
    GraphView mGraphView,mGraphView2,mGraphView3,mGraphView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGraphView = findViewById(R.id.graphView4);
        mGraphView2 = findViewById(R.id.graphView5);
        mGraphView3 = findViewById(R.id.graphView6);
        mGraphView4 = findViewById(R.id.graphView7);
        udpBuild = UDPBuild.getUdpBuild();
        udpBuild.setUdpReceiveCallback(new UDPBuild.OnUDPReceiveCallbackBlock() {
            @Override
            public void OnParserComplete(DatagramPacket data) {
                 strReceive = new String(data.getData(), 0, data.getLength());
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy/dd/ HH:mm:ss");
                Date curDate =  new Date(System.currentTimeMillis());
                 str = formatter.format(curDate);
                TextView receive = findViewById(R.id.receive_textView);
                receive.append(str + ':' + strReceive + '\n');
                char a1=strReceive.charAt(0);
                char a2=strReceive.charAt(1);
                String s=Character.toString(a2);
                b1++;
                b2++;
                b3++;
                b4++;
                //a= Integer.valueOf(bv);
                b=Integer.valueOf(s);
                Log.i(TAG,"HTY :"+a);
                mGraphView.setData(getRandomData(b1));
                mGraphView2.setData(getRandomData2(b2));
                mGraphView3.setData(getRandomData3(b3));
                mGraphView4.setData(getRandomData4(b4));
            }
        });

        main=findViewById(R.id.mainlogo2);
        Animation slide_down = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.down);
        main.startAnimation(slide_down);

    }
    public void sendMessage(View view) {
        EditText editText = findViewById(R.id.send_editText);
        String message = editText.getText().toString();
        udpBuild.sendMessage(message);
        TextView send = findViewById(R.id.send_textView);
        send.append(message + '\n');

    }
    public float [] getAxesDatas(int dataSizes){
        float[] axesDatas = new float[dataSizes];
        axesDatas[0] = 0 ;
        for (int i = 1; i < axesDatas.length; i++) {
            axesDatas[i] = b;
        }
        return axesDatas;

    }
    private float[] getRandomData(int dataSize) {
        float[] randomData = new float[dataSize];
        Random random = new Random();
        randomData[0] = 25 + random.nextFloat();
        for (int i = 1; i < randomData.length; i++) {
            randomData[i] = randomData[i - 1] + random.nextFloat() - .47f;
        }
        return randomData;
    }
    private float[] getRandomData2(int dataSize) {
        float[] randomData = new float[dataSize];
        Random random = new Random();
        randomData[0] = 25 + random.nextFloat();
        for (int i = 1; i < randomData.length; i++) {
            randomData[i] = randomData[i - 1] + random.nextFloat() - .47f;
        }
        return randomData;
    }
    private float[] getRandomData3(int dataSize) {
        float[] randomData = new float[dataSize];
        Random random = new Random();
        randomData[0] = 25 + random.nextFloat();
        for (int i = 1; i < randomData.length; i++) {
            randomData[i] = randomData[i - 1] + random.nextFloat() - .47f;
        }
        return randomData;
    }
    private float[] getRandomData4(int dataSize) {
        float[] randomData = new float[dataSize];
        Random random = new Random();
        randomData[0] = 25 + random.nextFloat();
        for (int i = 1; i < randomData.length; i++) {
            randomData[i] = randomData[i - 1] + random.nextFloat() - .47f;
        }
        return randomData;
    }
}
