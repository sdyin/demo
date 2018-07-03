package com.sdyin.demo.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: liuye
 * @Date: 2018/6/28 13:39
 */
@Service
public class ScheduledTaskService {

  //@Scheduled(fixedRate = 10000)
  public void reportCurrentTime(){
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    System.out.println("每隔10s执行一次:"+ sdf.format(new Date()));
  }

  @Scheduled(cron = "0 45 13 ? * *" )
  public void fixTime(){
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    System.out.println("指定时间执行:"+ sdf.format(new Date()));
  }
}
