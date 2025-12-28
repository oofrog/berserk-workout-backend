package com.example.berserk_workout_backend.controller;

import com.example.berserk_workout_backend.dto.WorkoutSessionDto;
import com.example.berserk_workout_backend.service.SessionOrderService;
import com.example.berserk_workout_backend.service.WorkoutSessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/session")
@RequiredArgsConstructor
@Slf4j
public class WorkoutSessionController {
    private final WorkoutSessionService workoutSessionService;
    private final SessionOrderService sessionOrderService;

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
}
