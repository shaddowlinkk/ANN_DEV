package com.nathan.ANN;

import com.nathan.ANN.activations.ActivationFunctions;

/**
 * Created by sip26 on 3/20/2018.
 */
public class HiddenLayer  extends NeuronLayer{
    public HiddenLayer(int NumberofNeuron, ActivationFunctions function , int numberofnputs){
        super(NumberofNeuron,function);
        NumberOfInputs=numberofnputs;
        init();
    }
    @Override
    public void setNext(NeuronLayer next){
        this.next = next;
        if(next.getPreivous()!=this)
            next.setPreivous(this);
    }
    @Override
    public void setPreivous(NeuronLayer preivous){
        this.preivous=preivous;
        if(preivous.getNext()!=this)
            preivous.setPreivous(this);
    }
}
