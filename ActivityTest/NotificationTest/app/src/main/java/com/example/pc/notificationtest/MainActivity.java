package com.example.pc.notificationtest;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.security.Permission;

import static android.support.v4.content.PermissionChecker.PERMISSION_GRANTED;

public class MainActivity extends AppCompatActivity {
    private Button sendNotice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendNotice = (Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                if(checkSelfPermission(Manifest.permission.VIBRATE) != PERMISSION_GRANTED){
                    requestPermissions(new String[]{Manifest.permission.VIBRATE},2);
                }
                Notification notification =
                        new Notification.Builder(MainActivity.this).setSmallIcon(R.drawable.ic_stat_name).setWhen(System.currentTimeMillis()).setContentText("This is content text")
                                .setContentTitle("This is content title").setContentIntent(PendingIntent.getActivity(MainActivity.this,0,new Intent(MainActivity.this,NotificatonActivity.class),PendingIntent.FLAG_CANCEL_CURRENT))
                                .setDefaults(Notification.DEFAULT_VIBRATE).build();

                manager.notify(1,notification);

            }
        });
    }
}
