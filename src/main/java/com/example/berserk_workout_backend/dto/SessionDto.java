package com.example.berserk_workout_backend.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class SessionDto {
    private Long id;
    private String title;
    private Date createdAt;
}
