package com.casino.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_readings")
public class Reading {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "initialEntry")
    private Integer initialEntry;

    @Column(name = "finalEntry")
    private Integer finalEntry;

    @Column(name = "initialExit")
    private Integer initialExit;

    @Column(name = "finalExit")
    private Integer finalExit;

    @Column(name = "resultExit")
    private Double resultExit;

    @Column(name = "resultEntry")
    private Double resultEntry;

    private Double result;

    @ManyToOne
    @JoinColumn(name = "machine_id", nullable = false)
    private Machine machine;
}
