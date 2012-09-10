package com.purang.bill.socket.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Company :普兰科技
 * Create User:周明
 * Create Date:12-8-21
 * Create Time:上午9:13
 */
public class TestJob {
    public static void main(String[] args) {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            JobDetail job = newJob(HelloJob.class).withIdentity("HelloJob", "group1").build();
            //((JobDetailImpl)job).setDurability(true);
            //scheduler.addJob(job, false);
            CronScheduleBuilder sb = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
            //CronScheduleBuilder sb2 = CronScheduleBuilder.cronSchedule("2/7 * * * * ?");
            Trigger trigger = newTrigger().withIdentity("myTrigger", "group1").withSchedule(sb).build();
            //Trigger trigger2 = newTrigger().withIdentity("myTrigger2", "group1").withSchedule(sb2).startNow().forJob(job).build();
            Date date = scheduler.scheduleJob(job, trigger);
            //Date date2 = scheduler.scheduleJob(trigger2);
            System.out.println("----scheduler date ---" + date);
            //System.out.println("----scheduler date2 ---" + date2);
            scheduler.start();

            try {
                Thread.sleep(10000 * 60);
                scheduler.shutdown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}