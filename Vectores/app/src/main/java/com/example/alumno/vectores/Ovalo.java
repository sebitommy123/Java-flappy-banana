package com.example.alumno.vectores;

import android.graphics.Canvas;
import android.graphics.RectF;

/**
 * Created by Alumno on 06/03/2016.
 */
public class Ovalo extends Dibujable {

    private float ancho;
    private float alto;

    public Ovalo(float x, float y, float ancho, float alto){
        super(x,y);
        this.ancho = ancho;
        this.alto = alto;
    }

    public Ovalo(Punto posicion, float ancho, float alto){
        super(posicion);
        this.ancho = ancho;
        this.alto = alto;

    }

    @Override
    public void dibujar(Canvas c) {

        c.drawOval(new RectF(getX(), getY(), getX() + ancho, getY() + alto), getPaint());
    }
}
