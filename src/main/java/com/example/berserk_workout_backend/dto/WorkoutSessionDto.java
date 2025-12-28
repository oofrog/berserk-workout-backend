package com.example.berserk_workout_backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkoutSessionDto {
    private Long id;
    private String title;
}
