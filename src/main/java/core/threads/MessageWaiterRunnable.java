package core.threads;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MessageWaiterRunnable implements Runnable {
    private final Logger logger = Logger.getAnonymousLogger();
    private final Message message;

    public MessageWaiterRunnable(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        synchronized (message) {
            try {
                message.wait();
                message.setText(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                logger.log(Level.WARNING, e.getMessage(), e);
            }
            logger.log(Level.INFO, message.getText());
        }
    }
}
