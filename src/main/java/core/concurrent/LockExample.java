package core.concurrent;

import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LockExample {
    public static void main(String[] args) throws InterruptedException {
        CommonResource commonResource = new CommonResource();
        ReentrantLock reentrantLock = new ReentrantLock();

        for (int i = 0; i < 5; i++) {
            Runnable countRunnable = new CountRunnable(commonResource, reentrantLock);
            Thread countThread = new Thread(countRunnable);
            countThread.setName("Thread " + i);
            countThread.start();
        }
    }

    public static class CountRunnable implements Runnable {
        private final CommonResource commonResource;
        private final ReentrantLock reentrantLock;
        private final Logger logger = Logger.getAnonymousLogger();

        public CountRunnable(CommonResource commonResource, ReentrantLock reentrantLock) {
            this.commonResource = commonResource;
            this.reentrantLock = reentrantLock;
        }

        @Override
        public void run() {
            reentrantLock.lock(); // Устанавливаем блокировку
            try {
                for (int i = 0; i < 5; i++) {
                    logger.log(Level.INFO, Thread.currentThread().getName() + " " + commonResource.getValue());
                    commonResource.setValue(commonResource.getValue() + 1);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                reentrantLock.unlock();
            }
        }
    }
}
