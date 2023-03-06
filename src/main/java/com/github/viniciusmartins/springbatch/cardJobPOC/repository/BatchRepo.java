package com.github.viniciusmartins.springbatch.cardJobPOC.repository;

import com.github.viniciusmartins.springbatch.cardJobPOC.model.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepo extends JpaRepository<Batch, Long> {
}
