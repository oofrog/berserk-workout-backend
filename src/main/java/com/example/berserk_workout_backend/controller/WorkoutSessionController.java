package com.example.berserk_workout_backend.controller;

import com.example.berserk_workout_backend.dto.SessionOrderDto;
import com.example.berserk_workout_backend.dto.WorkoutSessionDto;
import com.example.berserk_workout_backend.model.WorkoutSession;
import com.example.berserk_workout_backend.service.ExerciseService;
import com.example.berserk_workout_backend.service.SessionOrderService;
import com.example.berserk_workout_backend.service.WorkoutSessionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/session")
@RequiredArgsConstructor
@Slf4j
public class WorkoutSessionController {
    private final WorkoutSessionService workoutSessionService;
    private final SessionOrderService sessionOrderService;
    private final ExerciseService exerciseService;

    @GetMapping
    public String getWorkOutSession(Model model) {
        List<WorkoutSessionDto> workoutSessions = workoutSessionService.findAll();
        model.addAttribute("workoutSessions", workoutSessions);
        return "session-list";
    }

    @GetMapping("/{id}")
    public String getSessionDetailsById(@PathVariable Long id, Model model) {
        model.addAttribute("workoutSession", workoutSessionService.findById(id));
        model.addAttribute("sessionOrders", sessionOrderService.findAllBySessionId(id));
        return "session-details";
    }

    @GetMapping("/{id}/session-order")
    public String getSessionOrderBySessionId(@PathVariable("id") Long workoutSessionId,
                                             @RequestParam(value = "exerciseNo",defaultValue = "1") Integer exerciseNo,
                                             Model model) {

        SessionOrderDto sessionOrder = sessionOrderService.findByWorkoutSessionIdAndExerciseNo(workoutSessionId, exerciseNo);
        Boolean existNext = sessionOrderService.existNext(workoutSessionId,exerciseNo);

        model.addAttribute("sessionOrder", sessionOrder);
        model.addAttribute("existNext",existNext);

        return "session-order-details";
    }


    @GetMapping("/add")
    public String getExerciseList(@RequestParam(name="id",required = false) Long id, Model model) {

        model.addAttribute("exerciseList",exerciseService.findAll());

        if (id == null) {
            model.addAttribute("type", "new");
        } else{
            model.addAttribute("type", "patch");
        }

        return "session-add";
    }

    @PostMapping("/add")
    public String addWorkoutSession(@RequestParam(required = false) List<Long> exerciseIds){

        WorkoutSessionDto workoutSessionDto = workoutSessionService.create(exerciseIds);
        Long workoutSessionId = workoutSessionDto.getId();

        return "redirect:/session/"+workoutSessionId;
    }



}
