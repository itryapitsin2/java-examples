package core.concurrent;

import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommonResourceCallable implements Callable<CommonResource> {
    private static final Logger logger = Logger.getAnonymousLogger();

    @Override
    public CommonResource call() throws Exception {
        CommonResource commonResource = new CommonResource();
        commonResource.setValue((int) Thread.currentThread().threadId());

        Thread.sleep(1000);

        return commonResource;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Future<CommonResource> task = executorService.submit(new CommonResourceCallable());

        logger.log(Level.INFO, "" + task.get().getValue());

        executorService.close();
    }
}
