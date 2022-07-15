package com.zeng.job.trigger;

import org.quartz.CronScheduleBuilder;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

public class Triggers {

    public static Trigger startAtNowExcAtMidDay() {
        return TriggerBuilder
                .newTrigger()
                .withIdentity("startAtNowExcAtMidDay", "job")
                .withDescription("trigger at mid day.")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 12 * * ?"))
                .build();
    }

    public static Trigger demoTrigger() {
        return TriggerBuilder
                .newTrigger()
                .withIdentity("demo", "job")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(2)
                        .repeatForever())
                .build();
    }
}
