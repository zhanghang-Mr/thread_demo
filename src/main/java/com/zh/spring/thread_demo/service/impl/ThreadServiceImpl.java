package com.zh.spring.thread_demo.service.impl;

import com.zh.spring.thread_demo.service.ThreadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

//@Component
@Service("threadService")
public class ThreadServiceImpl implements ThreadService {

    Logger log = LoggerFactory.getLogger(ThreadServiceImpl.class);

    public volatile int  count = 0;
    @Async("taskExecutor")
    @Override
    public void addThread() throws InterruptedException {
        log.info("---进入serviceimpl---");
//        return "---hello task thread---";
        count ++;
        Thread.sleep(5000);
//        return new AsyncResult<String>("---hello--"+count);
        log.info("---结束serviceimpl---");
    }
}
