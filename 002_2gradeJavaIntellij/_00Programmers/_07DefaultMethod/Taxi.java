package _00Programmers._07DefaultMethod;

public class Taxi implements Meter{
    @Override
    public void afterMidnight(){

    }
    public void start(){
        System.out.println("택시가 출발합니다.");
    }

    public int stop(int distance){
        int fare = distance * 2;
        System.out.println("택시가 도착했습니다. 요금은 "+fare+"입니다.");
        return fare;
    }
}