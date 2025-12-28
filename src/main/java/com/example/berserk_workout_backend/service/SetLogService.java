package com.example.berserk_workout_backend.service;

import com.example.berserk_workout_backend.dto.SetLogDto;
import com.example.berserk_workout_backend.model.SetLog;
import com.example.berserk_workout_backend.repository.SetLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SetLogService {
    private final SetLogRepository setLogRepository;

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
}
