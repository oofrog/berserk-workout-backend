package com.example.berserk_workout_backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SetLogDto {
    private Long id;
    private Long sessionOrderId;
    private Integer setNo;
    private Integer weight;
    private Integer reps;
    private String complete;
}
