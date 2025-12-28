package com.example.berserk_workout_backend.service;

import com.example.berserk_workout_backend.dto.SessionOrderDto;
import com.example.berserk_workout_backend.model.SessionOrder;
import com.example.berserk_workout_backend.repository.SessionOrderRepository;
import com.example.berserk_workout_backend.repository.WorkoutSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionOrderService {

    private final WorkoutSessionRepository workoutSessionRepository;
    private final SessionOrderRepository sessionOrderRepository;

    private SessionOrderDto mapToSessionDto(SessionOrder sessionOrder) {
        return SessionOrderDto.builder()
                .id(sessionOrder.getId())
                .sessionId(sessionOrder.getWorkoutSession().getId())
                .sessionTitle(sessionOrder.getWorkoutSession().getTitle())
                .exerciseId(sessionOrder.getExercise().getId())
                .exerciseName(sessionOrder.getExercise().getName())
                .exerciseNo(sessionOrder.getExerciseNo())
                .build();
    }

    public List<SessionOrderDto> findAllBySessionId(Long sessionId) {
        List<SessionOrder> sessionOrderList = sessionOrderRepository.findAllByWorkoutSessionId(sessionId);
        return sessionOrderList.stream().map(this::mapToSessionDto).toList();
    }

}
