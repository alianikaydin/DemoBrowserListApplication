package com.example.core.di.scheduler

import androidx.annotation.NonNull
import java.util.concurrent.*

class JobExecutor : Executor {

    private val mThreadPoolExecutor: ThreadPoolExecutor

    init {
        val workQueue = LinkedBlockingQueue<Runnable>()
        val threadFactory = JobThreadFactory()
        this.mThreadPoolExecutor = ThreadPoolExecutor(
            INITIAL_POOL_SIZE, MAX_POOL_SIZE,
            KEEP_ALIVE_TIME.toLong(), KEEP_ALIVE_TIME_UNIT, workQueue, threadFactory
        )
    }

    override fun execute(@NonNull runnable: Runnable) {
        this.mThreadPoolExecutor.execute(runnable)
    }

    private class JobThreadFactory : ThreadFactory {
        private var counter = 0

        override fun newThread(@NonNull runnable: Runnable): Thread {
            return Thread(runnable, THREAD_NAME_ + counter++)
        }

        companion object {
            private val THREAD_NAME_ = "android_"
        }
    }

    companion object {

        private val INITIAL_POOL_SIZE = 3
        private val MAX_POOL_SIZE = 5

        // Sets the amount of time an idle thread waits before terminating
        private val KEEP_ALIVE_TIME = 10

        // Sets the Time Unit to seconds
        private val KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS
    }
}