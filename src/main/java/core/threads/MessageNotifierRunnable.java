package core.threads;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MessageNotifierRunnable implements Runnable {
    private final Logger logger = Logger.getAnonymousLogger();
    private final Message message;

    public MessageNotifierRunnable(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            synchronized (message) {
                message.setText(Thread.currentThread().getName());
                message.notifyAll();
            }
        } catch (InterruptedException e) {
            logger.log(Level.WARNING, e.getMessage(), e);
        }

        logger.log(Level.INFO, message.getText());
    }
}
