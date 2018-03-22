package com.nathan.ANN;

import com.nathan.ANN.activations.ActivationFunctions;

import java.util.AbstractList;
import java.util.ArrayList;

/**
 * Created by sip26 on 3/20/2018.
 */
public  abstract class NeuronLayer {
    protected int NumberOfNeurons;
    private ArrayList<Neuron> Neurons;
    protected ArrayList<Double> Outputs;
    protected ArrayList<Double> Inputs;
    protected int NumberOfInputs;
    protected NeuronLayer next;
    protected NeuronLayer preivous;
    protected ActivationFunctions function;

    public NeuronLayer(int NumberOFNeurons){
        this.NumberOfNeurons=NumberOFNeurons;
        Outputs= new ArrayList<>(NumberOFNeurons);
        Neurons= new ArrayList<>(NumberOFNeurons);
    }
    public NeuronLayer(int NumberOFNeurons,ActivationFunctions function){
        this.NumberOfNeurons=NumberOFNeurons;
        this.function=function;
        Outputs= new ArrayList<>(NumberOFNeurons);
        Neurons= new ArrayList<>(NumberOFNeurons);
    }

    public void init(){
        if(NumberOfNeurons>0){
            for (int i =0; i<NumberOfNeurons;i++){
                try {
                    Neurons.get(i).setFunction(function);
                    Neurons.get(i).init();
                }catch (IndexOutOfBoundsException e){
                    Neurons.add(new Neuron(NumberOfInputs,function));
                    Neurons.get(i).init();
                }
            }
        }
    }

    public void calc(){
        if(Inputs!=null&&Neurons!=null){
            for (int i=0; i<NumberOfNeurons;i++){
                Neurons.get(i).setInputs(Inputs);
                Neurons.get(i).calc();
                try {
                    Outputs.set(i,Neurons.get(i).getOutput());
                }catch (IndexOutOfBoundsException e){
                    Outputs.add(Neurons.get(i).getOutput());
                }
            }

        }
    }

    public void setInputs(ArrayList<Double> Inputs){
        NumberOfInputs=Inputs.size();
        this.Inputs=Inputs;
    }
    public ArrayList<Double> getOutputs(){
        return Outputs;
    }
    public void setFunction(ActivationFunctions function){
        this.function=function;
    }
    public void setNeuron(int i, Neuron neuron){
        try {
            Neurons.set(i, neuron);
        }catch (IndexOutOfBoundsException e){
            Neurons.add(neuron);
        }
    }
    public Neuron getNeuron(int i){
        return Neurons.get(i);
    }
    public int getNumberOfNeurons(){
        return NumberOfNeurons;
    }
    public ArrayList<Neuron> getListOfNeurons(){
        return Neurons;
    }
    public void setNext(NeuronLayer next){
        this.next= next;
    }
    public void setPreivous(NeuronLayer preivous){
        this.preivous=preivous;
    }
    public NeuronLayer getNext(){
        return next;
    }
    public NeuronLayer getPreivous(){
        return preivous;
    }

}
