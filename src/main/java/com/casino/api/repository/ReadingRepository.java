package com.casino.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.casino.api.model.Reading;

public interface ReadingRepository extends JpaRepository<Reading, Long> {
}

