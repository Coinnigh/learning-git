package thread.test;

public class ThreadA implements Runnable{

    public void run() {
        boolean interrupted = false;
        while(true && !interrupted){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                interrupted = true;
            }
            System.out.println("I am thread A, I am running");
        }
    }
}
