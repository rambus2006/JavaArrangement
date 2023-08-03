package _07AbstractMethod;


abstract class Calculator{ //추상 클래스
    public abstract int add(int a,int b); //추상 메소드
    public abstract int substract(int a, int b); //추상 메소드
    public abstract double average(int[]a); //추상메소드
}
public class GoodCalc extends Calculator{ //일반 클래스(서브 클래스) 추상클래스를 상속 받음
    @Override
    public int add(int a, int b){ //추상 메소드 구현
        return a+b;
    }
    @Override
    public int substract(int a,int b){ //추상 메소드 구현
        return a-b;
    }
    @Override
    public double average(int[]a){ //추상메소드 구현
        double sum=0;
        for(int i=0;i<a.length;i++)
            sum +=a[i];
        return sum/a.length;
    }

    public static void main(String[] args) {
        GoodCalc c = new GoodCalc();
        System.out.println(c.add(2,3));
        System.out.println(c.substract(2,3));
        System.out.println(c.average(new int[]{2,3,4}));
    }
}
