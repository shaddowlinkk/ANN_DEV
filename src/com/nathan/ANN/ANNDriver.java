package com.nathan.ANN;

import com.nathan.ANN.activations.Linear;
import com.nathan.ANN.activations.ActivationFunctions;

import java.util.ArrayList;

/**
 * Created by sip26 on 3/22/2018.
 */
public class ANNDriver {
   public static void main(String[] args){
       int inputs =2;
       int output =1;
       int[] hidden ={4,2};
       ActivationFunctions[] hac ={new Linear(1.0),new Linear(1.0)};
       NeuralNet net= new NeuralNet(inputs,output,hidden,hac,new Linear(1.0));
       ArrayList<Double> data = new ArrayList<>();
       data.add(3.1);
       data.add(3.2);
       net.setInputs(data);
       net.calc();
       System.out.println(net.getOutput().toString());
   }
}
