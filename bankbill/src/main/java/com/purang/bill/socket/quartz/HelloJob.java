package com.purang.bill.socket.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Company :普兰科技
 * Create User:周明
 * Create Date:12-8-21
 * Create Time:下午1:37
 */
public class HelloJob implements Job {
    Logger logger = LoggerFactory.getLogger(HelloJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobKey key = context.getJobDetail().getKey();
        logger.info("-----job key---" + key.getName());
        logger.info("----hello--" + new Date());
    }
}