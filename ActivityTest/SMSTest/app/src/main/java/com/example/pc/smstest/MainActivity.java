package com.example.pc.smstest;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends
        Activity {
    private TextView sender;
    private TextView content;
    private IntentFilter receiverFilter;
    private MessageReceiver messageReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sender = (TextView)findViewById(R.id.sender);
        content = (TextView)findViewById(R.id.content);
        receiverFilter = new IntentFilter();
        receiverFilter.addAction(Telephony.Sms.Intents.SMS_RECEIVED_ACTION);
        receiverFilter.setPriority(1111111111);
        messageReceiver = new MessageReceiver();
        registerReceiver(messageReceiver,receiverFilter);
    }


   class MessageReceiver extends BroadcastReceiver {
       @Override
       public void onReceive(Context context, Intent intent) {
           Bundle bundle = intent.getExtras();
           Object[] pdus = (Object[]) bundle.get("pdus");
           SmsMessage[] messages = new SmsMessage[pdus.length];
           for(int i = 0;i <messages.length;++i){
               messages[i] = SmsMessage.createFromPdu((byte[])pdus[i],intent.getStringExtra("format"));
           }
           String  address = messages[0].getOriginatingAddress();

           String fullMessage = "";
           for(SmsMessage message:messages){
               fullMessage += message.getMessageBody();
           }
           sender.setText(address);
           content.setText(fullMessage);
           abortBroadcast();
       }
   }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(messageReceiver);
    }
}
