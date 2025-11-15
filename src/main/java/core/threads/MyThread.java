package core.threads;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyThread extends Thread {
    private final Logger logger = Logger.getAnonymousLogger();
    @Override
    public void run() {
        logger.log(Level.INFO, getState().name());
        logger.log(Level.INFO, "Call MyThread");
    }
}
