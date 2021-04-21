package com.example.pnam_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openRegistration(View view) {
        startActivity(new Intent(this, Registration.class));
    }
<<<<<<< HEAD
=======

    public void login(){
        // TODO: Query e controllo username esistente
        // TODO: Query e controllo password corretta
        // TODO: Accesso
    }


>>>>>>> 33ee2c67cb73b4a316bf07e9f030b95b9efe3641
    public void openHome(View view) {
        startActivity(new Intent(this, Home.class));
    }
}
