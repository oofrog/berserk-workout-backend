package com.example.berserk_workout_backend.repository;

import com.example.berserk_workout_backend.model.Excercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExcerciseRepository extends JpaRepository<Excercise, Long> {
}
