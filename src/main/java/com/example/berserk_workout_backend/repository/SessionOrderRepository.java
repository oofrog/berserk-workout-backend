package com.example.berserk_workout_backend.repository;

import com.example.berserk_workout_backend.model.SessionOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionOrderRepository extends JpaRepository<SessionOrder, Long> {
    List<SessionOrder> findAllByWorkoutSessionId(Long workoutSessionId);
}
