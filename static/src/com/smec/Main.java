package com.smec;

import java.applet.AudioClip;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        Person.setNumber(77);
        System.out.println(Person.number);
        Person p =new Person("xiao wang",36);
        System.out.println(p.number);
        Adult yadang = new Male();
        System.out.println("Person:"+Male.getCount()+" Male:"+((Male)yadang).getMaleCount());
        Adult xiawa = new Female();
        System.out.println("Person:"+Male.getCount()+" Female"+((Female)xiawa).getFemaleCount());
    }
}

class Person{
    private String name;
    private int age;
    public static int number;
    public Person(String name,int age){
        this.name=name;
        this.age=age;

    }
    public static void setNumber(int value){
        Person.number=value;
    }
}

class Adult{
    static int count;

    public static int getCount() {
        return 0;
    }
}
class Male extends Adult{

    private int maleCount;
    Male(){
        count++;
        maleCount++;
    }
    public static int getCount() {
        return Male.count;
    }
    public int getMaleCount(){
        return this.maleCount;
    }
}
class Female extends  Adult{

    private int femaleCount;
    Female(){
        count++;
        femaleCount++;
    }

    public static int getCount() {
        return Male.count;
    }
    public int getFemaleCount(){
        return this.femaleCount;
    }
}
