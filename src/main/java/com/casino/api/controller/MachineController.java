package com.casino.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.casino.api.model.Machine;
import com.casino.api.repository.MachineRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/machines")
public class MachineController {

    @Autowired
    private MachineRepository repository;

    @PostMapping
    public ResponseEntity<Machine> save(@RequestBody @Valid Machine data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(data));
    }

    @GetMapping
    public ResponseEntity<List<Machine>> findAll() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Machine> findById(@PathVariable Long id) {
        Optional<Machine> machine = repository.findById(id);
        if (machine.isPresent()) {
            return ResponseEntity.ok().body(machine.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Machine> update(@PathVariable Long id, @RequestBody @Valid Machine data) {
        Optional<Machine> existingMachine = repository.findById(id);
        if (existingMachine.isPresent()) {
            Machine updatedMachine = existingMachine.get();
            updatedMachine.setNome(data.getNome());
            updatedMachine.setMoeda(data.getMoeda());
            updatedMachine.setStatus(data.getStatus());
            return ResponseEntity.ok().body(repository.save(updatedMachine));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
