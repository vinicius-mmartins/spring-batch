package com.github.viniciusmartins.springbatch.cardJob;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class CardJobScheduler {


    private final Job cardJobScheduled;
    private final JobLauncher jobLauncher;
    private final JobParametersBuilder jobParametersBuilder;

    @Autowired
    public CardJobScheduler(/*@Qualifier("cardJobScheduled")*/ Job cardJobScheduled,
                                                               JobLauncher jobLauncher,
                                                               JobParametersBuilder jobParametersBuilder) {
        this.cardJobScheduled = cardJobScheduled;
        this.jobLauncher = jobLauncher;
        this.jobParametersBuilder = jobParametersBuilder;
    }

    @Scheduled(cron = "* * * * * *")
    public void launcher() throws Exception {
        jobLauncher.run(cardJobScheduled, jobParametersBuilder.toJobParameters());
    }

}


