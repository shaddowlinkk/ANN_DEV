package com.nathan.ANN.activations;

/**
 * Created by sip26 on 3/20/2018.
 */
public interface ActivationFunctions {

    double calc(double x);

    public enum ActivationFunctionENUM {
        STEP, LINEAR, SIGMOID, HYPERTAN
    }

}
