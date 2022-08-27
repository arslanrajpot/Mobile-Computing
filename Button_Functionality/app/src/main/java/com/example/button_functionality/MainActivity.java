package com.example.button_functionality;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText text_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_id=(EditText) findViewById(R.id.text_id);
    }
    public void processChalo(){
        String myName=text_id.getText().toString();
        Toast.makeText( MainActivity.this,  "Welcome" + myName, Toast.LENGTH_LONG).show();

    }
}