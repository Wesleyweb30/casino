package com.casino.api.controller;

import com.casino.api.model.Machine;
import com.casino.api.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/machines")
public class MachineController {

    @Autowired
    private MachineRepository machineRepository;

    @PostMapping
    public ResponseEntity<Machine> save(@RequestBody @Valid Machine data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(machineRepository.save(data));
    }

    @GetMapping
    public ResponseEntity<List<Machine>> findAll() {
        return ResponseEntity.ok().body(machineRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Machine> findById(@PathVariable Long id) {
        Optional<Machine> machine = machineRepository.findById(id);
        if (machine.isPresent()) {
            return ResponseEntity.ok().body(machine.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Machine> update(@PathVariable Long id, @RequestBody @Valid Machine data) {
        Optional<Machine> existingMachine = machineRepository.findById(id);
        if (existingMachine.isPresent()) {
            Machine updatedMachine = existingMachine.get();
            updatedMachine.setName(data.getName());
            updatedMachine.setCoin(data.getCoin());
            updatedMachine.setStatus(data.getStatus());
            return ResponseEntity.ok().body(machineRepository.save(updatedMachine));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (machineRepository.existsById(id)) {
            machineRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
