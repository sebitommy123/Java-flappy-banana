package com.example.alumno.flappybanana;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Alumno on 10/01/2016.
 */
public class Tubo implements Dibujable{

    float ancho = 100;
    float alto = MainActivity.ALTO-400;
    Bitmap b;

    float sx = 0;
    float sy = 0;
    float x = 0;
    float y = 0;
    float vx = -300;

    Paint p = new Paint();

    public Tubo(Context context){
        b = BitmapFactory.decodeResource(context.getResources(), R.drawable.tubo);
        b = Bitmap.createScaledBitmap(b,(int)ancho,(int)alto,true);
    }

    @Override
    public void dibujar(Canvas c) {
        c.drawBitmap(b, (int)x,(int)y,p);
    }

    @Override
    public void setX(float x) {
        this.x = x;
        this.sx = x;
    }

    @Override
    public void setY(float y) {
        this.y = y;
        this.sy = y;
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

        x = x + vx * tiempoTranscurrido;
        if (x <= -getAncho()){
            x = sx+getAncho();
            Banana.score += 1;
        }
    }

    @Override
    public boolean colision(Dibujable dibujable) {
        return false;
    }

    public void click() {

    }
}
