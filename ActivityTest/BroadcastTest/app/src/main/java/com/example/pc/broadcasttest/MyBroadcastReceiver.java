package com.example.pc.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by pc on 2017/1/12.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        abortBroadcast();
        Toast.makeText(context,"receive in MyBroadcastReceiver",Toast.LENGTH_SHORT).show();
        ;
    }
}
