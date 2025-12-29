package com.example.berserk_workout_backend.service;

import com.example.berserk_workout_backend.dto.ExerciseDto;
import com.example.berserk_workout_backend.model.Exercise;
import com.example.berserk_workout_backend.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;

    private ExerciseDto mapToExerciseDto(Exercise exercise) {
        return ExerciseDto.builder()
                .id(exercise.getId())
                .name(exercise.getName())
                .build();
    }

    public List<ExerciseDto> findAll(){
        List<Exercise> exercises = exerciseRepository.findAll();
        return exercises.stream().map(this::mapToExerciseDto).toList();
    }
}
