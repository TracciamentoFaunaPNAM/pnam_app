package com.example.pnam_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Anfibi extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anfibi);
    }

    public void backToInformations(View view)
    {
        startActivity(new Intent(this, Informations.class));
    }
}
