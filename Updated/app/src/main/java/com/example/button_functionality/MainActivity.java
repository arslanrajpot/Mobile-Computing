package com.example.button_functionality;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText my_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        my_text=(EditText) findViewById(R.id.text_id);
    }
    public void processChalo(){
        String myName=my_text.getText().toString();
        Toast.makeText( MainActivity.this,  "Hello" + myName +"Welcome To My Page", Toast.LENGTH_LONG).show();

    }
}