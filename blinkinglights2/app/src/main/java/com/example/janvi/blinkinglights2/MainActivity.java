package com.example.janvi.blinkinglights2;

import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button b1;
    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1= (Button) findViewById(R.id.button2);
        CameraManager cm=(CameraManager)getSystemService(CAMERA_SERVICE);
        Boolean b=getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);
        String s="1010101010101010101010101010";
        for(int i=0;i<s.length();i++){
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
            {
                try {
                    cm.setTorchMode(cm.getCameraIdList()[0],false);
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }
            else{
                try {
                    cm.setTorchMode(cm.getCameraIdList()[0],true);
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
