package com.example.pnam_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class Registration extends AppCompatActivity {

    public ServerNode myAPI;
    public CompositeDisposable compositeDisposable = new CompositeDisposable();
    public EditText usernameTxt, emailTxt, passwordTxt, repeatPasswordTxt;
    public Button btnRegistration;

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
        setContentView(R.layout.activity_registration);

        Retrofit retrofit = RetrofitClient.getInstance();
        myAPI = retrofit.create(ServerNode.class);
        btnRegistration = findViewById(R.id.btnRegistration);
        usernameTxt = findViewById(R.id.username_input);
        passwordTxt = findViewById(R.id.password);
        repeatPasswordTxt = findViewById(R.id.repeat_password);
        emailTxt = findViewById(R.id.email);

        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(usernameTxt.getText().toString() + passwordTxt.getText().toString() + emailTxt.getText().toString());
                if(passwordTxt.getText().toString().equals(repeatPasswordTxt.getText().toString())){
                    registerUser(usernameTxt.getText().toString(), passwordTxt.getText().toString(), emailTxt.getText().toString(), view);
                }
                else{
                    Toast.makeText(getApplicationContext(), "le password non corrispondono", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void registerUser(String username, String password, String email, View v){
        compositeDisposable.add(myAPI.registerUser(username, password, email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {

                        if(s.contains("register successful")){
                            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                            openLogin(v);
                        } else {
                            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                        }
                    }
                }));
    }

    public void openLogin(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

}