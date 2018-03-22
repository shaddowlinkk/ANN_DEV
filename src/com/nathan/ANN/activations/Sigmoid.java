package com.nathan.ANN.activations;

/**
 * Created by sip26 on 3/22/2018.
 */
public class Sigmoid implements ActivationFunctions {
    private double a=1.0;
    public void setA(double a){this.a=a;}
    public Sigmoid(double value){this.setA(value);}
    public double calc(double x){
        return 1.0/(1.0+Math.exp(-a*x));
    }
}
