package com.github.viniciusmartins.springbatch.cardJobPOC.processor;

import com.github.viniciusmartins.springbatch.cardJobPOC.model.BatchItem;
import com.github.viniciusmartins.springbatch.cardJobPOC.model.ReadingObject;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class ObjectIntoBatchItemProcessor implements ItemProcessor<ReadingObject, BatchItem> {

    @Override
    public BatchItem process(ReadingObject item) throws Exception {
        return null;
    }
}
