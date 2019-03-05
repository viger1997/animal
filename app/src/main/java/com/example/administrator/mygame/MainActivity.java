package com.example.administrator.mygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static java.lang.System.exit;

public class MainActivity extends AppCompatActivity {
    public void onEXIT(View view) {
        exit(0);
    }

    public void onPLAY(View view) {
        Intent intent = new Intent(MainActivity.this,Main_Game.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setBackgroundDrawableResource(R.drawable.bg);
    }
}
