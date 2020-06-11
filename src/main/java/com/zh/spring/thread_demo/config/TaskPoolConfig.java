package com.zh.spring.thread_demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * 线程池配置类
 */

@Configuration
@EnableAsync
public class TaskPoolConfig {
    @Bean("taskExecutor")
    public Executor taskExecutro(){
        System.out.println("---taskpoolconfig----");
//        SingleThreadPool singleExecutor = new SingleThreadPool();
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(10);   //核心线程池数量
        taskExecutor.setMaxPoolSize(50);    //最大线程池数量
        taskExecutor.setQueueCapacity(200);   //配置队列大小
        // 线程最大空闲时间
        taskExecutor.setKeepAliveSeconds(60); //
        // 配置线程池中的线程的名称前缀
        taskExecutor.setThreadNamePrefix("taskExecutor--");
        // 等待所有任务结束后再关闭线程池
//        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
//        taskExecutor.setAwaitTerminationSeconds(60);
        return taskExecutor;
    }

}
