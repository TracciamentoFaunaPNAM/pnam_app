package com.example.pnam_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Informations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informations);
    }

    public void openLupo(View view) {
        startActivity(new Intent(this, Lupo.class));
    }
    public void openRettili(View view) {
        startActivity(new Intent(this, Rettili.class));
    }
    public void openUngulati(View view) {
        startActivity(new Intent(this, Ungulati.class));
    }
    public void openLontra(View view) {
        startActivity(new Intent(this, Lontra.class));
    }
    public void openMustelidi(View view) {
        startActivity(new Intent(this, Mustelidi.class));
    }
    public void openPipistrelli(View view) {
        startActivity(new Intent(this, Pipistrelli.class));
    }
    public void openUccelli(View view) {
        startActivity(new Intent(this, Uccelli.class));
    }
    public void openAnfibi(View view) {
        startActivity(new Intent(this, Anfibi.class));
    }
    public void openPesci(View view) {
        startActivity(new Intent(this, Pesci.class));
    }
    public void openInvertebrati(View view) {
        startActivity(new Intent(this, Invertebrati.class));
    }
    public void openMammiferi(View view) {
        startActivity(new Intent(this, Mammiferi.class));
    }
}