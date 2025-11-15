package core.threads;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LongCalcRunnable implements Runnable{
    private final Logger logger = Logger.getAnonymousLogger();

    @Override
    public void run() {
        logger.log(Level.INFO, LongCalcRunnable.class.getName());
        logger.log(Level.INFO, "Current time: " + System.currentTimeMillis());
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            logger.log(Level.INFO, e.getMessage(), e);
        }
        logger.log(Level.INFO, "Current time: " + System.currentTimeMillis());
    }
}
