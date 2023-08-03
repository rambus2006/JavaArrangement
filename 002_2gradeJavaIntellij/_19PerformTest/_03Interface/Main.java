package _19PerformTest._03Interface;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();

        dog.move();
        dog.bark();
        dog.eat();

        Cat cat = new Cat();
        cat.move();
        cat.bark();
        cat.eat();
    }
}
