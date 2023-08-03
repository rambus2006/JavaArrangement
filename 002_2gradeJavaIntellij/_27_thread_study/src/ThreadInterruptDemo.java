class InterruptableRunnable implements Runnable {
    @Override
    public void run() {
        while(true) {
            boolean isInterrupted = Thread.currentThread().isInterrupted();
            //방해를 해주면 true, 방해를 하지 않으면 false
            if(!isInterrupted) {
                System.out.println("running... " + isInterrupted);
// waiting 상태에 진입했을 때 interrupt가 생기면
                //InterruptedException //예외 발생
                //1. try catch 문에서 interrupt를 걸어 True가 되었다가 false로 break 해서 빠져나오는 방법
                //2. if 문에서 True를 줘서 break; 해서 나오는 벙법
                try {
                    Thread.sleep(1000); //sleep 에 있는 것을 깨우면 예외가 발생하며 catch 로 가서 실행한다.
                } catch (InterruptedException e) {
                    System.out.println("call interrupt from another thread!");
                    System.out.println("InterruptedException!");
                }
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
                    Thread.sleep(1000); //sleep 에 있는 것을 깨우면 예외가 발생하며 catch 로 가서 실행한다.
                } catch (InterruptedException e) {}
                    System.out.println("call interrupt from another thread!");
                    thread.interrupt();
            }
        })).start();
    }
}