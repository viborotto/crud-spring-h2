package com.example.marcaponto.repository;

import com.example.marcaponto.model.BatePonto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BatePontoRepository extends CrudRepository<BatePonto, Long> {
}
