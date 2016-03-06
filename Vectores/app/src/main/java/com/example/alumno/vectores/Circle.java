package com.example.alumno.vectores;

import android.graphics.Canvas;
import android.graphics.RectF;

/**
 * Created by Alumno on 06/03/2016.
 */
public class Circle extends Dibujable{
    private float radio;

    public Circle(float x, float y, float radio){
        super(x,y);
        this.radio = radio;

    }

    @Override
    public void dibujar(Canvas c) {

        c.drawOval(new RectF(getX(),getY(), getX()-radio/2+radio, getY()-radio/2+radio), getPaint());
    }

}
