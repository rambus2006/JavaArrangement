package _29_스레드;

class InterruptableRunnable implements Runnable {


    @Override

    public void run() {

        while(true) {

            boolean isInterrupted = Thread.currentThread().isInterrupted();

            if(!isInterrupted) {

                System.out.println("running... " + isInterrupted);


                // waiting 상태에 진입했을 때 interrupt가 생기면 InterruptedException 예외 발생

                /*

                try {

                    Thread.sleep(100);

                } catch (InterruptedException e) {

                    System.out.println("InterruptedException!");

                    break;

                }

                */

            } else {

                break;

            }

        }

    }

}


public class ThreadInterruptDemo {

    public static void main(String[] args) {

        Thread thread = new Thread(new InterruptableRunnable());

        thread.start();


        (new Thread(new Runnable() {

            @Override

            public void run() {

                try {

                    Thread.sleep(1000);

                } catch (InterruptedException e) {}

                System.out.println("call interrupt from another thread!");

                thread.interrupt();

            }

        })).start();

    }

}
