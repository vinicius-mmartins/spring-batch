package com.github.viniciusmartins.springbatch.cardJobPOC.repository;

import com.github.viniciusmartins.springbatch.cardJobPOC.model.ReadingObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingObjectRepo extends JpaRepository<ReadingObject, Long> {
}
