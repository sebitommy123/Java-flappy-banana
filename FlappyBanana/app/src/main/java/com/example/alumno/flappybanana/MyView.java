package com.example.alumno.flappybanana;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import com.example.alumno.flappybanana.Dibujable;

import java.io.BufferedInputStream;
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
import java.util.ArrayList;

/**
 * Created by Antonio on 20/12/2015.
 */
public class MyView extends View {




    static boolean running = true;

    private ArrayList<Dibujable> dibujables = new ArrayList<>();

    Thread t;

    final Tubo tubo;
    final TuboInvertido tuboInvertido;
    final Banana banana;
    final Background background;

    public MyView(Context context) {

        super(context);
        tubo = new Tubo(context);
        tuboInvertido = new TuboInvertido(context, tubo);

        background = new Background(context);

        banana = new Banana(context, tubo, tuboInvertido, this);
        banana.setVY(0);
        banana.setVX(0);
        banana.setX((banana.getAncho()));
        banana.setY((MainActivity.ALTO - banana.getAlto()) / 2 + 10);

        tuboInvertido.setX(MainActivity.ANCHO - tubo.getAncho());
        tuboInvertido.setY(-250);

        tubo.setX(MainActivity.ANCHO - tubo.getAncho());
        tubo.setY(-250 + MainActivity.ALTO - 400 + 300);

        dibujables.add(background);
        dibujables.add(banana);
        dibujables.add(tubo);
        dibujables.add(tuboInvertido);

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                banana.click();
            }
        });


        t = new Thread(new Runnable() {
            public long tiempoAnterior = System.currentTimeMillis();

            @Override
            public void run() {
                while (true){
                    if(running) {
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        long tiempoActual = System.currentTimeMillis();
                        long tt = tiempoActual - tiempoAnterior;
                        tiempoAnterior = tiempoActual;

                        for (Dibujable d : dibujables) {
                            d.mover(tt / 1000f);
                        }

                        postInvalidate();

                    }else{
                        long tiempoActual = System.currentTimeMillis();
                        long tt = tiempoActual - tiempoAnterior;
                        tiempoAnterior = tiempoActual;
                    }
                }
            }
        });
        t.start();

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        for(Dibujable d : dibujables){
            d.dibujar(canvas);
        }
        Paint paint = new Paint();
        paint.setTextSize(100);
        canvas.drawText("" + Banana.score,MainActivity.ANCHO/2,75,paint);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    public void restart(){
        Banana.score = 0;

        banana.setVX(0);
        banana.setVY(0);
        banana.setX((banana.getAncho()));
        banana.setY((MainActivity.ALTO - banana.getAlto()) / 2 + 10);

        tuboInvertido.setX(MainActivity.ANCHO - tubo.getAncho());
        tuboInvertido.setY(-250);

        tubo.setX(MainActivity.ANCHO - tubo.getAncho());
        tubo.setY(-250 + MainActivity.ALTO - 400 + 300);

        running = true;



    }






}
