
//1. Thread 클래스를 상속받는 클래스
class MyThread extends Thread{
    @Override //스레드를 상속받음
    public void run(){ // 스레드와 동시에 진행된다. 
        System.out.println("run 1"); 
    }
}
//2. Runnable 인터페이스를 구현
//장점: 상속을 할 수 있다.
class MyRunnable implements Runnable{
    private int count;

    @Override
    public  void run(){
        System.out.println("run 2");
    }

}
public class ThreadStartDemo {
    //메인스레드가 항상 있기 때문에 스레드 개수를 쓸 때 꼭 (만든 스레드 + 1) 을 해줘야 한다.
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        //(x) myThread.run() =>메서드 호출하는 것처럼 메인메서드가 호출된다.
        myThread.start(); //run 이 실행된다. 새로운 메서드를 만들어 호출된다.

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

        //새 스레드에서 동시에 실행이 된다.
        (new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run 3");
            }
        })).start();
    }
}
