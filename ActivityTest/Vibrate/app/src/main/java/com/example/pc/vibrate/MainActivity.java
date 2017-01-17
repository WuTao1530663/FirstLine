package com.example.pc.vibrate;

import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button vibrate = (Button)findViewById(R.id.vibrate);
        vibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

                //  vibrator.vibrate(3000);
                // 设置Vibrate的震动周期
                vibrator.vibrate(new long[]{1000,2000,3000,4000}, 0);
                Toast.makeText(MainActivity.this, "震动了", Toast.LENGTH_LONG).show();
            }
        });
    }
}
