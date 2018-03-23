package com.nathan.ANN;
import com.nathan.ANN.activations.ActivationFunctions;

import java.util.ArrayList;

/**
 * Created by sip26 on 3/22/2018.
 */
public class NeuralNet {

    private ArrayList<HiddenLayer> hiddenLayer;
    private int numberofhiddenlayers;
    private int NumberOfInputs;
    private int NumberOfOutputs;
    private ArrayList<Double> Inputs;
    private ArrayList<Double> OutPuts;
    private InputLayer inputLayer;
    private OutputLayer outputLayer;

    public NeuralNet(int numberofinputs,int numberofoutpus, int[] numberofhiddenneurons,ActivationFunctions[] hiddenactivation,ActivationFunctions outputactivation ){
        numberofhiddenlayers=numberofhiddenneurons.length;
        NumberOfInputs=numberofinputs;
        NumberOfOutputs=numberofoutpus;
        if(numberofhiddenlayers==hiddenactivation.length){
            Inputs= new ArrayList<>(numberofinputs);
            inputLayer = new InputLayer(numberofinputs);
            if(numberofhiddenlayers>0){
                hiddenLayer = new ArrayList<>(numberofhiddenlayers);
            }
            for (int i =0;i<numberofhiddenlayers;i++){
                if(i==0){
                    try {
                        hiddenLayer.set(i,new HiddenLayer(numberofhiddenneurons[i],hiddenactivation[i],inputLayer.getNumberOfNeurons()));
                    }catch (IndexOutOfBoundsException e){
                        hiddenLayer.add(i,new HiddenLayer(numberofhiddenneurons[i],hiddenactivation[i],inputLayer.getNumberOfNeurons()));
                    }
                    inputLayer.setNext(hiddenLayer.get(i));

                }else{
                    try {
                        hiddenLayer.set(i,new HiddenLayer(numberofhiddenneurons[i],hiddenactivation[i],hiddenLayer.get(i-1).getNumberOfNeurons()));
                    }catch (IndexOutOfBoundsException e){
                        hiddenLayer.add(i,new HiddenLayer(numberofhiddenneurons[i],hiddenactivation[i],hiddenLayer.get(i-1).getNumberOfNeurons()));
                    }
                    hiddenLayer.get(i-1).setNext(hiddenLayer.get(i));
                }
            }
            if(numberofhiddenlayers>0){
                outputLayer = new OutputLayer(numberofoutpus,outputactivation,hiddenLayer.get(numberofhiddenlayers-1).getNumberOfNeurons());
                hiddenLayer.get(numberofhiddenlayers-1).setNext(outputLayer);
            }else {
                outputLayer= new OutputLayer(numberofoutpus,outputactivation,numberofinputs);
                inputLayer.setNext(outputLayer);
            }
        }

    }

    public void setInputs(ArrayList<Double> inputs){
        if(inputs.size()==NumberOfInputs)
            Inputs=inputs;
    }
    public void calc(){
        inputLayer.setInputs(Inputs);
        inputLayer.calc();
        if(numberofhiddenlayers>0){
            for (int i =0;i<numberofhiddenlayers;i++){
                HiddenLayer hl= hiddenLayer.get(i);
                hl.setInputs(hl.getPreivous().getOutputs());
                hl.calc();
            }
        }
        outputLayer.setInputs(outputLayer.getPreivous().getOutputs());
        outputLayer.calc();
        this.OutPuts= outputLayer.getOutputs();
    }
    public ArrayList<Double> getOutput(){return this.OutPuts;}
}
