package com.example.berserk_workout_backend.service;

import com.example.berserk_workout_backend.dto.SetLogDto;
import com.example.berserk_workout_backend.dto.SetLogForm;
import com.example.berserk_workout_backend.model.SessionOrder;
import com.example.berserk_workout_backend.model.SetLog;
import com.example.berserk_workout_backend.repository.SessionOrderRepository;
import com.example.berserk_workout_backend.repository.SetLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SetLogService {
    private final SetLogRepository setLogRepository;
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

    public List<SetLogDto> create3x10x10(Long sessionOrderId){
        SessionOrder sessionOrder = sessionOrderRepository.findById(sessionOrderId).orElseThrow();

        Integer maxSetNo = setLogRepository.findMaxSetNoBySessionOrder(sessionOrder);
        int nextSetNo = (maxSetNo == null) ? 1 : maxSetNo + 1;

        List<SetLog> setLogs = new ArrayList<>();

        for(int i=0;i<3;i++) {
            SetLog setLog = SetLog.builder()
                    .sessionOrder(sessionOrder)
                    .setNo(nextSetNo++)
                    .weight(10)
                    .reps(10)
                    .complete("N").build();
            setLogs.add(setLogRepository.save(setLog));
        }
        return setLogs.stream().map(this::mapToSetLogDto).toList();
    }

    public SetLogDto create(Long sessionOrderId){

        SessionOrder sessionOrder = sessionOrderRepository.findById(sessionOrderId).orElseThrow();

        Integer maxSetNo = setLogRepository.findMaxSetNoBySessionOrder(sessionOrder);
        int nextSetNo = (maxSetNo == null) ? 1 : maxSetNo + 1;
        int weight = 10;
        int reps = 10;

        if (maxSetNo != null) {
            SetLog priorSet = setLogRepository.findBySessionOrderAndSetNo(sessionOrder, maxSetNo);
            if (priorSet != null) {
                weight = priorSet.getWeight();
                reps = priorSet.getReps();
            }
        }

        SetLog setLog = SetLog.builder()
                .sessionOrder(sessionOrder)
                .setNo(nextSetNo)
                .weight(weight)
                .reps(reps)
                .complete("N")
                .build();

        setLogRepository.save(setLog);
        return mapToSetLogDto(setLog);
    }

    public void deleteLastSet(Long sessionOrderId){
        SessionOrder sessionOrder = sessionOrderRepository.findById(sessionOrderId).orElseThrow();

        Integer maxSetNo = setLogRepository.findMaxSetNoBySessionOrder(sessionOrder);

        if (maxSetNo != null) {
            SetLog setLog = setLogRepository.findBySessionOrderAndSetNo(sessionOrder, maxSetNo);
            setLogRepository.delete(setLog);
        }
    }

    public SetLogDto update(SetLogForm setLogForm){
        SetLog setLog = setLogRepository.findById(setLogForm.getId()).orElseThrow();
        setLog.setWeight(setLogForm.getWeight());
        setLog.setReps(setLogForm.getReps());
        setLog.setComplete(setLogForm.getComplete());

        setLogRepository.save(setLog);
        return mapToSetLogDto(setLog);
    }

}
