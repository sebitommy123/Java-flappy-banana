package com.example.alumno.flappybanana;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Alumno on 10/01/2016.
 */
public class Background implements Dibujable{

    float ancho = MainActivity.ANCHO*2;
    float alto = MainActivity.ALTO;
    Bitmap b;

    float sx = 0;
    float sy = 0;
    float x = 0;
    float y = 0;
    float vx = -MainActivity.ANCHO/6.0f;

    Paint p = new Paint();

    public Background(Context context){
        b = BitmapFactory.decodeResource(context.getResources(), R.drawable.sunrisebackground);
        b = Bitmap.createScaledBitmap(b,(int)ancho,(int)alto,true);
    }

    @Override
    public void dibujar(Canvas c) {

        c.drawBitmap(b, (int)x,(int)y,p);
        c.drawBitmap(b, (int)x-MainActivity.ANCHO*2,(int)y,p);

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
    public void setVY(float vy) {

    }

    @Override
    public void setVX(float vx) {

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
        if (x <= -MainActivity.ANCHO){
            x = MainActivity.ANCHO;

        }
    }

    @Override
    public boolean colision(Dibujable dibujable) {
        return false;
    }

    public void click() {

    }
}
