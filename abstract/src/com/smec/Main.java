package com.smec;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Income[] incomes = new Income[]{new R(7500), new S(10000)};
        double total = 0;
        for (Income n : incomes) {
            total += n.getTex();
        }
        System.out.println(total);
        List list = new ArrayList();
        Collection coll = list;
        Iterable it = coll;
    }
}

abstract class Income {
    protected double income;

    public Income(double a) {
        this.income = a;
    }

    public abstract double getTex();
}

class R extends Income {
    public R(double a) {
        super(a);
    }

    @Override
    public double getTex() {
        if (income < 5000) return 0;
        else return (income - 5000) * 0.2;
    }
}

class S extends Income {
    public S(double a) {
        super(a);
    }

    @Override
    public double getTex() {
        if (income < 7000) return 0;
        else return (income - 7000) * 0.5;
    }
}

