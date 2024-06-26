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

/**
 * Represents a reading associated with a specific machine in the casino.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_readings")
public class Reading {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "initial_entry")
    private Integer initialEntry;

    @Column(name = "final_entry")
    private Integer finalEntry;

    @Column(name = "initial_exit")
    private Integer initialExit;

    @Column(name = "final_exit")
    private Integer finalExit;

    @Column(name = "result_exit")
    private Double resultExit;

    @Column(name = "result_entry")
    private Double resultEntry;

    private Double result;

    @ManyToOne
    @JoinColumn(name = "machine_id", nullable = false)
    private Machine machine;
}
