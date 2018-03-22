package com.nathan.ANN.activations;

/**
 * Created by sip26 on 3/21/2018.
 */
public class Linear implements ActivationFunctions {
    private double a = 1.0;
    public Linear(){};
    public Linear(Double x){this.a=x;}
    public void setA(Double value){this.setA(value);}
    public double calc(double x){return a*x;}
}
