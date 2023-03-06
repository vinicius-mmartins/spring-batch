package com.github.viniciusmartins.springbatch.cardJobPOC;

import com.github.viniciusmartins.springbatch.cardJobPOC.model.ReadingObject;
import com.github.viniciusmartins.springbatch.cardJobPOC.repository.ReadingObjectRepo;
import lombok.SneakyThrows;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
public class Controller {

    @Autowired
    private ReadingObjectRepo repo;
    @Autowired
    private JobLauncher launcher;
    @Autowired
    @Qualifier("cardJob")
    private Job job;

    @PostMapping(value = "/populate", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> populateBase(){

        List<ReadingObject> readingObjects = new ArrayList<>();
        readingObjects.add(ReadingObject.builder().value(BigDecimal.TEN).build());
        readingObjects.add(ReadingObject.builder().value(BigDecimal.TEN).build());
        readingObjects.add(ReadingObject.builder().value(BigDecimal.TEN).build());
        readingObjects.add(ReadingObject.builder().value(BigDecimal.TEN).build());
        readingObjects.add(ReadingObject.builder().value(BigDecimal.TEN).build());
        readingObjects.add(ReadingObject.builder().value(BigDecimal.TEN).build());
        readingObjects.add(ReadingObject.builder().value(BigDecimal.TEN).build());
        readingObjects.add(ReadingObject.builder().value(BigDecimal.TEN).build());
        readingObjects.add(ReadingObject.builder().value(BigDecimal.TEN).build());
        readingObjects.add(ReadingObject.builder().value(BigDecimal.TEN).build());
        readingObjects.add(ReadingObject.builder().value(BigDecimal.TEN).build());

        try {
            repo.saveAll(readingObjects);
        } catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
        return ResponseEntity.status(200).body("Created!");
    }

    @PostMapping(value = "/execute")
    @SneakyThrows
    public ResponseEntity<String> execute(){
        launcher.run(job, new JobParametersBuilder().toJobParameters());
        return ResponseEntity.status(200).body("Job Executado");
    }


}
