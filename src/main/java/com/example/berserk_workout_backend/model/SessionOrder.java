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
    @JoinColumn(name="session_id")
    private Session session;

    private Integer exerciseNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="exercise_id")
    private Exercise exercise;

}
