package com.example.alumno.flappybanana;

import android.graphics.Canvas;

/**
 * Created by Antonio on 20/12/2015.
 */
public interface Dibujable {
    public void dibujar(Canvas c);
    public void setX(float x);
    public void setY(float y);
    public void setVY(float vy);
    public void setVX(float vx);
    public float getAncho();
    public float getAlto();
    public void onSizeChanged(int w, int h, int oldw, int oldh);
    public float getX();
    public float getY();
    public void mover(float tiempoTranscurrido);
    public boolean colision(Dibujable dibujable);
}
