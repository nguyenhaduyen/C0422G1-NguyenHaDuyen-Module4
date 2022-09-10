package com.example.employee.repository;

import com.example.employee.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position,Integer> {
}
