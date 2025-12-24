package com.example.berserk_workout_backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SessionOrderDto {
    private Long id;
    private Long sessionId;
    private Integer excerciseId;
    private Integer excerciseNo;
}
