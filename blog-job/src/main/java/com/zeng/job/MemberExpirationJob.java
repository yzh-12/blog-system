package com.zeng.job;

import com.zeng.feign.MessageClient;
import com.zeng.feign.UserClient;
import com.zeng.feign.po.UserRolePo;
import com.zeng.job.base.AbstractQuartzJobBean;
import com.zeng.job.trigger.Triggers;
import com.zeng.web.domain.BaseResult;
import org.quartz.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemberExpirationJob extends AbstractQuartzJobBean {

    private UserClient userClient;
    private MessageClient messageClient;


    public MemberExpirationJob(UserClient userClient, MessageClient messageClient) {
        this.userClient = userClient;
        this.messageClient = messageClient;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        BaseResult<List<UserRolePo>> result = userClient.findExpirationUser(15);
        System.out.println(result);
    }

    @Override
    public JobDetail buildJob() {
        return JobBuilder.newJob(MemberExpirationJob.class)
                .withIdentity("expirationJob")
                .withDescription("member expiration job.")
                .build();
    }

    @Override
    public Trigger buildTrigger() {
        return Triggers.demoTrigger();
    }
}
