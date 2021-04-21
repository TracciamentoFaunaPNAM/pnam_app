package com.example.pnam_app;

import androidx.appcompat.app.AppCompatActivity;

<<<<<<< HEAD
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
=======
import android.os.Bundle;
>>>>>>> 33ee2c67cb73b4a316bf07e9f030b95b9efe3641

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
<<<<<<< HEAD

    public void openInformation(View view) {
        startActivity(new Intent(this, Informations.class));
    }
=======
>>>>>>> 33ee2c67cb73b4a316bf07e9f030b95b9efe3641
}