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
@Table(name = "reading_object")
public class ReadingObject {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private BigDecimal value;
    private LocalDate batchDate;

}
