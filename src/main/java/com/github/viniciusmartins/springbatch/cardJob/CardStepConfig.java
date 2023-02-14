package com.github.viniciusmartins.springbatch.cardJob;


import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.classify.Classifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
public class CardStepConfig {


    @Bean
    public Step cardStepForScheduledJob(JobRepository jobRepository, PlatformTransactionManager transactionManager){
        return new StepBuilder("cardStepForScheduledJob", jobRepository)
                .<String, String>chunk(1, transactionManager)
                .reader(new CardJobItemReader(TypeEnum.DEFAULT))
                .writer(itemWriter())
                .build();
    }

    @Bean
    public Step cardStepForProduct1(JobRepository jobRepository, PlatformTransactionManager transactionManager){
        return new StepBuilder("cardStepForProduct1", jobRepository)
                .<String, String>chunk(1, transactionManager)
                .reader(new CardJobItemReader(TypeEnum.TYPE_1))
                .writer(itemWriter())
                .build();
    }

    @Bean
    public Step cardStepForProduct2(JobRepository jobRepository, PlatformTransactionManager transactionManager){
        return new StepBuilder("cardStepForProduct2", jobRepository)
                .<String, String>chunk(1, transactionManager)
                .reader(new CardJobItemReader(TypeEnum.TYPE_2))
                .writer(itemWriter())
                .build();
    }

    Classifier classifier;



    //pra colocar um writer simples logo pq ele ta exigindo
    @Bean
    public ItemWriter<String> itemWriter(){
        return chunk -> {
            System.out.println("written");
        };
    }


}
