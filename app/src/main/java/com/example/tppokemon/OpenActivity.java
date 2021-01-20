package com.example.tppokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OpenActivity extends AppCompatActivity {

    Thread timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);

        timer = new Thread() {
            @Override
            public void run(){
                try {
                    synchronized (this) {
                        wait(3000);
                    }
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{

                    Intent intent = new Intent(OpenActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }

}