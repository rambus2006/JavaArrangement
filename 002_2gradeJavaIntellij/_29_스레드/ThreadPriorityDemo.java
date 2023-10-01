package _29_스레드;

public class ThreadPriorityDemo {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<1000;i++) System.out.println("1");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<1000;i++) System.out.println("2");
            }
        });
        thread1.setPriority(10);
        thread2.setPriority(1);

        thread1.start();
        thread2.start();
    }
}
