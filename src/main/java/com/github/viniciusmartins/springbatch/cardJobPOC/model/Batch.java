package com.github.viniciusmartins.springbatch.cardJobPOC.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@Table(name = "batch")
public class Batch {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private List<BatchItem> batchItems;
    private BigDecimal batchValue;
    private LocalDate batchDate;

    private BatchStatus status;

}
