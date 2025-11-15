package core.threads;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InfiniteRunnable implements Runnable {
    private final Logger logger = Logger.getAnonymousLogger();

    @Override
    public void run() {
        int count = 0;
        while (true) {
            try {
                Thread.sleep(1000);
                logger.log(Level.INFO, "Iteration number: " + count);
                count++;
            } catch (InterruptedException e) {
                logger.log(Level.INFO, "Thread interrupted exception.");
                break;
            }
        }
    }
}
