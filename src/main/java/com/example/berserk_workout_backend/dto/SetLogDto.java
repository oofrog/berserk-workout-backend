package com.example.berserk_workout_backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SetLogDto {
    private Long id;
    private Long weight;
    private Long reps;
    private String complete;
}
