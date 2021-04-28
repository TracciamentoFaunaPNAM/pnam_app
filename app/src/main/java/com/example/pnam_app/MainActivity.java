package com.example.pnam_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    public ServerNode myAPI;
    public CompositeDisposable compositeDisposable = new CompositeDisposable();
    public EditText usernameTxt, passwordTxt;
    public Button btnLogin;

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = RetrofitClient.getInstance();
        myAPI = retrofit.create(ServerNode.class);
        btnLogin = findViewById(R.id.btnLogin);
        usernameTxt = findViewById(R.id.usernameLogin);
        passwordTxt = findViewById(R.id.passwordLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser(usernameTxt.getText().toString(), passwordTxt.getText().toString(), v);
            }
        });
    }

    public void openRegistration(View view) {
        startActivity(new Intent(this, Registration.class));
    }

    public void loginUser(String username, String password, View v){
        compositeDisposable.add(myAPI.loginUser(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        if(s.contains("login successful")){
                            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                            openHome(v);
                        } else {
                            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                        }
                    }
                })
        );
    }


    public void openHome(View view) {
        startActivity(new Intent(this, Home.class));
    }
}
