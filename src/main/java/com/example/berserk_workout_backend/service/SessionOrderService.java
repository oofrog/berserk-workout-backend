package com.example.berserk_workout_backend.service;

import com.example.berserk_workout_backend.dto.SessionOrderDto;
import com.example.berserk_workout_backend.dto.SetLogDto;
import com.example.berserk_workout_backend.model.SessionOrder;
import com.example.berserk_workout_backend.model.SetLog;
import com.example.berserk_workout_backend.repository.SessionOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionOrderService {

    private final SessionOrderRepository sessionOrderRepository;

    private SetLogDto mapToSetLogDto(SetLog setLog){
        return SetLogDto.builder()
                .id(setLog.getId())
                .sessionOrderId(setLog.getSessionOrder().getId())
                .setNo(setLog.getSetNo())
                .weight(setLog.getWeight())
                .reps(setLog.getReps())
                .complete(setLog.getComplete())
                .build();
    }

    private SessionOrderDto mapToSessionOrderDto(SessionOrder sessionOrder) {
        List<SetLog> setLogs = sessionOrder.getSetLogs();
        List<SetLogDto> setLogDtoList = setLogs.stream().map(this::mapToSetLogDto).toList();

        return SessionOrderDto.builder()
                .id(sessionOrder.getId())
                .sessionId(sessionOrder.getWorkoutSession().getId())
                .sessionTitle(sessionOrder.getWorkoutSession().getTitle())
                .exerciseId(sessionOrder.getExercise().getId())
                .exerciseName(sessionOrder.getExercise().getName())
                .exerciseNo(sessionOrder.getExerciseNo())
                .setLogs(setLogDtoList)
                .build();
    }

    public List<SessionOrderDto> findAllBySessionId(Long sessionId) {
        List<SessionOrder> sessionOrderList = sessionOrderRepository.findAllWithSetLogByWorkoutSessionId(sessionId);
        return sessionOrderList.stream().map(this::mapToSessionOrderDto).toList();
    }

}
