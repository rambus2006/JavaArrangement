package _19PerformTest._03Interface;

public class Cat implements Animal{
    @Override
    public void eat(){
        System.out.println("먹고있음");
    }
    @Override
    public void move(){
        System.out.println("움직임");
    }
    @Override
    public void bark(){
        System.out.println("야옹");
    }
}
