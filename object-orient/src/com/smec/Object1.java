package com.smec;

import static org.apache.commons.lang.StringUtils.isBlank;

public class Object1 {
    public static void main(String[] args) throws IllegalAccessException {
        Person ming = new Person();
//        ming.name="小明";
//        ming.age=16;
        ming.setName("xiao ming ");
        ming.setAge(11);
        System.out.println(ming.getName());
        System.out.println("name:"+ming.getName()+",brith:"+ming.getBrith());
        Person hong = new Person();
//        hong.name="小红";
//        hong.age=13;
        City bj = new City();
        bj.name = "bei jing";
        bj.latitude = 39.903;
        bj.longitude = 116.401;
        System.out.println(bj.name);
        System.out.println("location:"+bj.latitude+","+bj.longitude);

        Group g=new Group();
        g.setNames("xiaoming","xiaohong","xiaozhang");
        g.setNames("xiaoming","xiaohong");
        g.setNames("xiaoming");
        g.setNames();
    }
}
class City{
    public String name;
    public double latitude;     //纬度
    public double longitude;    //经度
}
class Person{
    private String name;
    private int age;
    public String getName(){
        return this.name;
    }

    public void setName(String name ) throws IllegalAccessException {
        if(name==null||isBlank(name)){
            throw new IllegalAccessException("invalid name");
        };
        this.name=name;
    }
    public int getAge(){
        return this.age;
    }
    public void setAge(int age) throws IllegalAccessException {
        if (age<0||age>100){
            throw new IllegalAccessException("invalid age value");
        }
        this.age=age;
    }
    public int getBrith(){
        return calcBrith(2021);
    }
    private int calcBrith(int currentYear){
        return currentYear - this.age;
    }
}
class Book{
    public String name;
    public String author;
    public String isbn;
    public  double price;
}
class Group{
    private String[] names;
    public void setNames(String... names){
        this.names = names;
    }
}