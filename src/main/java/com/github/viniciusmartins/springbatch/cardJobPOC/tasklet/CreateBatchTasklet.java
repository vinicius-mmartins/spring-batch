package com.github.viniciusmartins.springbatch.cardJobPOC.tasklet;

import com.github.viniciusmartins.springbatch.cardJobPOC.model.Batch;
import com.github.viniciusmartins.springbatch.cardJobPOC.model.BatchStatus;
import com.github.viniciusmartins.springbatch.cardJobPOC.repository.BatchRepo;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static com.github.viniciusmartins.springbatch.cardJobPOC.model.BatchStatus.PROCESSING;


@Component
public class CreateBatchTasklet implements Tasklet {

    @Autowired
    private BatchRepo repo;


    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        Batch batch = repo.save(Batch.builder().status(PROCESSING).build());

        chunkContext.getStepContext().getJobExecutionContext().put("batchId", batch.getId());

        return RepeatStatus.FINISHED;
    }

}
