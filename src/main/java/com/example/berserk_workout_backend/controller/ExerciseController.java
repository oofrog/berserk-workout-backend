package com.example.berserk_workout_backend.controller;

import com.example.berserk_workout_backend.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("exercise")
@RequiredArgsConstructor
@Slf4j
public class ExerciseController {
    private final ExerciseService exerciseService;

    @GetMapping("/add")
    public String getExerciseAdd(@RequestParam(value = "id",required = false)Long id, Model model){
        model.addAttribute("workoutSessionId",id);
        return "exercise-add";
    }

    @PostMapping("/add")
    public String addExercise(@RequestParam("exerciseName") String exerciseName,
                              @RequestParam(value = "id",required = false)Long id,
                              RedirectAttributes redirectAttributes) {
        exerciseService.create(exerciseName);
        if (id != null) {
            redirectAttributes.addAttribute("id",id);
        }
        return "redirect:/session/add";
    }
}
