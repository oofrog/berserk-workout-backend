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

    @ManyToOne
    @JoinColumn(name="session_id")
    private Session session;

    private Integer excerciseNo;

    @ManyToOne
    @JoinColumn(name="excercise_id")
    private Excercise excercise;

}
