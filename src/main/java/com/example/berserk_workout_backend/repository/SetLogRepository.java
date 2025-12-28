package com.example.berserk_workout_backend.repository;

import com.example.berserk_workout_backend.model.SetLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SetLogRepository extends JpaRepository<SetLog, Long> {
}
