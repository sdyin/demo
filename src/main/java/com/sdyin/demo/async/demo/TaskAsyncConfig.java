package com.sdyin.demo.async.demo;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author: liuye
 * @Date: 2018/9/10 21:30
 * @Description
 */
@Configuration
@ComponentScan("com.sdyin.demo.*")
@EnableAsync
public class TaskAsyncConfig implements AsyncConfigurer {


  @Nullable
  @Override
  public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
    return null;
  }

  @Nullable
  @Override
  public Executor getAsyncExecutor() {
    ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
    taskExecutor.setCorePoolSize(5);
    taskExecutor.setMaxPoolSize(30);
    taskExecutor.setQueueCapacity(50);
    taskExecutor.initialize();
    return taskExecutor;
  }


}
