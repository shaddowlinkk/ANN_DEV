package com.nathan.ANN;

import com.nathan.ANN.activations.Linear;

/**
 * Created by sip26 on 3/21/2018.
 */
public class InputNeuron extends Neuron{
    public InputNeuron(){
        super(1);
        setFunction(new Linear(1.0));
        bies=0.0;
    }


    @Override
    public void init(){
        try{
            this.Wights.set(0, 1.0);
            this.Wights.set(1, 0.0);
        }
        catch(IndexOutOfBoundsException iobe){
            this.Wights.add(1.0);
            this.Wights.add(0.0);
        }
    }
}
