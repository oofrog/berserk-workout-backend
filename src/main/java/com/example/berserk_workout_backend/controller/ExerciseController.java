package com.example.berserk_workout_backend.controller;

import com.example.berserk_workout_backend.dto.ExerciseDto;
import com.example.berserk_workout_backend.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("exercise")
@RequiredArgsConstructor
@Slf4j
public class ExerciseController {
    private final ExerciseService exerciseService;

    @GetMapping("/add")
    public String getExerciseAdd(){
        return "exercise-add";
    }

    @PostMapping("/add")
    public String addExercise(@RequestParam("exerciseName") String exerciseName){
        exerciseService.create(exerciseName);
        return "redirect:/session/add";
    }

}
