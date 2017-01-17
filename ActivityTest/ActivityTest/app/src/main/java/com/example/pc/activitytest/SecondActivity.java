package com.example.pc.activitytest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;
import android.util.Log;
/**
 * Created by pc on 2017/1/8.
 */

public class SecondActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SecondAcitivity","Task id is " + getTaskId());
        setContentView(R.layout.second_layout);
        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        Button button2 = (Button) findViewById(R.id.button_2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText(SecondActivity.this, "You clicked Button2", Toast.LENGTH_SHORT).show();
       //         String data = "Hello FirstActivity";
                //Intent intent = new Intent("com.example.pc.activitytest.ACTION_START");
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent);
                //        intent.addCategory("com.example.pc.activitytest.MY_CATEGORY");
            //    startActivityForResult(intent, 1);
            }
        });
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
     //   Log.d("SecondActivity","onDestroy");
    }

}
