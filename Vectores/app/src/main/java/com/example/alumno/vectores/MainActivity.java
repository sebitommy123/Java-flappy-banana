package com.example.alumno.vectores;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        MyView v = new MyView(this);

        setContentView(v);
    }
}
