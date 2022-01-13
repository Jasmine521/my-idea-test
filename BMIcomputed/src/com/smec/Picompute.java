package com.smec;

public class Picompute {
    public  static void main(String[] args){
        double pi = 0;
        for(double i =1,k=1;i<1.010e9;i+=2){
            pi += 4.0*k/i;
            k *= -1;
            //System.out.println(i);
        }
        System.out.println(pi);
    }
}
