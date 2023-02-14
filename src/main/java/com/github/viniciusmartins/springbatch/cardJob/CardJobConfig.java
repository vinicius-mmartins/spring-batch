package com.github.viniciusmartins.springbatch.cardJob;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


//@EnableBatchProcessing
@EnableScheduling
@Configuration
public class CardJobConfig {


    @Bean
    public Job cardJobScheduled(Step cardStepForScheduledJob, JobRepository jobRepository){
        return new JobBuilder("cardJobScheduled", jobRepository)
                .start(cardStepForScheduledJob)
                .build();
    }

    @Bean
    public Job cardJobForProductOne(Step cardStepForProduct1, JobRepository jobRepository){
        return new JobBuilder("cardJobForProductOne", jobRepository)
                .start(cardStepForProduct1)
                .build();
    }

    @Bean
    public Job cardJobForProductTwo(Step cardStepForProduct2, JobRepository jobRepository){
        return new JobBuilder("cardJobForProductTwo", jobRepository)
                .start(cardStepForProduct2)
                .build();
    }



    //job parameter builder bean
    @Bean
    public JobParametersBuilder jobParametersBuilder(){
        return new JobParametersBuilder();
    }

}
