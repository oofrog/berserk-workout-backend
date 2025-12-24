package com.example.berserk_workout_backend.repository;

import com.example.berserk_workout_backend.model.SessionOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionOrderReposiotry extends JpaRepository<SessionOrder, Long> {
}
