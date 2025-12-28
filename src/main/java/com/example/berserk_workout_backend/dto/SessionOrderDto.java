package com.example.berserk_workout_backend.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SessionOrderDto {
    private Long id;
    private Long sessionId;
    private String sessionTitle;
    private Long exerciseId;
    private String exerciseName;
    private Integer exerciseNo;
    private List<SetLogDto> setLogs;
}
