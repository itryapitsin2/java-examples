package core.concurrent;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DeadLockExample {
    private static final Logger logger = Logger.getAnonymousLogger();

    private static class Record {
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public synchronized void printRelatedValue(Record relatedRecord) {
            logger.log(Level.INFO, value);
            relatedRecord.printRelatedValue(this);
        }
    }

    public static void main(String... args) throws InterruptedException {
        Record record1 = new Record();
        Record record2 = new Record();

        record1.setValue("Record 1");
        record2.setValue("Record 2");

        Thread thread1 = new Thread(() -> record1.printRelatedValue(record2));
        Thread thread2 = new Thread(() -> record2.printRelatedValue(record1));

        logger.log(Level.INFO, "Started!");

        thread1.start();
        thread2.start();

        logger.log(Level.INFO, "Completed!");
    }
}
