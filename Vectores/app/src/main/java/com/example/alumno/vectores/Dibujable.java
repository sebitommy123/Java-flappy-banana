package com.example.alumno.vectores;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by Alumno on 06/03/2016.
 */
public abstract class Dibujable{

    private Punto posicion;
    private Paint paint;
    private Vector velocidad;



    public Dibujable(){
        this(0,0);

    }

    public Dibujable(Punto posicion){
        this(posicion.getX(),posicion.getY());
    }

    public Dibujable(float x, float y){
        paint = new Paint();
        posicion = new Punto(x, y);
        velocidad = new Vector(0,0);
    }

    public abstract void dibujar(Canvas c);

    public float getX(){
        return  posicion.getX();
    }

    public float getY(){
        return  posicion.getY();
    }

    public void setX(float x){
        posicion.setX(x);
    }

    public void setY(float y){
        posicion.setY(y);
    }


    public Paint getPaint(){
        return paint;
    }

    public void setVx(float x){
        velocidad.setX(x);
    }

    public void setVy(float y){
        velocidad.setY(y);
    }


    public float getVx(){
        return velocidad.getX();
    }

    public float getVy(){
        return velocidad.getY();
    }

    public void mover(){
        posicion.add(velocidad);
    }

    public void setVelocidad(float x, float y){
        velocidad.setX(x);
        velocidad.setY(y);
    }

    public void setVelocidad(Vector path){
        velocidad.setX(path.getX());
        velocidad.setY(path.getY());
    }
}