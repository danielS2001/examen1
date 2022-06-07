package com.example.examen1;

import java.io.Serializable;

public class Rectangulo implements Serializable {
    private float base;
    private float altura;

    public Rectangulo() {

    }

    public Rectangulo(float base, float altura) {
        this.base = base;
        this.altura = altura;
    }

    public Rectangulo(Rectangulo rectangulo) {
        rectangulo.base = base;
        rectangulo.altura = altura;
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    //Métodos de comportamiento
    public double calculoArea() {
        double area = base * altura;
        return area;
    }

    public double calculoPerimetro() {
        double perimetro = (base * 2) + (altura * 2);
        return perimetro;
    }
}
