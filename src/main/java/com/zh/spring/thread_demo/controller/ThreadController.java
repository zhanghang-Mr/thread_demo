package com.zh.spring.thread_demo.controller;


import com.zh.spring.thread_demo.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

@RestController
public class ThreadController {

    @Qualifier("taskExecutor")
    @Autowired
    private Executor taskExecutor;

    @Autowired
    ThreadService threadService;

    @GetMapping("/task-thread")
    public Map<String,Object> getTaskThread(){
        Map<String,Object> map = new HashMap<>();

        return null;
    }

    @GetMapping("/thread")
    public String addThrea() throws ExecutionException, InterruptedException {
        threadService.addThread();
//            Future<String> future =  threadService.addThread();
//            System.out.println("---a--:"+future.get());

        return "hello";
    }
}
