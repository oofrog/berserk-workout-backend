package com.example.berserk_workout_backend.service;

import com.example.berserk_workout_backend.dto.SessionDto;
import com.example.berserk_workout_backend.model.Session;
import com.example.berserk_workout_backend.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionService {
    private final SessionRepository sessionRepository;

    private SessionDto mapToSessionDto(Session session) {
        return SessionDto.builder()
                .id(session.getId())
                .title(session.getTitle()).build();
    }

    public List<SessionDto> findAll(){
        List<Session> sessions = sessionRepository.findAll();
        return sessions.stream().map(this::mapToSessionDto).toList();
    }
}
