package com.example.berserk_workout_backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExcerciseDto {
    private Long id;
    private String name;
}
