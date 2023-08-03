class CountRunnable implements Runnable {
    private int count;
    public CountRunnable(int count) {
        this.count = count;
    }
    @Override
    public void run() {
        for(int i=count;i>0;i--) {
            System.out.println(Thread.currentThread().getName() + " " + i); //currentThread():현재 실행하고 있는 스레드 , getName(): 스레드의 이름을 반환
            try {
// 스레드 1초 정지시키기 (waiting 상태로 변경되며 다른 스레드에게 CPU의 영유권을 양)
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
        System.out.println("terminate thread");
    }
}
public class ThreadConcurrencyDemo { //부모스레드가 끝났다고 해서 자식도 같이 종료되는 것이 아니다. 자식은 나중에 끝남
    public static void main(String[] args) { //메인 스레드가 가장 먼저 종료
        System.out.println(Thread.currentThread().getName() + " " ); //currentThread():현재 실행하고 있는 스레드 , getName(): 스레드의 이름을 반환

        Thread thread1 = new Thread(new CountRunnable(10)); //10초동안 thread1 실행 후 종료
        Thread thread2 = new Thread(new CountRunnable(5)); //5초 동안 thread2 실행 후 종료
// 스레드 이름 변경
        thread1.setName("Thread 1");
        thread2.setName("Thread 2");
        thread1.start();
//        스레드 우선순위
//        스레드 스케쥴러는 각 스레드에 실행 시간을 할당해주는데 얼마나 많은 시간을 할당해주느냐는 우
//        선순위에 따라 달라짐
//        하지만 절대적이라고는 할 수 없으며 JVM 구현에따라, 운영체제 스케쥴러 정책에 따라서 시간
//        할당 정도가 달라질 수 있음
//        1 ~ 10까지 지정 가능하며 미리 지정해 놓은 상수도 있음
//        MIN_PRIORITY : 1
//        NORM_PRIORITY : 5
//        MAX_PRIORITY : 10
//        기본적으로 스레드 생성시 우선순위는 NORM_PRIORITY
//        ThreadPriorityDemo.java
//        스레드 종료
//        run 메서드가 종료되면 스레드도 종료됨
//        run 메서드 실행 도중에 스레드를 종료하고 싶을 경우 일반적인 스레드 종료 처리 방법은 다음의 두
//                방식
//        1. 종료 플래그 변수의 상태를 확인하여 종료 (단, 이 경우 volatile 키워드 사용 필요)
//        2. 인터럽트 신호를 보내서 종료
        thread2.start();
    }
}
    