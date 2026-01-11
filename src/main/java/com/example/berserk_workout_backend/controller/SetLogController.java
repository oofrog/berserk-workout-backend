package com.example.berserk_workout_backend.controller;

import com.example.berserk_workout_backend.dto.SessionOrderDto;
import com.example.berserk_workout_backend.dto.SetLogForm;
import com.example.berserk_workout_backend.service.SessionOrderService;
import com.example.berserk_workout_backend.service.SetLogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("set-log")
@RequiredArgsConstructor
@Slf4j
public class SetLogController {

    private final SessionOrderService sessionOrderService;
    private final SetLogService setLogService;

    @PostMapping("/add")
    public String addSet(@RequestParam("sessionOrderId") Long sessionOrderId, RedirectAttributes redirectAttributes) {
        SessionOrderDto sessionOrderDto = sessionOrderService.findById(sessionOrderId);
        setLogService.create(sessionOrderId);

        redirectAttributes.addAttribute("exerciseNo", sessionOrderDto.getExerciseNo());

        return "redirect:/session/"+sessionOrderDto.getWorkoutSessionId()+"/session-order";
    }

    @PostMapping("/delete")
    public String deleteLastSet(@RequestParam("sessionOrderId") Long sessionOrderId, RedirectAttributes redirectAttributes) {
        SessionOrderDto sessionOrderDto = sessionOrderService.findById(sessionOrderId);
        setLogService.deleteLastSet(sessionOrderId);
        redirectAttributes.addAttribute("exerciseNo", sessionOrderDto.getExerciseNo());

        return "redirect:/session/"+sessionOrderDto.getWorkoutSessionId()+"/session-order";
    }

    @PostMapping("/save")
    public String saveSet(@Valid @ModelAttribute("setLog") SetLogForm setLogForm,
                          BindingResult bindingResult,
                          @RequestHeader(value="Referer") String referer) {
        if (!bindingResult.hasErrors()) {
            setLogService.update(setLogForm);
        }
        return "redirect:"+referer;
    }
}
