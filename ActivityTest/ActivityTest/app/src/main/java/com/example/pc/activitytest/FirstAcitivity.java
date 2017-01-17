package com.example.pc.activitytest;

import android.app.Activity;
import android.net.Uri;
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

public class FirstAcitivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    //    Log.d("FirstAcitivity","Task id is " + getTaskId());
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.first_layout);
        Button button1 = (Button) findViewById(R.id.button_1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstAcitivity.this,"You clicked Button1",Toast.LENGTH_SHORT).show();
           //     String data = "Hello SecondActivity";
                //Intent intent = new Intent("com.example.pc.activitytest.ACTION_START");
                Intent intent = new Intent(FirstAcitivity.this,SecondActivity.class);
             //   intent.putExtra("extra_data",data);
                startActivity(intent);
           //        intent.addCategory("com.example.pc.activitytest.MY_CATEGORY");
              //  startActivityForResult(intent,1);
            }
        });
    }
    protected void onActivityForResult(int requestCode,int resultCode,Intent data){
        switch(requestCode){
            case 1:
                if(resultCode  == 1){
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FirstAcitivity",returnedData);
                }
                break;
            default:

        }

    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("FirstActivity","OnRestart");
    }

}
