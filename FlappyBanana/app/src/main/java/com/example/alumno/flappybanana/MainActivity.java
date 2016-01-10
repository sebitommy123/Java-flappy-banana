package com.example.alumno.flappybanana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static int ALTO;
    public static int ANCHO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        ANCHO = displayMetrics.widthPixels;
        ALTO = displayMetrics.heightPixels;



        MyView view = new MyView(this);
        setContentView(view);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);





    }



}
