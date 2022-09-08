package com.example.activity_life_cycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
private static final String TAG ="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"OnStart is called");
    }
    protected void onStart(){
        super.onStart();
        Log.d(TAG,"OnStart is called");
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"OnDestroy is called ");
    }
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG,"OnRestart is called ");
    }
    protected void onStop(){
        super.onStop();
        Log.d(TAG,"OnStop is called");
    }
    protected void onPause(){
        super.onPause();
        Log.d(TAG,"onPause is called");
    }
    protected void onResume(){
        super.onResume();
        Log.d(TAG,"OnStart is called");
    }
}