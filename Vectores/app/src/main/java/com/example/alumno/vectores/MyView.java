package com.example.alumno.vectores;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Alumno on 06/03/2016.
 */
public class MyView extends View {


    Ovalo ovalo1;
    Ovalo ovalo2;
    Ovalo ovalo3;
    Ovalo ovalo4;
    Ovalo ovalo5;

    Punto p5;
    Punto p6;

    private ArrayList<Dibujable> dibujables = new ArrayList<Dibujable>();

    public MyView(Context context) {
        super(context);


        Punto p1 = new Punto(100,100);
        Punto p2 = new Punto(500,300);

        for(int i = 0; i<10; i++){

            Punto p = new Punto(200,100);
            p.rotar(p1, i*36);
            Dibujable dd = new Ovalo(p, 100, 100);
            dibujables.add(dd);
        }

        p5 = new Punto(300,700);
        p6 = new Punto(450,700);
        ovalo4 = new Ovalo(p5, 50, 50);
        ovalo5 = new Ovalo(p6, 50, 50);

        ovalo1 = new Ovalo(p1, 10, 10);
        ovalo2 = new Ovalo(p2, 10, 10);
        ovalo3 = new Ovalo(p1, 100, 100);
        Vector path = new Vector(p1, p2);
        ovalo3.setVelocidad(path);

    }


    public void onDraw(Canvas c){
        super.onDraw(c);


        for(Dibujable d:dibujables){
            d.dibujar(c);
        }

        ovalo1.dibujar(c);
        ovalo2.dibujar(c);
        ovalo3.dibujar(c);
        ovalo3.mover();
        ovalo4.dibujar(c);
        p5.rotar(p6, 1);
        ovalo4.setX(p5.getX());
        ovalo4.setY(p5.getY());
        ovalo5.dibujar(c);

        postInvalidate();

    }



}
