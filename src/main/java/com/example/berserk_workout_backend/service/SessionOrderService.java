package com.example.berserk_workout_backend.service;

import com.example.berserk_workout_backend.dto.SessionOrderDto;
import com.example.berserk_workout_backend.model.SessionOrder;
import com.example.berserk_workout_backend.repository.SessionOrderRepository;
import com.example.berserk_workout_backend.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionOrderService {

    private final SessionRepository sessionRepository;
    private final SessionOrderRepository sessionOrderRepository;

    private SessionOrderDto mapToSessionDto(SessionOrder sessionOrder) {
        return SessionOrderDto.builder()
                .id(sessionOrder.getId())
                .sessionId(sessionOrder.getSession().getId())
                .sessionTitle(sessionOrder.getSession().getTitle())
                .exerciseId(sessionOrder.getExercise().getId())
                .exerciseName(sessionOrder.getExercise().getName())
                .exerciseNo(sessionOrder.getExerciseNo())
                .build();
    }

    public List<SessionOrderDto> findAllBySessionId(Long sessionId) {
        List<SessionOrder> sessionOrderList = sessionOrderRepository.findAllBySessionId(sessionId);
        return sessionOrderList.stream().map(this::mapToSessionDto).toList();
    }

}
