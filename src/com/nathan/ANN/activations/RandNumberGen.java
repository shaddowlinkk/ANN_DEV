package com.nathan.ANN.activations;

import java.util.Random;

/**
 * Created by sip26 on 3/20/2018.
 */
public class RandNumberGen {
    /**
     * Seed that is used for random number generation
     */
    public static long seed=0;
    /**
     * Random singleton object that actually generates the random numbers
     */
    public static Random r;
    /**
     * GenerateNext
     * Static method that returns a newly random number
     * @return
     */
    public static double GenerateNext(){
        if(r==null)
            r = new Random(seed);
        return r.nextDouble();
    }

    /**
     * setSeed
     * Sets a new seed for the random generator
     * @param seed new seed for random generator
     */
    public static void setSeed(long seed){
        seed=seed;
        r.setSeed(seed);
    }
}
