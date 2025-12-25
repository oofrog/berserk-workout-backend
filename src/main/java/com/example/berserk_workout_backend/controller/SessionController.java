package com.example.berserk_workout_backend.controller;

import com.example.berserk_workout_backend.dto.SessionDto;
import com.example.berserk_workout_backend.service.SessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/session")
@RequiredArgsConstructor
@Slf4j
public class SessionController {
    private final SessionService sessionService;

    @GetMapping
    public String getSession(Model model) {
        List<SessionDto> sessions = sessionService.findAll();
        model.addAttribute("sessions", sessions);
        return "session";
    }
}
