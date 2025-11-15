package core.threads;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyRunnable implements Runnable {
    private final Logger logger = Logger.getAnonymousLogger();
    @Override
    public void run() {
        logger.log(Level.INFO, "Call MyRunnable");
    }
}
