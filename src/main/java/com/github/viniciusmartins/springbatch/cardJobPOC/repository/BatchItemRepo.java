package com.github.viniciusmartins.springbatch.cardJobPOC.repository;

import com.github.viniciusmartins.springbatch.cardJobPOC.model.BatchItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchItemRepo extends JpaRepository<BatchItem, Long> {
}
