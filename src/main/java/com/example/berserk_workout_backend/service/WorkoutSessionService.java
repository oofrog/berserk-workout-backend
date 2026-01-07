package com.example.berserk_workout_backend.service;

import com.example.berserk_workout_backend.dto.SessionOrderDto;
import com.example.berserk_workout_backend.dto.SetLogDto;
import com.example.berserk_workout_backend.dto.WorkoutSessionDto;
import com.example.berserk_workout_backend.model.Exercise;
import com.example.berserk_workout_backend.model.SessionOrder;
import com.example.berserk_workout_backend.model.WorkoutSession;
import com.example.berserk_workout_backend.repository.ExerciseRepository;
import com.example.berserk_workout_backend.repository.SessionOrderRepository;
import com.example.berserk_workout_backend.repository.WorkoutSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutSessionService {
    private final WorkoutSessionRepository workoutSessionRepository;
    private final SessionOrderRepository sessionOrderRepository;
    private final ExerciseRepository exerciseRepository;
    private final SessionOrderService sessionOrderService;
    private final SetLogService setLogService;

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

    public WorkoutSessionDto create(List<Long> exerciseIds) {
        WorkoutSession workoutSession = WorkoutSession.builder()
                .title("새 루틴").build();
        workoutSessionRepository.save(workoutSession);

        for (Long exerciseId : exerciseIds) {
            Exercise exercise = exerciseRepository.findById(exerciseId).orElseThrow();
            SessionOrderDto sessionOrderDto = sessionOrderService.create(workoutSession.getId(), exercise.getId());
            setLogService.create3x10x10(sessionOrderDto.getId());
        }

        workoutSessionRepository.save(workoutSession);
        return mapToSessionDto(workoutSession);
    }
}
