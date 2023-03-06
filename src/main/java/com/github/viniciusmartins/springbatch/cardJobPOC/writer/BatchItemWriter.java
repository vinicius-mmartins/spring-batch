package com.github.viniciusmartins.springbatch.cardJobPOC.writer;

import com.github.viniciusmartins.springbatch.cardJobPOC.model.BatchItem;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class BatchItemWriter implements ItemWriter<BatchItem> {
    @Override
    public void write(Chunk chunk) throws Exception {

    }
}
