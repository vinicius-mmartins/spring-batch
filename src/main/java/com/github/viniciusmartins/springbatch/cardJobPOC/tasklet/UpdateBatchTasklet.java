package com.github.viniciusmartins.springbatch.cardJobPOC.tasklet;

import com.github.viniciusmartins.springbatch.cardJobPOC.model.Batch;
import com.github.viniciusmartins.springbatch.cardJobPOC.repository.BatchRepo;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;

@Component
public class UpdateBatchTasklet implements Tasklet {

    @Autowired
    private BatchRepo repo;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        Long batchId = (Long) chunkContext.getStepContext().getJobExecutionContext().get("batchId");

        Batch batch = repo.findById(batchId).orElseThrow(() -> new RuntimeException("Not Found"));

        BigDecimal soma = new BigDecimal(BigInteger.ZERO);

        batch.getBatchItems().forEach(batchItem -> {
            soma.add(batchItem.getValue());
        });
        batch.setBatchValue(soma);

        return RepeatStatus.FINISHED;
    }
}
