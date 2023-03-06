package com.github.viniciusmartins.springbatch.cardJobPOC.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
@Builder
@Entity
@Table(name = "batch_item")
public class BatchItem {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal value;
    private LocalDate batchDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id")
    private Batch batch;

}
