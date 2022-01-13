package asclass;

public class Main {
    public static void main(String[] args){
        int i=100;
        Integer n1 = new Integer(i);
        Integer n2 = Integer.valueOf(i);
        Integer n3 = Integer.valueOf("111");
        System.out.println(n3.intValue()+" "+n2.intValue()+" "+n1.intValue()+" "+Integer.valueOf(i));
    }
}
