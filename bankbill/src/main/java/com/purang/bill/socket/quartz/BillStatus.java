package com.purang.bill.socket.quartz;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Company :普兰科技
 * Create User:周明
 * Create Date:12-8-24
 * Create Time:上午9:07
 */
public class BillStatus implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
    }
}