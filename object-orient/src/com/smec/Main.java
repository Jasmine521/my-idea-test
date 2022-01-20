package com.smec;

public class Main {
    public static void main(String[] args) {
        Person1 p = new Person1();
        String[] fullname = new String[]{"Homer", "Simpson"};
        p.setName(fullname);
        System.out.println(p.getName());
        fullname[0] = "Brat";
        System.out.println(p.getName());
        String s = "Test string";
        int n1 = s.indexOf("st", 3);
        System.out.println(n1);
        Student mz = new Student();
        mz.setName(new String[]{"xiao", "hu"});

        System.out.println(mz.Hello());
        Person1 p1 = new Student();
        Person1 p2 = new Person1();
        System.out.println(p1 instanceof Student);
        Student s1 = (Student) p1;
        p2 = s1;
        Object o1 = s1;
        System.out.println("991".hashCode());
    }

    ;

}

class Person1 {
    protected String[] name;

    public String getName() {
        return this.name[0] + " " + this.name[1];
    }

    public void setName(String[] name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person1:name=" + this.getName();
    }
}

class Student extends Person1 {
    public String Hello() {
        return "Hello," + name[0] + " " + name[1];
    }
}