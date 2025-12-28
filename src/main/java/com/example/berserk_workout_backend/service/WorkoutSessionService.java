package com.example.berserk_workout_backend.service;

import com.example.berserk_workout_backend.dto.WorkoutSessionDto;
import com.example.berserk_workout_backend.model.WorkoutSession;
import com.example.berserk_workout_backend.repository.WorkoutSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutSessionService {
    private final WorkoutSessionRepository workoutSessionRepository;

    private WorkoutSessionDto mapToSessionDto(WorkoutSession workoutSession) {
        return WorkoutSessionDto.builder()
                .id(workoutSession.getId())
                .title(workoutSession.getTitle()).build();
    }

    public List<WorkoutSessionDto> findAll(){
        List<WorkoutSession> workoutSessions = workoutSessionRepository.findAll();
        return workoutSessions.stream().map(this::mapToSessionDto).toList();
    }

    public WorkoutSessionDto findById(Long id) {
        return workoutSessionRepository.findById(id).map(this::mapToSessionDto).orElseThrow();
    }
}
