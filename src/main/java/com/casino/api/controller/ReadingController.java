package com.casino.api.controller;

import com.casino.api.model.Machine;
import com.casino.api.model.Reading;
import com.casino.api.repository.MachineRepository;
import com.casino.api.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/readings")
public class ReadingController {

    @Autowired
    private ReadingRepository readingRepository;

    @Autowired
    private MachineRepository machineRepository;

    @PostMapping
    public ResponseEntity<Reading> save(@RequestBody @Valid Reading reading) {
        Optional<Machine> machine = machineRepository.findById(reading.getMachine().getId());
        if (machine.isPresent()) {
            reading.setMachine(machine.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(readingRepository.save(reading));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Reading>> findAll() {
        return ResponseEntity.ok().body(readingRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reading> findById(@PathVariable Long id) {
        Optional<Reading> reading = readingRepository.findById(id);
        if (reading.isPresent()) {
            return ResponseEntity.ok().body(reading.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reading> update(@PathVariable Long id, @RequestBody @Valid Reading data) {
        Optional<Reading> existingReading = readingRepository.findById(id);
        if (existingReading.isPresent()) {
            Reading updatedReading = existingReading.get();
            updatedReading.setInitialEntry(data.getInitialEntry());
            updatedReading.setFinalEntry(data.getFinalEntry());
            updatedReading.setInitialExit(data.getInitialExit());
            updatedReading.setFinalExit(data.getFinalExit());
            updatedReading.setResult(data.getResult());
            return ResponseEntity.ok().body(readingRepository.save(updatedReading));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (readingRepository.existsById(id)) {
            readingRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
