class TerminatableRunnable implements Runnable {
    private volatile boolean terminate = false;
    @Override
    //플래그 변수
    public void run() {
        while(!terminate) { //게임에서 on off 할 때 플래그변수 를 사용한다.
            //System.out.println("running...");

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
