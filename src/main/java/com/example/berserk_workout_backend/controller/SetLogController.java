package com.example.berserk_workout_backend.controller;

import com.example.berserk_workout_backend.dto.SessionOrderDto;
import com.example.berserk_workout_backend.service.SessionOrderService;
import com.example.berserk_workout_backend.service.SetLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("set-log")
@RequiredArgsConstructor
@Slf4j
public class SetLogController {

    private final SessionOrderService sessionOrderService;
    private final SetLogService setLogService;

    @PostMapping("/add")
    public String addSet(@RequestParam("sessionOrderId") Long sessionOrderId){
        SessionOrderDto sessionOrderDto = sessionOrderService.findById(sessionOrderId);
        setLogService.create(sessionOrderId);

        return "redirect:/session/"+sessionOrderDto.getWorkoutSessionId();
    }
}
