package thread.test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadB implements Runnable {

    public void run() {
        boolean interrupted = false;
        BlockingQueue<String> eventQueue =
                new LinkedBlockingQueue<String>();
        System.out.println(eventQueue.size());
        int i = 0;
        String e = "";
        while (!interrupted) {
            try {
                e = "i = " + i;
                System.out.println("before eventQueue.put e = " + e);
                eventQueue.put(e);
                System.out.println("after eventQueue.put e = " + e + ",eventQueue.size() = " + eventQueue.size());
                i++;
            } catch (InterruptedException e1) {
                try {
                    System.out.println("in InterruptedException e = " + e);
                    eventQueue.put(e);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                interrupted = true;
                e1.printStackTrace();
            }
        }

        System.out.println("The result is :" + eventQueue.size());
//        for(int j = 0; j < eventQueue.size(); j++){
//            System.out.println(eventQueue.remove());
//        }
    }
}
