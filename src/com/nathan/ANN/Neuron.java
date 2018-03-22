package com.nathan.ANN;

import com.nathan.ANN.activations.ActivationFunctions;
import com.nathan.ANN.activations.RandNumberGen;

import java.util.ArrayList;

/**
 * Created by sip26 on 3/20/2018.
 */
public class Neuron {
    private int numberOfInputs;
    private ArrayList<Double> Inputs;
    protected ArrayList<Double> Wights;
    protected Double bies = 1.0;
    private Double Output;
    private Double OutputToActivation;
    private ActivationFunctions function;

    public Neuron(int numberOfInputs){
        this.numberOfInputs=numberOfInputs;
        Inputs= new ArrayList<>(numberOfInputs);
        Wights= new ArrayList<>(numberOfInputs+1);

    }

    public Neuron(int numberOfInputs,ActivationFunctions ACFN){
        this.numberOfInputs=numberOfInputs;
        Inputs= new ArrayList<>(numberOfInputs);
        Wights= new ArrayList<>(numberOfInputs+1);
        function= ACFN;
    }

    public void init(){
        if(numberOfInputs>0){
            for (int i =0;i<=numberOfInputs;i++){
                double newWeight = RandNumberGen.GenerateNext();
                try {
                    Wights.set(i,newWeight);
                }catch (IndexOutOfBoundsException e){
                    Wights.add(newWeight);
                }
            }
        }
    }

    public void calc(){
      //  try {
            OutputToActivation = 0.0;
            if (numberOfInputs > 0) {
                if (Inputs != null && Wights != null) {
                    for (int i = 0; i <= numberOfInputs; i++) {
                        OutputToActivation += ((i == numberOfInputs) ? bies : Inputs.get(i)) * Wights.get(i);
                    }
                }
            }
            Output = function.calc(OutputToActivation);
        /*}catch (IndexOutOfBoundsException e){
            System.out.println("lvc:"+numberOfInputs);
            System.out.println("in:"+Inputs.size());
            System.out.println("wight:"+Wights.size());
        }*/
    }

    public void setInputs(ArrayList<Double> Inputs){
        this.Inputs=Inputs;
    }
    public Double getOutput(){
        return Output;
    }
    public void setFunction(ActivationFunctions function){
        this.function= function;
    }

}
