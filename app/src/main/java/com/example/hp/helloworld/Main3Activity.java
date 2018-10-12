package com.example.hp.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {
Button btn3,btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btn3=findViewById(R.id.btn34);
        btn5=findViewById(R.id.btn35);
    }
    public void buttonOnClick(View v){
     Intent i=new Intent(this,MainActivity.class);
     startActivity(i);
    }
    public void button2OnClick(View v){
        Intent i=new Intent(this,Main2Activity.class);
        startActivity(i);
    }
}
