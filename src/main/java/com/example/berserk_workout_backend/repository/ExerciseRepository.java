package com.example.berserk_workout_backend.repository;

import com.example.berserk_workout_backend.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
