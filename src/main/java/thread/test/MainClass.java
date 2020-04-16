package thread.test;

import sun.applet.Main;

public class MainClass {
    public static void main(String[] args) {
        ThreadB threadB = new ThreadB();
        Thread ta = new Thread(threadB);
        ta.start();
        try {
            ta.join(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ta.interrupt();
//        ThreadA threadA = new ThreadA();
//        Thread ta = new Thread(threadA);
//        ta.start();
//        try {
//            ta.join(3000);
//            ta.interrupt();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("threadA is finished");
    }

    public synchronized void testException(){
        try {
                Thread.currentThread().wait(2000);
                Thread.currentThread().notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
