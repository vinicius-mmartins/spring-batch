package com.github.viniciusmartins.springbatch.cardJobPOC.reader;

import com.github.viniciusmartins.springbatch.cardJobPOC.model.ReadingObject;
import com.github.viniciusmartins.springbatch.cardJobPOC.repository.ReadingObjectRepo;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ObjectReader implements ItemReader<ReadingObject> {

    @Autowired
    private ReadingObjectRepo repo;


    @Override
    public ReadingObject read() throws Exception {
        return null;
    }

    private List<ReadingObject> findAll(){
        return repo.findAll();
    }

}
