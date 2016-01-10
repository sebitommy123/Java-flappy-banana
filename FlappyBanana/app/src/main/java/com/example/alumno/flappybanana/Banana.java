package com.example.alumno.flappybanana;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

/**
 * Created by Antonio on 20/12/2015.
 */
public class Banana implements Dibujable {


    public final float GRAVEDAD = (float) ((2.0/3.0)*MainActivity.ALTO);


    float ancho = 100;
    float alto = 100;
    Bitmap b;

    float x = 0;
    float y = 0;
    float vx = 0;
    float vy = 0;
    static int score = 0;
    boolean upgraded = false;

    Tubo tubo;
    TuboInvertido tuboInvertido;
    Context context;

    Paint p = new Paint();

    public Banana(Context context, Tubo tubo, TuboInvertido tuboInvertido){
        this.context = context;
        this.tubo = tubo;
        this.tuboInvertido = tuboInvertido;
        b = BitmapFactory.decodeResource(context.getResources(), R.drawable.banana);
        b = Bitmap.createScaledBitmap(b,(int)ancho,(int)alto,true);
    }

    @Override
    public void dibujar(Canvas c) {
        c.drawBitmap(b, (int)x,(int)y,p);
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    @Override
    public float getAncho() {
        return ancho;
    }

    @Override
    public float getAlto() {
        return alto;
    }

    @Override
    public void onSizeChanged(int w, int h, int oldw, int oldh) {

    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void mover(float tiempoTranscurrido) {

        vy = vy + GRAVEDAD * tiempoTranscurrido;

        y = y + vy * tiempoTranscurrido;

        if (y > MainActivity.ALTO){
            y = 0;
        }
        if (y < -getAlto()){
            y = MainActivity.ALTO;
        }

        if (MyView.running && (colision(tubo) || colision(tuboInvertido))){
            MyView.running = false;
            Intent i = new Intent(context, DeathScreen.class);
            i.putExtra("score","" + score);
            context.startActivity(i);
        }







    }

    @Override
    public boolean colision(Dibujable dibujable) {

        /*(rect1.x < rect2.x + rect2.width &&
                rect1.x + rect1.width > rect2.x &&
                rect1.y < rect2.y + rect2.height &&
                rect1.height + rect1.y > rect2.y)*/




        return (x < dibujable.getX() + dibujable.getAncho() &&
                x + ancho > dibujable.getX() &&
                y < dibujable.getY() + dibujable.getAlto() &&
                alto + y > dibujable.getY());


    }

    public void click() {
        vy = -MainActivity.ALTO*0.4f;
    }



}
