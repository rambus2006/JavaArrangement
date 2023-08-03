package _09Package.app;

import _09Package.lib.Calculator;

public class GoodCal extends Calculator {
    public int add(int a,int b){
        return a+b;
    }
    public int substract(int a,int b){
        return a-b;
    }
    public double average(int[]a){
        double sum=0;
        for(int i=0;i<a.length;i++)
            sum +=a[i];
        return sum/a.length;
    }

    public static void main(String[] args) {
        Calculator c = new GoodCal();
        System.out.println(c.add(2,3));
        System.out.println(c.substract(2,3));
        System.out.println(c.average(new int[]{2,3,4}));
    }
}