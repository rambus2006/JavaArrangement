package _00Programmers._07DefaultMethod;

public class TaxiExam{
    public static void main(String[] args){
        Taxi taxi = new Taxi();

        taxi.start();
        taxi.afterMidnight();
        taxi.stop(10);
    }
}