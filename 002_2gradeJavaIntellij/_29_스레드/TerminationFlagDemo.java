package _29_스레드;

class TerminatableRunnable implements Runnable {

    private volatile boolean terminate = false;


    @Override

    public void run() {

        while(!terminate) {

            System.out.println("running...");

        }

        System.out.println("terminated");

    }


    public void terminate() {

        this.terminate = true;

    }

}


public class TerminationFlagDemo {

    public static void main(String[] args) {

        TerminatableRunnable terminatableRunnable = new TerminatableRunnable();

        (new Thread(terminatableRunnable)).start();


        (new Thread(new Runnable() {

            @Override

            public void run() {

                try {

                    Thread.sleep(1000);

                } catch (InterruptedException e) {}

                terminatableRunnable.terminate();

            }

        })).start();

    }

}
