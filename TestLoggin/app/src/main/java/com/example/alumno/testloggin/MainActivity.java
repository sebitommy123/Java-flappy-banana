package com.example.alumno.testloggin;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static final int CONNECTION_TIMEOUT = 10000;
    private static final int DATARETRIEVAL_TIMEOUT = 10000;

    EditText usernameBox;
    EditText passboxBox;
    Button loginButton;
    TextView responseX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameBox = (EditText) findViewById(R.id.userEnter);
        passboxBox = (EditText) findViewById(R.id.passEnter);
        loginButton = (Button) findViewById(R.id.loginButton);
        responseX = (TextView) findViewById(R.id.response);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String us = usernameBox.getText().toString();
                final String pas = passboxBox.getText().toString();

                AsyncTask<Object, Object, String> a = new AsyncTask<Object, Object, String>() {

                    @Override
                    protected String doInBackground(Object... params) {
                        if(Server.login(us, pas)){
                            return "Response: true";
                        }else{
                            return "Response: false";
                        }
                    }

                    @Override
                    protected void onPostExecute(String response) {

                        responseX.setText(response);

                    }
                };

                a.execute();



            }
        });

    }



}
