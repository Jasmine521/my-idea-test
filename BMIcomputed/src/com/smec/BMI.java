package com.smec;

import java.util.Scanner;

public class BMI {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.printf("Input your weight(kg):");
        double ww= in.nextDouble();
        System.out.printf("Input your height(m):");
        double hh = in.nextDouble();
        double b = compute(ww,hh);
        System.out.printf("BMI:%f",b);
        standard(b);
    }
    public static double compute(double w, double h){
        if(h <= 0)return 0;
        double x=w/h/h;
        return x;
    }
    public static void standard(double b){
        if(b>32)System.out.println("非常肥胖");
        else  if(b>=28)System.out.println("肥胖");
        else  if(b>=25)System.out.println("过重");
        else  if (b>=18.5)System.out.println("正常");
        else System.out.println("过轻");

    }
}
