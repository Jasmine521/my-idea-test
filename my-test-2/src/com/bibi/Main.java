package com.bibi;

public class Main {
    public static void main(String[] args) {
        Integer n = null;
        int x = 10;
        System.out.println(fact(x));
    }
    public static int fact(int n){
        if(n<0){
            return -1;
        }
        if(n==0) return 0;
        int ans=1;
        for(int i=1;i<=n;i++){
            ans = ans * i;
        }
        return ans;
    }
}
