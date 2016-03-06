package com.example.alumno.vectores;

/**
 * Created by Alumno on 06/03/2016.
 */
public class Punto {
    private float x;
    private float y;

    public Punto(){
        this(0,0);
    }

    public Punto(float x, float y){
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

    public void add(Vector v) {
        x += v.getX();
        y += v.getY();
    }

    public void rotar(Punto centro, float grados){
        double rad = Math.toRadians(grados);

        float nx = x;
        float ny = y;

        nx = (float)(Math.cos(rad)*(x-centro.getX())-Math.sin(rad)*(y-centro.y));
        ny = (float)(Math.sin(rad)*(x-centro.getX())+Math.cos(rad)*(y-centro.y));

        x = nx+centro.getX();
        y = ny+centro.getY();
        //px = cos(theta) * (px-cx)-sin(theta)*(py*oy)+ox
        //py = sin(theta) * (px-cx)+cos(theta)*(py*oy)+oy
    }
}
