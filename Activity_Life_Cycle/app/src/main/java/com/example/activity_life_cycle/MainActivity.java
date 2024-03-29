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
        Log.d(TAG,"OnStart in main");
    }
    protected void onStart(){
        super.onStart();
        Log.d(TAG,"OnStart in main ");
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"OnDestroy in main ");
    }
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG,"OnRestart in main");
    }
    protected void onStop(){
        super.onStop();
        Log.d(TAG,"OnStop in main");
    }
    protected void onPause(){
        super.onPause();
        Log.d(TAG,"onPause in main");
    }
    protected void onResume(){
        super.onResume();
        Log.d(TAG,"OnStart in main");
    }
}