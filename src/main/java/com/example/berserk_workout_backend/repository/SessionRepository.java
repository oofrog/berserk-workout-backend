package com.example.berserk_workout_backend.repository;

import com.example.berserk_workout_backend.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
