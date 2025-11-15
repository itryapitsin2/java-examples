package core.threads;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getAnonymousLogger();

    public static void main(String[] args) throws InterruptedException {
        //#region Thread class example
        MyThread myThread = new MyThread();
        myThread.start();
        //#endregion

        //#region Runnable interface example
        Runnable myRunnable = new MyRunnable();
        Thread myRunnableThread = new Thread(myRunnable);
        myRunnableThread.start();
        //#endregion

        //#region notify/wait-methods example
        Message message = new Message();
        message.setText(Thread.currentThread().getName());
        logger.log(Level.INFO, message.getText());

        Runnable messageWaiterRunnable = new MessageWaiterRunnable(message);
        Runnable messageNotifierRunnable = new MessageNotifierRunnable(message);

        Thread messageWaiterRunnableThread = new Thread(messageWaiterRunnable);
        Thread messageNotifierRunnableThread = new Thread(messageNotifierRunnable);

        logger.log(Level.INFO, messageWaiterRunnableThread.getState().name());
        logger.log(Level.INFO, messageNotifierRunnableThread.getState().name());

        messageWaiterRunnableThread.start();
        messageNotifierRunnableThread.start();
        logger.log(Level.INFO, messageWaiterRunnableThread.getState().name());
        logger.log(Level.INFO, messageNotifierRunnableThread.getState().name());

        messageWaiterRunnableThread.join();
        messageNotifierRunnableThread.join();
        logger.log(Level.INFO, messageWaiterRunnableThread.getState().name());
        logger.log(Level.INFO, messageNotifierRunnableThread.getState().name());

        //#endregion

        //#region join-method example
        Runnable longCalcRunnable = new LongCalcRunnable();
        Thread longCalcRunnableThread = new Thread(longCalcRunnable);

        longCalcRunnableThread.start();
        longCalcRunnableThread.join();
        //#endregion

        //#region interrupt-method example
        Runnable infiniteRunnable = new InfiniteRunnable();
        Thread infiniteRunnableThread = new Thread(infiniteRunnable);
        infiniteRunnableThread.start();

        Thread.sleep(3_500);
        infiniteRunnableThread.interrupt();
        if(infiniteRunnableThread.isInterrupted()) {
            logger.log(Level.INFO, "infiniteRunnableThread was interrupted by main thread.");
        }
        infiniteRunnableThread.join();
        //#endregion
    }
}
