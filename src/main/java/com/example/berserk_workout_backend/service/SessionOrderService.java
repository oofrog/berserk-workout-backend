package com.example.berserk_workout_backend.service;

import com.example.berserk_workout_backend.dto.SessionOrderDto;
import com.example.berserk_workout_backend.dto.SetLogDto;
import com.example.berserk_workout_backend.model.Exercise;
import com.example.berserk_workout_backend.model.SessionOrder;
import com.example.berserk_workout_backend.model.SetLog;
import com.example.berserk_workout_backend.model.WorkoutSession;
import com.example.berserk_workout_backend.repository.ExerciseRepository;
import com.example.berserk_workout_backend.repository.SessionOrderRepository;
import com.example.berserk_workout_backend.repository.WorkoutSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class SessionOrderService {

    private final SessionOrderRepository sessionOrderRepository;
    private final WorkoutSessionRepository workoutSessionRepository;
    private final ExerciseRepository exerciseRepository;
    private final SetLogService setLogService;

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
        List<SetLogDto> setLogDtoList = (setLogs == null) ?
                Collections.emptyList() :
                setLogs.stream().map(this::mapToSetLogDto).toList();

        return SessionOrderDto.builder()
                .id(sessionOrder.getId())
                .workoutSessionId(sessionOrder.getWorkoutSession().getId())
                .workoutSessionTitle(sessionOrder.getWorkoutSession().getTitle())
                .exerciseId(sessionOrder.getExercise().getId())
                .exerciseName(sessionOrder.getExercise().getName())
                .exerciseNo(sessionOrder.getExerciseNo())
                .setLogs(setLogDtoList)
                .build();
    }

    public SessionOrderDto findById(Long id) {
        return sessionOrderRepository.findById(id).map(this::mapToSessionOrderDto).orElseThrow();
    }

    public List<SessionOrderDto> findAllBySessionId(Long sessionId) {
        List<SessionOrder> sessionOrderList = sessionOrderRepository.findAllWithSetLogByWorkoutSessionId(sessionId);
        return sessionOrderList.stream().map(this::mapToSessionOrderDto).toList();
    }

    public SessionOrderDto create(Long workoutSessionId,Long exerciseId) {

        WorkoutSession workoutSession = workoutSessionRepository.findById(workoutSessionId).orElseThrow();
        Exercise exercise = exerciseRepository.findById(exerciseId).orElseThrow();

        Integer maxExerciseNo = sessionOrderRepository.findMaxExerciseNoByWorkoutSession(workoutSession);
        int nextExerciseNo = (maxExerciseNo == null) ? 1 : maxExerciseNo + 1;

        SessionOrder sessionOrder = SessionOrder.builder()
                .workoutSession(workoutSession)
                .exercise(exercise)
                .exerciseNo(nextExerciseNo).build();

        sessionOrderRepository.save(sessionOrder);
        return mapToSessionOrderDto(sessionOrder);
    }

    public SessionOrderDto findByWorkoutSessionIdAndExerciseNo(Long workoutSessionId, Integer exerciseNo) {
        WorkoutSession workoutSession = workoutSessionRepository.findById(workoutSessionId).orElseThrow();

        SessionOrder sessionOrder = sessionOrderRepository.findByWorkoutSessionAndExerciseNo(workoutSession,exerciseNo);

        return mapToSessionOrderDto(sessionOrder);
    }

    public Boolean existNext(Long workoutSessionId, Integer exerciseNo) {
        WorkoutSession workoutSession = workoutSessionRepository.findById(workoutSessionId).orElseThrow();
        Integer maxExerciseNo = sessionOrderRepository.findMaxExerciseNoByWorkoutSession(workoutSession);

        if (maxExerciseNo==null || exerciseNo.equals(maxExerciseNo)) {
            return false;
        } else  {
            return true;
        }
    }

}
