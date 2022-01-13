package com.smec;

import com.sun.javafx.image.IntToBytePixelConverter;
import com.sun.javafx.image.impl.ByteBgraPre;
import com.sun.javafx.image.impl.ByteIndexed;

import javax.management.StringValueExp;
import java.util.Scanner;
import java.util.function.IntToLongFunction;

public class Hello {
    public static void main(String[] args){
        System.out.println("com.smec.Hell啊哈哈o,world鸡汤来咯!");
        int x=100;
        System.out.println(x);
        x=200;
        System.out.println(x);
        int n=2_000_000;
        float f1=1.24f;
        double d=16.726e16;
        boolean b1=true;
        System.out.println(b1);
        char a='A';
        char b='中';
        System.out.println(a);
        System.out.println(b);
        System.out.println(d);
        final double PI=3.14;
        double r = 5.0;
        double area = PI * r * r;
        int nx = 4512481;
        System.out.println(nx);
        System.out.println(nx/7);
        System.out.println(nx%7);
        System.out.println(nx/7*7+nx%7);
        x=2147483640;       //2147483647
        int y=15;
        long sum = Long.valueOf(x).longValue()+ y;
        System.out.println(sum);
        n = 7;
        n = n << 1;
        System.out.println(n);
        n =n << 27;
        System.out.println(n);

        n = -536870912;
        n = n >>> 1;
        System.out.println(n);
        n = n >>> 28;
        System.out.println(n);
        n = 1&1;
        System.out.println(n);
        n = 1^0;
        System.out.println(n);
        int i=167776589;
        n = 167776512;
        System.out.println(n&i);
        n = 12;
        System.out.println(n);
        short numb1 = (short)i ;
        System.out.println(numb1);
        i = 15;
        System.out.println(~i);
        d = -0.5/0;
        System.out.println(d);
        d = 0.0/0.0;
        System.out.println(d);
        d = 0.0/1.0;
        System.out.println(d);
        d=2.6;
        n = (int)d;
        System.out.println(n);
        n = (int)(d+0.5);
        System.out.println(n);
        boolean b2 = 5<3;
        boolean b3 = true || (5/0 > 0);
        System.out.println(b3);
        char a1 = 'A';
        char a2 = '\u4e32';
        i = a2;
        System.out.println(a2);
        String s = String.valueOf(i);
        System.out.println("ABC\n\u4e2d\u6587"+i);
        a=72;
        b=105;
        int c = new Integer(65281);
        String s1 =""+ Character.valueOf(a)+String.valueOf((char)a+(char)b);
        System.out.println(s1);
        int[] ns = new int[]{33,64,33,51,21,3215};
        ns[2]=1;
        System.out.println(ns.length);
        ns = new int[10];
        System.out.println(ns[9]);
        int [][] np = new int[][]{{21,29},{31,33}};
        System.out.println(np[0][0]);
        System.out.println(np[1][0]);
        System.out.printf("\\%s",s1);
        Scanner scanner=new Scanner(System.in);
        System.out.println();
        /*System.out.print("Input your last grade:");
        float name = scanner.nextFloat();
        System.out.print("input your this grade");
        float age = scanner.nextFloat();
        System.out.printf("Hi,you are %.2f%%.",(age-name)/name*100);*/
        double xd= 1 - 9.0/10;
        System.out.printf("%.10f",xd);
    }
}
