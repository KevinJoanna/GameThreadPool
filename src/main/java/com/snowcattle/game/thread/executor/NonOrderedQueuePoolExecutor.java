package com.snowcattle.game.thread.executor;

/**
 * Created by jiangwenping on 17/3/10.
 */


import com.snowcattle.game.thread.ThreadNameFactory;
import com.snowcattle.game.thread.worker.AbstractWork;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 无序队列线程池
 * @author zhaohui
 *
 */
public class NonOrderedQueuePoolExecutor extends ThreadPoolExecutor {

    public NonOrderedQueuePoolExecutor(int corePoolSize) {
        super(corePoolSize, corePoolSize*2, 30, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());
    }

    public NonOrderedQueuePoolExecutor(String name, int corePoolSize) {
        super(corePoolSize, corePoolSize*2, 30, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(), new ThreadNameFactory(name));
    }

    public NonOrderedQueuePoolExecutor(String name, int corePoolSize, int maxSize) {
        super(corePoolSize, maxSize, 30, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(), new ThreadNameFactory(name));
    }

    public NonOrderedQueuePoolExecutor(String name, int corePoolSize, int maxSize, RejectedExecutionHandler rejectedExecutionHandler) {
        super(corePoolSize, maxSize, 30, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(), new ThreadNameFactory(name), rejectedExecutionHandler);
    }

    public void executeWork(AbstractWork work) {
        execute(work);
    }

}