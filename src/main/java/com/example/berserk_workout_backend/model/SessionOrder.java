package com.example.berserk_workout_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SessionOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="workout_session_id")
    private WorkoutSession workoutSession;

    private Integer exerciseNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="exercise_id")
    private Exercise exercise;

}
