package com.casino.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casino.api.model.Machine;

@Repository
public interface MachineRepository extends JpaRepository<Machine, Long>{
} 
