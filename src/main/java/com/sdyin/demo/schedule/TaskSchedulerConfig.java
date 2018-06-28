package com.sdyin.demo.schedule;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author: liuye
 * @Date: 2018/6/28 13:37
 */
@Configuration
@ComponentScan("com.sdyin.demo.schedule")
@EnableScheduling
public class TaskSchedulerConfig {


}
