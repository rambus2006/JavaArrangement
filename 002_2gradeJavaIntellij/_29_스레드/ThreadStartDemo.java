package _29_스레드;


    // 1.
// 스레드를 상속받는 스레드 클래스 생성하고
    class MyThread extends Thread {
        // run 메서드 오버라이드해서 동시성 로직 작성
        @Override
        public void run() {
            System.out.println("run 1");
        }
    }
    // 2.
// Runnable 인터페이스를 구현하고
    class MyRunnable implements Runnable {
        // run 메서드 오버라이드해서 동시성 로직 작성
        @Override
        public void run() {
            System.out.println("run 2");
        }
    }
    public class ThreadStartDemo {
        public void main(String[] args) {
            MyThread myThread = new MyThread();
// myThread.run(); // run 메서드 호출시 스레드 생성하지 않고 그냥 메서드 실행듯이 run 메서드가 실행됨
            myThread.start();
// 스레드 생성자에 Runnable 객체 전달하여
            MyRunnable myRunnable = new MyRunnable();
            Thread thread = new Thread(myRunnable);
// run 메소드 로직 실행
            thread.start();
// 3.
// 익명 객체 만들며 바로 시작
            (new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("run 3");
                }
            })).start();
        }
    }


