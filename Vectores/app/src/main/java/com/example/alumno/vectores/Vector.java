package com.example.alumno.vectores;

/**
 * Created by Alumno on 06/03/2016.
 */
public class Vector {
    private float x;

    private float y;


    public Vector(Punto p1, Punto p2){
        x=p2.getX()-p1.getX();
        y=p2.getY()-p1.getY();
    }


    public void multiplicar(float f){
        x*=f;
        y*=f;
    }

    public void invertirX(){
        x*=-1;
    }

    public void invertirY(){

        y*=-1;
    }

    public Vector(){
        this(0,0);
    }

    public Vector(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
