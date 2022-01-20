package com.itranswarp.sample;

import com.itranswarp.world.Person;

import javax.print.attribute.standard.MediaSize;

public class Main {
    public static void main(String[] args) {
        Person p = new Person();
        p.hello();

        Outer outer = new Outer("Nested");
//        Object Outer = new Outer("a");
        Outer.Inner inner = outer.new Inner();
        inner.hello();
        xx cxx = new xx() {
            @Override
            void run() {
                System.out.println("xx running");
                super.run();
            }
        };
        cxx.run();
        Outer.Inx inx = new Outer.Inx();
        inx.hello();
    }
}

class Outer {
    private String name;
    private static String NAME = "OuTeR";

    Outer(String name) {
        this.name = name;
    }

    private String he() {
        return name;
    }

    class Inner {
        public void hello() {
            System.out.println("Inner:hello" + he());
        }

    }

    static class Inx {
        void hello() {
            System.out.println("Inx:hello  " + Outer.NAME);
        }
    }
}

abstract class xx {
    void run() {
    }

    ;
}