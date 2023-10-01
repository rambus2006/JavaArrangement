package _29_스레드;

class StoppableRunnable implements Runnable {

    // volatile 키워드가 붙었을 때, 없을 떄 차이 살펴보기

    // private volatile boolean stop = false;

    private boolean stop = false;


    @Override

    public void run() {

        long count = 0;

        while(!stop) {

            count++;

        }

        System.out.println(count);

        System.out.println("exit run");

    }


    public void stop() {

        // stop 값 변경 후 확인을 위해서 출력

        this.stop = true;

        System.out.println("stop runnable " + this.stop);

    }

}


public class VolatileDemo {

    public static void main(String[] args) {

        StoppableRunnable runnable = new StoppableRunnable();

        new Thread(runnable).start();


        new Thread(new Runnable() {

            @Override

            public void run() {

                try {

                    Thread.sleep(1000);

                } catch (InterruptedException e) {}

                // 1초 이후 stop 메서드를 호출하여 내부 stop 값을 true로 변경

                runnable.stop();

            }

        }).start();

    }

}