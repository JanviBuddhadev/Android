package com.example.janvi.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void notification(View view) {
        android.support.v4.app.NotificationCompat.Builder mbuilder=new android.support.v4.app.NotificationCompat.Builder(MainActivity.this);
        Intent i=new Intent(NOTIFICATION_SERVICE);
        PendingIntent pi=PendingIntent.getActivity(this,0,i,0);
        mbuilder.setContentTitle("Title");
        mbuilder.setContentText("Text");
        mbuilder.setContentIntent(pi);
        NotificationManager nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O);
        {
            NotificationChannel nc=new NotificationChannel("ch1","APPNAME",NotificationManager.IMPORTANCE_DEFAULT);
            nm.createNotificationChannel(nc);
            mbuilder.setChannelId("ch1");

        }
        nm.notify("ch1",0,mbuilder.build());
    }
}
