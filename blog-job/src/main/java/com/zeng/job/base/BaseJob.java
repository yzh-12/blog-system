package com.zeng.job.base;

import org.quartz.JobDetail;
import org.quartz.Trigger;

public interface BaseJob {

    JobDetail buildJob();

    Trigger buildTrigger();
}
