package com.nathan.ANN;

import com.nathan.ANN.activations.Linear;
import com.nathan.ANN.activations.ActivationFunctions;
import com.nathan.ANN.activations.RandNumberGen;
import com.nathan.ANN.activations.Sigmoid;

import java.util.ArrayList;

/**
 * Created by sip26 on 3/22/2018.
 */
public class ANNDriver {
   public static void main(String[] args){
       int inputs =2;
       int output =1;
       int[] hidden ={3};
       ActivationFunctions[] hac ={new Sigmoid(1.0)};
       NeuralNet net= new NeuralNet(inputs,output,hidden,hac,new Linear(1.0));
       ArrayList<Double> data = new ArrayList<>();
       data.add(1.0);
       data.add(2.1);
       net.setInputs(data);
       net.calc();
       System.out.println(net.getOutput().toString());
   }
}
