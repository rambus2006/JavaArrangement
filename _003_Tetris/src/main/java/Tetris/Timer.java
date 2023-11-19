package Tetris;

public class Timer{
    static String timer;
    static int oldTime;

    public static void stopWatch(int onAndOFF){
        if(onAndOFF ==1)
            oldTime = (int)System.currentTimeMillis()/1000;
        if(onAndOFF==0)
            secToHHMMSS (((int)System.currentTimeMillis()/1000)-oldTime);
    }
    //초단위 입력받아서 문자열 형식으로 시분초를 timer 변수에 저장
    public static void secToHHMMSS(int secs){
        int hour, min , sec;

        hour = secs / 3600;
        min = secs / 60%60;
        sec = secs % 60;

        timer = String.format("%02d:%02d:%02d",hour,min,sec);

    }
    public static void Waiting(){
        try{
            System.in.read();
        }catch (Exception e){}
    }

    public static void main(String[] args) {
        System.out.println("***** StopWatch *****");
        System.out.println("Timer ON! 엔터키를 누르면 종료합니다.");
        stopWatch(1);

        Waiting();

        stopWatch(0);
        System.out.format("Timer OFF! 경과시간 : [%s]%n",timer);
    }
}