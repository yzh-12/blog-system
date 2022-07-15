package com.zeng.scheduler;

import com.zeng.job.base.BaseJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Scheduler;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class InitScheduler implements ApplicationRunner {
    private Scheduler scheduler;
    private List<BaseJob> jobs;

    public InitScheduler(Scheduler scheduler, List<BaseJob> jobs) {
        this.scheduler = scheduler;
        this.jobs = jobs;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (BaseJob job : jobs) {
            scheduler.scheduleJob(job.buildJob(), job.buildTrigger());
        }
        log.info("all jobs scheduler finish.");
    }

}
