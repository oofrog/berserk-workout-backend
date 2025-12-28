package com.example.berserk_workout_backend.repository;

import com.example.berserk_workout_backend.model.WorkoutSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutSessionRepository extends JpaRepository<WorkoutSession, Long> {
}
