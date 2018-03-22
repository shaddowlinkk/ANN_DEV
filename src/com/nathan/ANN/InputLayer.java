package com.nathan.ANN;

import com.nathan.ANN.activations.Linear;

import java.util.ArrayList;

/**
 * Created by sip26 on 3/21/2018.
 */
public class InputLayer extends NeuronLayer {
    public InputLayer( int numberofinputs ){
        super(numberofinputs,new Linear());
        preivous=null;
        NumberOfInputs=numberofinputs;
        init();
    }
    @Override
    public void setNext(NeuronLayer next){
        this.next = next;
        if(next.getPreivous()!=this)
            next.setPreivous(this);
    }
    @Override
    public void setInputs(ArrayList<Double> inputs){
        if(inputs.size()== NumberOfInputs){
            Inputs=inputs;
        }
    }
    @Override
    public void init(){
        for(int i=0;i<NumberOfInputs;i++){
            this.setNeuron(i,new InputNeuron());
            this.getNeuron(i).init();
        }
    }
    @Override
    public void calc(){
        if (Inputs!=null && this.getListOfNeurons()!=null){
                for (int i=0; i<NumberOfNeurons;i++){
                    double[] firstInput = {this.Inputs.get(i)};
                    getNeuron(i).setInputs(Inputs);
                    getNeuron(i).calc();
                    try {
                        Outputs.set(i,getNeuron(i).getOutput());
                    }catch (IndexOutOfBoundsException e){
                        Outputs.add(getNeuron(i).getOutput());
                    }
                }
        }
    }
}
