package com.gmail.restujulian07.batterybroadcast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //menggunakan intent dengan sistem android
    private BroadcastReceiver battInfoReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra("level", 0);

            //baterai diubah ke progressBar
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
            progressBar.setProgress(level); //kalau 100%, progress barnya juga penuh

            TextView textView = (TextView) findViewById(R.id.textstatus);
            textView.setText("Level baterai: " + Integer.toString(level) + "%");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mendaftarkan progressBar ke sistem android, mengambil data level charging
        registerReceiver(battInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }
}
