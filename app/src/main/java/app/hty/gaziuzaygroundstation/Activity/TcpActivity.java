package app.hty.gaziuzaygroundstation.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import app.hty.gaziuzaygroundstation.R;
import app.hty.gaziuzaygroundstation.TaskBuild.TaskCenter;

public class TcpActivity extends AppCompatActivity {
    ImageView logo;
    public EditText editText;
    public TextView textView_send;
    public TextView textView_receive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tcp);
        editText = findViewById(R.id.send_editText);
        textView_send = findViewById(R.id.send_textView);
        textView_receive = findViewById(R.id.receive_textView);
        logo=findViewById(R.id.tcplog);
        logo=findViewById(R.id.tcplog);
        Animation slide_down2 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.down);
        logo.startAnimation(slide_down2);
        textView_send.setMovementMethod(ScrollingMovementMethod.getInstance());
        textView_receive.setMovementMethod(ScrollingMovementMethod.getInstance());
        TaskCenter.sharedCenter().setDisconnectedCallback(new TaskCenter.OnServerDisconnectedCallbackBlock() {
            @Override
            public void callback(IOException e) {
                textView_receive.setText(textView_receive.getText().toString() + "Bağlantıyı kes" + "\n");
            }
        });
        TaskCenter.sharedCenter().setConnectedCallback(new TaskCenter.OnServerConnectedCallbackBlock() {
            @Override
            public void callback() {
                textView_receive.setText(textView_receive.getText().toString() + "Bağlantı başarılı" + "\n");
            }
        });
        TaskCenter.sharedCenter().setReceivedCallback(new TaskCenter.OnReceiveCallbackBlock() {
            @Override
            public void callback(String receicedMessage) {
                textView_receive.setText(textView_receive.getText().toString() + receicedMessage + "\n");
            }
        });
    }

    public void sendMessage(View view) {
        String msg = editText.getText().toString();
        textView_send.setText(textView_send.getText().toString() + msg + "\n");
        TaskCenter.sharedCenter().send(msg.getBytes());
    }

    public void connect(View view) {
        TaskCenter.sharedCenter().connect("10.30.0.31",8080);
    }

    public void disconnect(View view) {
        TaskCenter.sharedCenter().disconnect();
    }

    public void clear1(View view) {
        textView_send.setText("");
    }

    public void clear2(View view) {
        textView_receive.setText("");
    }
}