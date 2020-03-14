package problem2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CachedData implements Runnable {
    public int targetData;
    public volatile boolean cacheIsValid = false;
    public ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            processCachedData();
        }
    }

    public void processCachedData() {
        try {
            if (!cacheIsValid) {

                reentrantReadWriteLock.writeLock().lock();
                try {
                    if (!cacheIsValid) {

                        ++targetData;

                        try {
                            TimeUnit.MILLISECONDS.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        cacheIsValid = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }

                try {
                    reentrantReadWriteLock.readLock().lock();
                    System.out.println(Thread.currentThread().getName() + ":" + targetData);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    reentrantReadWriteLock.readLock().unlock();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CachedData cachedData = new CachedData();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.execute(cachedData);
        }
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cachedData.cacheIsValid = false;
    }
}
