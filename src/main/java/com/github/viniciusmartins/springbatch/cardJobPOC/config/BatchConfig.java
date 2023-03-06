package com.github.viniciusmartins.springbatch.cardJobPOC.config;


import com.github.viniciusmartins.springbatch.cardJobPOC.model.BatchItem;
import com.github.viniciusmartins.springbatch.cardJobPOC.model.ReadingObject;
import com.github.viniciusmartins.springbatch.cardJobPOC.processor.ObjectIntoBatchItemProcessor;
import com.github.viniciusmartins.springbatch.cardJobPOC.reader.ObjectReader;
import com.github.viniciusmartins.springbatch.cardJobPOC.tasklet.CreateBatchTasklet;
import com.github.viniciusmartins.springbatch.cardJobPOC.tasklet.UpdateBatchTasklet;
import com.github.viniciusmartins.springbatch.cardJobPOC.writer.BatchItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfig {

    @Autowired
    private CreateBatchTasklet createBatchTasklet;
    @Autowired
    private ObjectReader objectReader;
    @Autowired
    private ObjectIntoBatchItemProcessor objectProcessor;
    @Autowired
    private BatchItemWriter batchItemWriter;
    @Autowired
    private UpdateBatchTasklet updateBatchTasklet;



    @Bean
    public Job cardJob(Step createBatchStep,Step chunckStep, Step updateBatchStep, JobRepository jobRepository){
        return new JobBuilder("cardJob", jobRepository)
                .start(createBatchStep) // cria batch
                .next(chunckStep)  // processa criando batch item por objeto
                .next(updateBatchStep)  // atualiza batch status e ?valor
                .build();
    }

    @Bean
    public Step createBatchStep(JobRepository jobRepository, PlatformTransactionManager transactionManager){
        return new StepBuilder("createBatchStep", jobRepository)
                .tasklet(createBatchTasklet, transactionManager)
                .build();
    }

    @Bean
    public Step chunckStep(JobRepository jobRepository, PlatformTransactionManager transactionManager){
        return new StepBuilder("chunckStep", jobRepository)
                .<ReadingObject, BatchItem>chunk(2, transactionManager)
                .reader(objectReader)
                .processor(objectProcessor)
                .writer(batchItemWriter)
                .build();
    }

    @Bean
    public Step updateBatchStep(JobRepository jobRepository, PlatformTransactionManager transactionManager){
        return new StepBuilder("updateBatchStep", jobRepository)
                .tasklet(updateBatchTasklet, transactionManager)
                .build();
    }


}
